package com.maxreport.nutritionreport;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class NutritionReportApplication {

    public static void main(String[] args) {
        SpringApplication.run(NutritionReportApplication.class, args);
        String filepath = "D:\\Education\\MyJasperReport\\NutritionReport\\src\\main\\resources\\templates\\nutritionreport.jrxml";
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstName", "Max");
        parameters.put("lastName", "Spirkin");
        parameters.put("dob", "05/07/2002");
        parameters.put("age", 21);

    }

}
