## Java_Selenium_POM_automaticReports-Logs 📰
<pre>
Check requirements & instruction for run this project locally or checkout samples bellow 🔽
</pre>
#### SUMMARY 📚

Welcome to my **CROSSWEB** Java-Selenium project for testing simple Web App.
Project is developed in **Page Object Model** pattern assisted by **Page Factory** framework.
<Pre></Pre>
#### Technologies & Frameworks ✨ 
<pre>
-  <b><i>Maven</b></i> -  bulding tool
-  <b><i>JAVA</b></i> -  main Language
-  <b><i>WebDriver</b></i> -  Selenium web framework that permits to execute cross-browser tests
-  <b><i>TestNG</b></i> -  testing framework that allows to perform automated testing
-  <b><i>Log4j2</b></i> -  to provide logging functionality
-  <b><i>ExtentReports</b></i>  -  library that allows creating interactive reports automatticly

</Pre>
  
### REQUIREMENTS 💂‍♂️
<pre>
- <b>Java version "17.0.9" </b> - installed and configurated
- <b>Apache Maven 3.9.5</b> - installed and configurated
- <b>Chrome Version 118.0.5993.89</b> 
- <b>Firefox Version 119.0 </b>
  
   <b>Rest of frameworks and tools you gonna build from dependecies in pom.xml </b>
</pre>

<h3>Instrucions ↩️</h3> to build local

- **clone this. repository using command:**
  <pre>git clone https://github.com/anowacki10/Java_Selenium_automaticReports-Logs.git</pre>
- **get to the repository PATH in cmd** <pre> ./Java_Selenium_automaticReports-Logs</pre>
- **now you're abble to run tests using commands presented bellow** <pre>mvn clean test -DtestngName="smoke.xml"</pre> <pre>mvn clean test -DtestngName="testCases.xml"</pre>

 <b><i> Test will be performed in the background, you will be able to track their results and the current status in the logs.</b></i><<br><br/><br>After test executed you are abble to check resoults in:</br>

- logs <pre> ./src/logs/"TEST_NAME.log"   </pre>



