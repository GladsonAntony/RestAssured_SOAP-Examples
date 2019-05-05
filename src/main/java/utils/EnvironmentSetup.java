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
			System.out.println("Author --> " +properties.getProperty("Author"));
			properties.setProperty("Application URL",BaseURL);
			System.out.println("Application URL --> " +properties.getProperty("Application URL"));
			properties.setProperty("Environment",aURL.getHost().toUpperCase().toString()
					.replace("WWW","")
					.replace("COM", "")
					.replace(".", ""));
			System.out.println("Environment --> " +properties.getProperty("Environment"));
			properties.setProperty("OS", OSName);
			System.out.println("OS --> " +properties.getProperty("OS"));
			properties.setProperty("OS Architecture", OSArchitecture.toUpperCase());
			System.out.println("OS Architecture --> " +properties.getProperty("OS Architecture"));
			properties.setProperty("OS Bit", OSBit);
			System.out.println("OS Bit --> " +properties.getProperty("OS Bit"));
			properties.setProperty("Java Version", Runtime.class.getPackage().getImplementationVersion());
			System.out.println("Java Version --> " +properties.getProperty("Java Version"));
			properties.setProperty("Host Name", InetAddress.getLocalHost().getHostName());
			System.out.println("Host Name --> " +properties.getProperty("Host Name"));
			properties.setProperty("Host IP Address", InetAddress.getLocalHost().getHostAddress());
			System.out.println("Host IP Address --> " +properties.getProperty("Host IP Address"));

			File file = new File("./src/main/resources/environment.properties");
			System.out.println(file.getAbsolutePath());
			FileOutputStream fileOut = new FileOutputStream(file.getAbsoluteFile());
			properties.store(fileOut, "Environment Setup");
			fileOut.close();
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		} 
	}
}
