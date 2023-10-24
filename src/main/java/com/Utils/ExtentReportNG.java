package com.Utils;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.Utils.GetProperty.getProp;


public class ExtentReportNG{
    static ExtentReports extent;

    public static ExtentReports setupExtentReport() throws IOException {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyy HH-mm-ss");
        Date date = new Date();
        String accualDate = format.format(date);

        String reportPath = System.getProperty("user.dir")+
                "/Reports/"+getProp("browser")+"_Report_"+accualDate+".html";

        ExtentSparkReporter sparkReport = new ExtentSparkReporter(reportPath);

        extent = new ExtentReports();
        extent.attachReporter(sparkReport);

        sparkReport.config().setDocumentTitle("DocumentTitle");
        sparkReport.config().setTheme(Theme.DARK);
        sparkReport.config().setReportName("ReportName");

        extent.setSystemInfo("Executed on Enviroment: ", getProp("url"));
        extent.setSystemInfo("Executed on Browser : ", getProp("browser"));
        extent.setSystemInfo("Executed on OS: ", System.getProperty("os.name"));
        extent.setSystemInfo("Executed by User: ", System.getProperty("user.name"));


        return extent;
    }
}
