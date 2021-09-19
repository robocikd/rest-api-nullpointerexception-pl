package pl.robocikd.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiKey;
import springfox.documentation.service.AuthorizationScope;
import springfox.documentation.service.SecurityReference;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;


@Configuration
public class Config {

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.OAS_30)
                .apiInfo(new ApiInfoBuilder()
                        .title("RobocikD")
                        .description("demo API based on nullpointerexception.pl")
                        .version("0.0.1-SNAPSHOT")
                        .license("MIT")
                        .licenseUrl("https://opensource.org/licenses/MIT")
                        .build())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build()
                .securitySchemes(Collections.singletonList(createSchema()))
                .securityContexts(Collections.singletonList(createContext()));
    }

    private SecurityContext createContext() {
        return SecurityContext.builder().securityReferences(createRef()).build();
    }

    private List<SecurityReference> createRef() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("Authorization", authorizationScopes));
    }

    private ApiKey createSchema() {
        return new ApiKey("Authorization", "Authorization", "header");
    }
}
