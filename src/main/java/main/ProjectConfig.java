package main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import services.LoggingAspect;
import services.SecurityAspect;

@Configuration
@ComponentScan(
        basePackages = {"proxies", "services", "repositories"}
)
@EnableAspectJAutoProxy
public class ProjectConfig {

    @Bean
    public LoggingAspect loggingAspect() {
        return new LoggingAspect();
    }

    @Bean
    public SecurityAspect securityAspect(){
        return new SecurityAspect();
    }
}
