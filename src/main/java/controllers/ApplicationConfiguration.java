package controllers;

import ru.qatools.properties.Property;
import ru.qatools.properties.PropertyLoader;
import ru.qatools.properties.Resource;

/**
 * @Author Gladson Antony
 * @Date 06-Dec-2017
 */

@Resource.Classpath("ApplicationConfig.properties")
public class ApplicationConfiguration
{
	public ApplicationConfiguration()
	{
		PropertyLoader.newInstance().populate(this);
	}

	@Property("BaseURL")
	private String BaseURL;

	@Property("UserName")
	private String UserName;

	@Property("Password")
	private String Password;

	public String getBaseURL()
	{
		return BaseURL;
	}

	public String getUserName() 
	{
		return UserName;
	}

	public String getPassword() 
	{
		return Password;
	}

}
