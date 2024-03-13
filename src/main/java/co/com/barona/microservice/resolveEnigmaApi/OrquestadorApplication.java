package co.com.barona.microservice.resolveEnigmaApi;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = { "co.com.barona.microservice.resolveEnigmaApi", "co.com.barona.microservice.resolveEnigmaApi.api" , "co.com.barona.microservice.resolveEnigmaApi.config"})
public class OrquestadorApplication{


    public static void main(String[] args) throws Exception {
        new SpringApplication(OrquestadorApplication.class).run(args);
    }
}
