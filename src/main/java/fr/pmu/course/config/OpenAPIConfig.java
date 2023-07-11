package fr.pmu.course.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenAPIConfig {

    @Value("${course.api.dev-url}")
    private String devUrl;

    @Value("${course.api.prod-url}")
    private String prodUrl;

    @Value("${course.api.version}")
    private String apiVersion;

    @Value("${course.api.title}")
    private String title;

    @Value("${course.api.description}")
    private String description;

    @Value("${course.api.termsOfService}")
    private String termsOfService;

    @Bean
    public OpenAPI myOpenAPI() {
        Server devServer = new Server();
        devServer.setUrl(devUrl);
        devServer.setDescription("Server URL in Development environment");

        Server prodServer = new Server();
        prodServer.setUrl(prodUrl);
        prodServer.setDescription("Server URL in Production environment");

        Contact contact = new Contact();
        contact.setEmail("api.course@pmu.paris.fr");
        contact.setName("JCM");
        contact.setUrl("https://pmu.paris.fr");

        License mitLicense = new License().name("MIT License").url("https://choosealicense.com/licenses/mit/");

        Info info = new Info()
                .title(title)
                .version(apiVersion)
                .contact(contact)
                .description(description)
                .termsOfService(termsOfService)
                .license(mitLicense);

        return new OpenAPI().info(info).servers(List.of(devServer, prodServer));
    }
}