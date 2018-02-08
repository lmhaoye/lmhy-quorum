package com.lmhy.quorum;

import com.lmhy.quorum.ext.Bcos;
import com.lmhy.quorum.ext.BcosConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;

import javax.annotation.PostConstruct;
import javax.servlet.MultipartConfigElement;

@SpringBootApplication
@Slf4j
public class LmhyQuorumApplication {

    @Autowired
    private BcosConfig bcosConfig;

    @PostConstruct
    public void initBcos() {
        new Bcos(bcosConfig);
        log.info("Bcos config is load...");
    }

    @Bean
    public MultipartConfigElement multipartConfigElement(){
        MultipartConfigFactory factory = new MultipartConfigFactory();
        factory.setMaxFileSize("1MB");
        factory.setMaxRequestSize("5MB");
        return factory.createMultipartConfig();
    }

    public static void main(String[] args) {
        SpringApplication.run(LmhyQuorumApplication.class, args);
    }
}
