package com;


import com.dao.EmployeeDao;
import com.resources.EmployeeResource;
import com.service.EmployeeService;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

public class TestApplication extends Application<Configuration> {

    public static  void main (String [] args) throws Exception  {
        new TestApplication().run("server");
    }

    @Override
    public void run(Configuration configuration, Environment environment) throws Exception {
        enableCors(environment);
        EmployeeDao dao = new EmployeeDao();
        EmployeeService service = new EmployeeService(dao);
        EmployeeResource employeeResource = new EmployeeResource(service);
        environment.jersey().register(employeeResource);
    }

    private void enableCors(final Environment environment) {
        final FilterRegistration.Dynamic cors = environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "Origin,Authorization,Content-Type,Accept");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

    }

}
