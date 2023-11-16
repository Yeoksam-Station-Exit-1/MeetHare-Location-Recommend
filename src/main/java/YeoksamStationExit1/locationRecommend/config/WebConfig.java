package YeoksamStationExit1.locationRecommend.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
            .allowedOrigins("https://meethare.site",  "http://localhost:3000")
            .allowedMethods("*")
            .allowedHeaders("*")
            .exposedHeaders("*")
            .allowedOriginPatterns("*")
            .allowCredentials(true);
    }
}