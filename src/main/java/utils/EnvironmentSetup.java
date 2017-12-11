/**
 * 
 */
package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.net.InetAddress;
import java.net.URL;
import java.util.Properties;

import controllers.InitMethod;

/**
 * @Author Gladson Antony
 * @Date 28-Jan-2017
 */
public class EnvironmentSetup extends InitMethod
{
	public static void environmentSetup() throws Exception
	{
		URL aURL = new URL(BaseURL);
		System.out.println("Running Environment Setup");
		try 
		{
			Properties properties = new Properties();
			properties.setProperty("Author", "Gladson Antony");
			properties.setProperty("Application URL",BaseURL);
			properties.setProperty("Environment",aURL.getHost().toUpperCase().toString().replace("WWW","").replace("COM", "").replace(".", ""));
			properties.setProperty("OS", OSName);
			properties.setProperty("OS Architecture", OSArchitecture);
			properties.setProperty("OS Bit", OSBit);
			properties.setProperty("Java Version", Runtime.class.getPackage().getImplementationVersion());
			properties.setProperty("Host Name", InetAddress.getLocalHost().getHostName());
			properties.setProperty("Host IP Address", InetAddress.getLocalHost().getHostAddress());

			File file = new File("./src/main/resources/environment.properties");
			System.out.println(file.getAbsolutePath());
			FileOutputStream fileOut = new FileOutputStream(file.getAbsoluteFile());
			properties.store(fileOut, "Envronement Setup");
			fileOut.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
}
