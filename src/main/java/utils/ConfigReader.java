package utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	
	public  Properties initializeProperties() {
		
		Properties prop = new Properties();
		
		File proFilePath = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\config\\config.properties");
		
				
		
		try {
			FileInputStream fis = new FileInputStream(proFilePath);
			prop.load(fis);
			
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return prop;
		
		
		
	}
}
