package org.calculator.utils;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class EnvManager {

    private static final Properties properties = new Properties();

    static {
        loadEnvironment();
    }

    private static void loadEnvironment(){
        try(InputStream is = EnvManager.class.getClassLoader().getResourceAsStream("env.properties")){
            properties.load(is);
        }
        catch(Exception e){
            throw new RuntimeException("env.properties file not found");
        }
    }

    public static String get(String key){
        String env = System.getProperty("env", "staging");
        return properties.getProperty(env+"."+key);
    }

}
