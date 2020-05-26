package com.kong.lts.ltsjobclient;

import com.github.ltsopensource.spring.boot.annotation.EnableJobClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Gdc
 */
@EnableJobClient
@SpringBootApplication
public class LtsJobclientApplication {

    public static void main(String[] args) {
        SpringApplication.run(LtsJobclientApplication.class, args);
    }

}
