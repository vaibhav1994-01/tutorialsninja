package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.Iphone;
import pageObjects.ProductSearch;
import base.BaseClass;

public class SC1_Verify_Search_Functionality extends BaseClass {



	    @Test(priority = 2, enabled = true, groups = {"Smoke"}, dependsOnMethods = {"TC2_EnterInValidName"})
	    public void TC1_EnterValidName() {

	        ProductSearch search =
	                new ProductSearch(getDriver());
	        Iphone iphone =
	                new Iphone(getDriver());

	        search.searchProduct("iPhone");

	        String actualResult = iphone.validateIphone();
	        String expectedResult = "iPhone";

	        Assert.assertEquals(
	                actualResult,
	                expectedResult,
	                "Valid product search failed"
	        );
	    }

	    @Test(priority = 1,groups = {"Smoke"})
	    public void TC2_EnterInValidName() {

	        ProductSearch search =
	                new ProductSearch(getDriver());

	        search.searchProduct("XYZABC");

	        String actualMessage =
	                search.getInvalidSearchMessage();

	        String expectedMessage =
	                "There is no product that matches the search criteria.";

	        Assert.assertEquals(
	                actualMessage,
	                expectedMessage,
	                "Invalid product search message mismatch"
	        );
	    }
}
