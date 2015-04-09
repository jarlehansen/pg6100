package no.nith.pg6100;

import com.wordnik.swagger.jaxrs.config.BeanConfig;
import com.wordnik.swagger.jaxrs.listing.ApiDeclarationProvider;
import com.wordnik.swagger.jaxrs.listing.ApiListingResource;
import com.wordnik.swagger.jaxrs.listing.ApiListingResourceJSON;
import com.wordnik.swagger.jaxrs.listing.ResourceListingProvider;
import no.nith.pg6100.service.CustomerService;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class ApplicationConfig extends Application {

    public ApplicationConfig() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.2");
        beanConfig.setBasePath("http://localhost:8080/8_2-swagger-1.0-SNAPSHOT/rest");
        beanConfig.setResourcePackage("no.nith.pg6100.service");
        beanConfig.setScan(true);
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<>();
        resources.add(CustomerService.class);

        resources.add(ApiListingResource.class);
        resources.add(ApiDeclarationProvider.class);
        resources.add(ApiListingResourceJSON.class);
        resources.add(ResourceListingProvider.class);

        return resources;
    }
}
