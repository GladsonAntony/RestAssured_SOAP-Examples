package controllers;

import org.testng.annotations.BeforeTest;
import utils.EnvironmentSetup;

/**
 * @Author Gladson Antony
 * @Date 04-DEC-2017
 */
public class BaseMethod
{
    @BeforeTest
    public void beforeSuite() throws Exception
    {
        EnvironmentSetup.environmentSetup();
    }
}
