/**
 * 
 */
package com.whitbread.apitest;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

/**
 * @author Administrator
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/com/whitbread/resources/StepOne.feature","src/test/java/com/whitbread/resources/StepTwo.feature","src/test/java/com/whitbread/resources/StepThree.feature"}  
        ,glue =  "classpath:"   
        )
public class CucumberIntegrationTest {
}