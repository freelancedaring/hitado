package hitado.apps;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import hitado.apps.web.configuration.ViewControllerConfiguration;
import hitado.apps.web.controller.HelloController;

@SpringBootApplication
@EnableAutoConfiguration
@Configuration
@Import({ ViewControllerConfiguration.class })
public class SpringBootApps {

    public static void main(String... strings) {

        SpringApplication.run(HelloController.class);

    }

}
