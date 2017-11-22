package hitado.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hitado.apps.web.configuration.ViewControllerConfiguration;

@SpringBootApplication
@Configuration
@Import({ ViewControllerConfiguration.class })
@EnableAutoConfiguration
public class SpringBootApps extends SpringBootServletInitializer {

    public static void main(String... strings) {
        SpringApplication.run(SpringBootApps.class, strings);
    }

    @Override
    protected SpringApplicationBuilder configure(
            SpringApplicationBuilder application) {
        return application.sources(SpringBootApps.class);
    }

}
