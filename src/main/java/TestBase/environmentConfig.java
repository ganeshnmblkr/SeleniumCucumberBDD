package TestBase;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;

public class environmentConfig {

    private String testEnvironment;
    private String testEnvURL;
    private String testDataEnv;
    private HashMap<String, HashMap<String,String>> environmentDetails;
    private HashMap<String, HashMap<String,String>> envTestData;
    public environmentConfig(){
        environmentDetails = yamlReader("Config","envConfig.yaml");
    }

    public void setEnvironmentDetails(){
     testEnvironment=environmentDetails.get("environment").get( "name" );
     testDataEnv=environmentDetails.get( "testDataEnv" ).get(testEnvironment);
     testEnvURL=environmentDetails.get( "environmentURL" ).get(testEnvironment);
    }

    public void getTestData(){
        envTestData = yamlReader("TestData","TestData.yaml");
    }

    public String readTestDataByKey(String keyName){
        if (keyName!=null ){
            return  envTestData.get(keyName).get( this.testDataEnv );
        }else{
            return "inCorrect Key";
        }
    }
    public HashMap<String, HashMap<String,String>> yamlReader(String sourceFolderName,String fileName){

        File ymlFileReader= new File("src/test/resources/"+sourceFolderName+"/"+fileName);

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
