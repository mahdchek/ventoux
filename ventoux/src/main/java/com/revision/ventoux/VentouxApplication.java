package com.revision.ventoux;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class VentouxApplication {

    public static void main(String[] args) {
        SpringApplication.run(VentouxApplication.class, args);
    }

}
