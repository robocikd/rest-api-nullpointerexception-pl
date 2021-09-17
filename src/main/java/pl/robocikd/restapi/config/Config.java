package pl.robocikd.restapi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

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
                .select().apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }

}
