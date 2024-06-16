package TestBase;

import io.cucumber.java.hu.Ha;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;

public class environmentConfig {

    private String testEnvironment;
    private String testEnvURL;
    private String testDataEnv;
    private HashMap<String, HashMap<String,String>> environmentdetails;
    public environmentConfig(){
        environmentdetails = yamlReader("envConfig.yaml");
    }

    public void setEnvironmentdetails(){
     testEnvironment=environmentdetails.get("environment").get( "name" );
     testDataEnv=environmentdetails.get( "testDataEnv" ).get(testEnvironment);
     testEnvURL=environmentdetails.get( "environmentURL" ).get(testEnvironment);
    }

    public HashMap<String, HashMap<String,String>> yamlReader(String fileName){

        File ymlFileReader= new File("src/test/resources/Features/"+fileName);
        InputStream fis=null;
        try{
            fis=new FileInputStream(ymlFileReader);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        Yaml yaml = new Yaml();
        HashMap<String,HashMap<String,String>> yamlParser= yaml.load( fis );
    return  yamlParser;
    }

    public String getTestEnvironment() {
        return testEnvironment;
    }

    public void setTestEnvironment( String testEnvironment ) {
        this.testEnvironment = testEnvironment;
    }

    public String getTestDataEnv() {
        return testDataEnv;
    }

    public void setTestDataEnv( String testDataEnv ) {
        this.testDataEnv = testDataEnv;
    }

    public String getTestEnvURL() {
        return testEnvURL;
    }

    public void setTestEnvURL( String testEnvURL ) {
        this.testEnvURL = testEnvURL;
    }

}
