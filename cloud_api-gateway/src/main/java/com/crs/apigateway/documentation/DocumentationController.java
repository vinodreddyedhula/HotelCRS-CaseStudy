package com.crs.apigateway.documentation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

@Component
@Primary
@EnableAutoConfiguration
public class DocumentationController implements SwaggerResourcesProvider {
	    
	  private SwaggerConfiguration swaggerConfiguration;

	    @Autowired
	    public DocumentationController(SwaggerConfiguration swaggerConfiguration){
	        this.swaggerConfiguration = swaggerConfiguration;
	    }

	    @Override
	    public List get() {
	        List resources = new ArrayList<>();
	        for(DocumentationResource resource : this.swaggerConfiguration.getResources()){
	            resources.add(createSwaggerResource(resource));
	        }

	        return resources;
	    }

	    private SwaggerResource createSwaggerResource(DocumentationResource resource) {
	    	var swaggerResource = new SwaggerResource();
	        swaggerResource.setName(resource.getName());
	        swaggerResource.setUrl(resource.getUrl());
	        swaggerResource.setSwaggerVersion(resource.getVersion());
	        return swaggerResource;
	    }
}
