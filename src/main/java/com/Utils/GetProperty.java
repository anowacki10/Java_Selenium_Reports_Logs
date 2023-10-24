package com.Utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetProperty {

    public static String getProp(String property) throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("./src/test/resources/config.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");
        String expectedLoginUrl = prop.getProperty("expectedLoginUrl");
        String expectedGuidesUrl = prop.getProperty("expectedGuidesUrl");
        String expectedWarningText = prop.getProperty("expectedWarningText");
        String expectedSecurityUrl = prop.getProperty("expectedSecurityUrl");
        String expectedIdentityUrl = prop.getProperty("expectedIdentityUrl");
        String expectedTestIdUrl = prop.getProperty("expectedTestIdUrl");
        String expectedTestIdText= prop.getProperty("expectedTestIdText");
        String expectedFiledLoginText = prop.getProperty("expectedFiledLoginText");
        String expectedProductionUrl = prop.getProperty("expectedProductionUrl");
        String expectedProductionBankIdText = prop.getProperty("expectedProductionBankIdText");
        String invalidPersonalCode= prop.getProperty("invalidPersonalCode");
        String invalidCodeResponse= prop.getProperty("invalidCodeResponse");
        String fname= prop.getProperty("fname");
        String lname= prop.getProperty("lname");
        String organizationName = prop.getProperty("organizationName");
        String projectName = prop.getProperty("projectName");
        String email = prop.getProperty("email");
        String expectedCodeSentUrl= prop.getProperty("expectedCodeSentUrl");
        String expectedGuidesText= prop.getProperty("expectedGuidesText");


        String result = null;
        if (property == "url"){
            result=url;
        }else if (property == "browser"){
            result=browser;
        } else if (property=="expectedLoginUrl") {
            result=expectedLoginUrl;

        } else if (property == "expectedGuidesUrl") {
            result=expectedGuidesUrl;

        } else if (property == "expectedWarningText"){
            result=expectedWarningText;
        } else if (property == "expectedSecurityUrl") {
            result=expectedSecurityUrl;

        } else if (property == "expectedIdentityUrl") {
            result=expectedIdentityUrl;

        } else if (property == "expectedTestIdUrl"){
            result=expectedTestIdUrl;
        } else if (property == "expectedTestIdText") {
            result=expectedTestIdText;
        } else if (property == "expectedFiledLoginText"){
            result=expectedFiledLoginText;
        } else if (property == "expectedProductionUrl"){
            result=expectedProductionUrl;
        } else if (property=="expectedProductionBankIdText") {
            result=expectedProductionBankIdText;

        }else if (property=="invalidPersonalCode"){
            result=invalidPersonalCode;
        }else if (property=="invalidCodeResponse"){
            result=invalidCodeResponse;
        }else if (property=="fname"){
            result=fname;
        }else if (property=="lname") {
            result = lname;
        }else if (property=="organizationName") {
            result = organizationName;
        }else if (property=="projectName") {
            result = projectName;
        }else if (property=="email") {
            result = email;
        }else if (property=="expectedCodeSentUrl") {
            result = expectedCodeSentUrl;
        }else if (property=="expectedGuidesText"){
            result = expectedGuidesText;
        }


        return result;

    }

}
