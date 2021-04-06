/**
 * 
 */
package com.ixigo.files;

/**
 * @author Subhajit
 *
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Properties;

public class ConfigFileReader {
	
	static String directory = getDirectoryPath();
	
	public static String getDirectoryPath() {
		String str = FileSystems.getDefault().getPath(".").toAbsolutePath().toString() ;
	    if (str.charAt(str.length()-1)=='.'){
	        str = str.replace(str.substring(str.length()-1), "");
	        return str;
	    } else{
	        return str;
	    }
	}
	
	
	  public static Properties prop;
	  public static String configPath = directory+"src"+File.separator+"main"+File.separator+"java"+File.separator+"com"+File.separator+"ixigo"+File.separator+"files"+File.separator+"config.properties";
	  
	    //To create single object to Config Properties file through-out the project
	    public static Properties getConfigPropObject() {
	        if (prop == null) {
	            prop = new Properties();
	            FileInputStream fis = null;
				try {
					fis = new FileInputStream(new File(configPath));
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
	            try {
					prop.load(fis);
				} catch (IOException e) {
					e.printStackTrace();
				}
	            try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	        }
	        return prop;
	    }
}

