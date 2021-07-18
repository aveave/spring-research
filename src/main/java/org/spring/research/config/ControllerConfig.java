package org.spring.research.config;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


/**
 * @author EAverkin
 */
public class ControllerConfig implements WebApplicationInitializer
{

    @Override
    public void onStartup(ServletContext sc) throws ServletException {
        AnnotationConfigWebApplicationContext root = new AnnotationConfigWebApplicationContext();
        root.register(WebAppConfig.class);
        root.setServletContext(sc);
        sc.addListener(new ContextLoaderListener(root));

        DispatcherServlet dv = new DispatcherServlet(root);

        ServletRegistration.Dynamic appServlet = sc.addServlet("test-mvc", dv);
        appServlet.setLoadOnStartup(1);
        appServlet.addMapping("/test/*", "/hello", "/order/*", "/orders");
    }
}
