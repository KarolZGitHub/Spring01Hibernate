package pl.coderslab.init;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import pl.coderslab.app.AppConfiguration;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletRegistration;

public class AppInitialization implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) {

        // create spring context
        AnnotationConfigWebApplicationContext context =
                new AnnotationConfigWebApplicationContext();

        // configure spring context
        context.register(AppConfiguration.class);
        context.setServletContext(servletContext);

        // create DispatcherServlet
        ServletRegistration.Dynamic dispatcherServlet =
                servletContext.addServlet("dispatcherServlet", new DispatcherServlet(context));

        // configure DispatcherServlet
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("/");

        //setting UTF-8 format
        FilterRegistration.Dynamic fr = servletContext.addFilter("encodingFilter",
                new CharacterEncodingFilter());
        fr.setInitParameter("encoding", "UTF-8");
        fr.setInitParameter("forceEncoding", "true");
        fr.addMappingForUrlPatterns(null, true, "/*");

    }

}