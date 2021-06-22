package com.crs.apigateway.documentation;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "swagger")
public class SwaggerConfiguration {
	  private List<DocumentationResource> resources;

	    public List<DocumentationResource> getResources() {
	        return resources;
	    }

	    public void setResources(List<DocumentationResource> resources) {
	        this.resources = resources;
	    }
}
