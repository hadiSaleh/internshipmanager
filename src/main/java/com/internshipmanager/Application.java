package com.internshipmanager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.internshipmanager.Entities.Employee;
import com.internshipmanager.Entities.Office;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws IOException {
        SpringApplication.run(Application.class, args);
    }
}