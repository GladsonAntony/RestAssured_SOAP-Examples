package controllers;

import org.testng.annotations.BeforeSuite;

import utils.EnvironmentSetup;

/**
 * @Author Gladson Antony
 * @Date 04-DEC-2017
 */
public class BaseMethod extends InitMethod
{
    @BeforeSuite
    public void beforeSuite() throws Exception
    {
        System.out.println("Base URL: "+BaseURL);
        EnvironmentSetup.environmentSetup();
    }
}
