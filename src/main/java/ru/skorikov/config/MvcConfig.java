package ru.skorikov.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC configuration.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {

    /**
     * Registry view controllers.
     * @param registry param.
     */
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("home");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/**");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static")
                .addResourceLocations("classpath:/tamplates");
    }
}
