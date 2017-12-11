package controllers;

import org.testng.annotations.BeforeSuite;

import utils.EnvironmentSetup;

/**
 * @Author Gladson Antony
 * @Date 04-DEC-2017
 */
public class TestController extends InitMethod
{
    @BeforeSuite
    public void beforeSuite() throws Exception
    {
        EnvironmentSetup.environmentSetup();
    }
}
