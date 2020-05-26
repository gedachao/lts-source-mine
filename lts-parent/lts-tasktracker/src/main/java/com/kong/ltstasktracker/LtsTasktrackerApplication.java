package com.kong.ltstasktracker;

import com.github.ltsopensource.spring.boot.annotation.EnableTaskTracker;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Gdc
 */
@EnableTaskTracker
@SpringBootApplication
public class LtsTasktrackerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LtsTasktrackerApplication.class, args);
    }

}
