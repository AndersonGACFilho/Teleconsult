package br.com.inf.es.telemedicina.config.swagger;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
public class SwaggerConfig {                                    
    @Bean
    public GroupedOpenApi  api() { 
        return GroupedOpenApi 
          .builder()                                  
          .group("br.com.es.telemedicina")             
          .pathsToMatch("/**")
          .packagesToExclude("br.com.inf.es.telemedicina.modelo")
          .build();
    }
}
