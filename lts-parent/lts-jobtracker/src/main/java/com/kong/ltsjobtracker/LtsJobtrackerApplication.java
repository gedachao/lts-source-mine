package com.kong.ltsjobtracker;

import com.github.ltsopensource.spring.boot.annotation.EnableJobTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * @author Gdc
 */
@EnableJobTracker
@SpringBootApplication
public class LtsJobtrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LtsJobtrackerApplication.class, args);
    }

}
