package com.clinica.veterinaria.base.res;

import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class Resources {

	private static Resources S_INSTANCE = null;
	
	private static Properties PROP = new Properties();
	
	private Resources(){
		
	}
	
	public static synchronized void init(URL p_resourceFile) throws IOException{
		if (S_INSTANCE == null){
			S_INSTANCE = new Resources();
			PROP.load(p_resourceFile.openStream());
		}
	}
	
	public static String getResource(String p_resourcekey){
		if (S_INSTANCE == null){
			throw new NotInitResourceException();
		}
		return PROP.getProperty(p_resourcekey);
	}
}
