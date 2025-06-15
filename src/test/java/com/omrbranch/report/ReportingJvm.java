package com.omrbranch.report;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class ReportingJvm {
	
	public static void generateJvumReport(String jsoneFile) {
		
		//1. Mention the path of jvm report-->Where to store 
       File file=new File("C:\\Users\\mathi\\eclipse-workspace-Selenium\\CucumberClass-Mathiyazhagan\\target");
       
       //2. Create oibject for configuration class
       Configuration configuration=new Configuration(file, "OmrBranch");
       
       //3.Design Purpose --> Browser,version,Sprints,details------>key,value
       configuration.addClassifications("Browser", "Chrome");
       configuration.addClassifications("Browser version", "122");
	   configuration.addClassifications("Sprint", "33");
	   configuration.addClassifications("OS", "WIN11");
	   
	   //Crate the object for reportBuilder class--->pass the json file--->Fetch the result 
	   
	   List<String>jsoneFiles= new ArrayList<>();
	   jsoneFiles.add(jsoneFile);
	   ReportBuilder builder=new ReportBuilder(jsoneFiles, configuration);
	   
	   //Generate JVM report
	   
	   builder.generateReports();
	   
	   
		
	}

}
