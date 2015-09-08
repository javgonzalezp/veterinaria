package com.clinica.veterinaria.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesConfigurator {
	private static String propsName = System.getProperty("user.dir")+"\\src\\main\\resources\\database.properties";
	private static Properties properties;
	
	public static Properties getInstance() throws IOException{
		FileInputStream fileInput = null;
        try {
            properties = new Properties();
            fileInput = new FileInputStream(propsName) ;
            properties.load(fileInput);
		} catch (NullPointerException ex) {
			System.out.println(Mensajes.S_ERROR_NULLPOINTER+ propsName);
		} catch (IOException e) {
			System.out.println(Mensajes.S_PROPERTIESCONFIGURATION + propsName);
			throw new IOException(Mensajes.S_PROPERTIESCONFIGURATION + propsName);
		} finally{
			if (fileInput != null){
				fileInput.close();
			}
		}
        return properties;
	}
}
