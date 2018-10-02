package com.tm.perf.tool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableAutoConfiguration
@EnableWebMvc
@ComponentScan(basePackages = {"com.tm.perf.tool"})
public class Application extends SpringBootServletInitializer {
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(Application.class);
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
//    @Bean(name = "messageSource")
//    public ReloadableResourceBundleMessageSource messageSource() {
//        ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
//        messageBundle.setBasename("classpath:messages/messages");
//        messageBundle.setDefaultEncoding("UTF-8");
//        return messageBundle;
//    }
}
