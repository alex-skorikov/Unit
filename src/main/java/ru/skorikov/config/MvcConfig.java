package ru.skorikov.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * MVC configuration.
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
/*    *//**
     * Path to file.
     *//*
    @Value("${upload.path}")
    private String uploadPath;*/

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
//                .addResourceLocations("file:///" + uploadPath + "/");
        registry.addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static")
                .addResourceLocations("classpath:/tamplates");
    }
}
