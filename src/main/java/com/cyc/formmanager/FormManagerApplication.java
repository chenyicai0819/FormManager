package com.cyc.formmanager;

import com.spring4all.swagger.EnableSwagger2Doc;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableSwagger2Doc
@EnableTransactionManagement
@EnableScheduling
@ComponentScan(basePackages = {"com.cyc"})
public class FormManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FormManagerApplication.class, args);
    }

}
