package com.maxreport.nutritionreport;

import com.maxreport.nutritionreport.model.MacroNutrient;
import com.maxreport.nutritionreport.model.Nutrition;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.crypto.Mac;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
public class NutritionReportApplication {

    public static void main(String[] args) throws JRException {
        SpringApplication.run(NutritionReportApplication.class, args);
        String filepath = "D:\\Education\\MyJasperReport\\NutritionReport\\src\\main\\resources\\templates\\nutritionreport.jrxml";

        Nutrition protein = new Nutrition("Protein", 62, 83, "g");
        Nutrition carbonydrates = new Nutrition("Carbonydrates", 180, 206, "g");
        Nutrition fiber = new Nutrition("Fiber", 20, 38, "g");
        Nutrition sugars = new Nutrition("Sugars", 68, 62, "g");
        Nutrition fat = new Nutrition("Fat", 60, 55, "g");
        Nutrition cholesterol = new Nutrition("Cholesterol", 84, 300, "mg");
        Nutrition sodium = new Nutrition("Sodium", 2200, 2300, "mg");
        Nutrition potassium = new Nutrition("Potassium", 2000, 3500, "mg");
        Nutrition calcium = new Nutrition("Calcium", 62, 100, "%");
        Nutrition iron = new Nutrition("Iron", 38, 100, "%");

        List<Nutrition> nutritionList = new ArrayList<>();
        nutritionList.add(protein);
        nutritionList.add(carbonydrates);
        nutritionList.add(fiber);
        nutritionList.add(sugars);
        nutritionList.add(fat);
        nutritionList.add(cholesterol);
        nutritionList.add(sodium);
        nutritionList.add(potassium);
        nutritionList.add(calcium);
        nutritionList.add(iron);

        MacroNutrient carbMacroNutrient = new MacroNutrient("Carbohydrates", 48);
        MacroNutrient fatMacroNutrient = new MacroNutrient("Fat", 32);
        MacroNutrient proteinMacroNutrient = new MacroNutrient("Protein", 30);

        List<MacroNutrient> macroNutrientList = new ArrayList<>();
        macroNutrientList.add(carbMacroNutrient);
        macroNutrientList.add(fatMacroNutrient);
        macroNutrientList.add(proteinMacroNutrient);

        JRBeanCollectionDataSource nutritionDataSource = new JRBeanCollectionDataSource(nutritionList);
        JRBeanCollectionDataSource macroNutrientDataSource = new JRBeanCollectionDataSource(macroNutrientList);


        Map<String, Object> parameters = new HashMap<>();
        parameters.put("firstName", "Max");
        parameters.put("lastName", "Spirkin");
        parameters.put("dob", "05/07/2002");
        parameters.put("age", 21);
        parameters.put("nutritionDataSet", nutritionDataSource);
        parameters.put("macroNutrientDataSet", macroNutrientDataSource);



        JasperReport report = JasperCompileManager.compileReport(filepath);
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(print, "D:\\Education\\MyJasperReport\\NutritionReport\\src\\main\\resources\\static\\nutritionreport.pdf");
        System.out.println("Report Genereated Succesfully");

    }

}
