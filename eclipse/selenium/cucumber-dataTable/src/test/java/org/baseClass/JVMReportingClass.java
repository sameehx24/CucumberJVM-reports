package org.baseClass;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;


public class JVMReportingClass {
	public static void  jvmReport(String jsonPath) {
		File f=new File("Reports/JVM-report");
		Configuration c=new Configuration(f,"Adactin");
		c.addClassifications("Platform", "MacOS");
		c.addClassifications("Language", "Java");
		c.addClassifications("Sprint", "Agile");
		
		List<String>li=new ArrayList<String>();
		li.add(jsonPath);
		
		ReportBuilder r=new ReportBuilder(li,c);
		r.generateReports();
		

	}

}
