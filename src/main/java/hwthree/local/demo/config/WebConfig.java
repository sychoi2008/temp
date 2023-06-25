package hwthree.local.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("https://localhost:8443", "http://localhost:3000")
                .allowedMethods("GET","POST", "OPTIONS","PUT","DELETE")
                .exposedHeaders("*")
                .allowCredentials(true)
                .maxAge(3000);
    }


}
