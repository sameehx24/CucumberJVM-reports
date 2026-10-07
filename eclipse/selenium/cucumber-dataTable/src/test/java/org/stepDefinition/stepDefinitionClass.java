package org.stepDefinition;

import java.util.List;
import java.util.Map;

import org.POJO.LoginPojoAdactin;
import org.baseClass.BaseClass;
import org.testng.asserts.SoftAssert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class stepDefinitionClass extends BaseClass {
	
		LoginPojoAdactin l;
	@Given("User has to launch the browser and url")
	public void user_has_to_launch_the_browser_and_url() {
	   browserLaunch();
	   maximizeWindow();
	   urlLaunch("https://adactinhotelapp.com/");
	   l=new LoginPojoAdactin();
	   
	}



	@When("User has to click the login button")
	public void user_has_to_click_the_login_button() throws InterruptedException {
		Thread.sleep(3000);	
		l.getLoggedIn().click();
		
		
	}

	@Then("Validate user reached the home page and close the browser")
	public void validate_user_reached_the_home_page_and_close_the_browser() throws InterruptedException {
		
	    boolean res=driver.getCurrentUrl().contains("SearchHotel");
	    SoftAssert st=new SoftAssert();
	    st.assertTrue(res,"Login failed");
	 
	    st.assertAll();
	    driver.quit();
	}
	@When("User has to  enter the valid {string} and valid {string}")
	public void user_has_to_enter_the_valid_and_valid(String user, String pass) {
		l.getUsername().sendKeys(user);
		l.getPassword().sendKeys(pass);
		
	}
	
	@When("User has to enter the valid username and valid password")
	public void user_has_to_enter_the_valid_username_and_valid_password(io.cucumber.datatable.DataTable d) {
		//ONE DIMENSIONAL LIST
		List<String> li = d.asList();
		l.getUsername().sendKeys(li.get(1));
		l.getPassword().sendKeys(li.get(2));
		
	   
	}
    

@When("User has to enter any  valid username and any valid password")
public void user_has_to_enter_any_valid_username_and_any_valid_password(io.cucumber.datatable.DataTable d) {
    //TWO DIMENSIONAL LIST
	    List<List<String>> li = d.asLists();
	    l.getUsername().sendKeys(li.get(1).get(0));
	    l.getPassword().sendKeys(li.get(1).get(1));
}

@When("User has to enter any  vvalid username and any vvalid password")
public void user_has_to_enter_any_vvalid_username_and_any_vvalid_password(io.cucumber.datatable.DataTable d) {
	//ONE DIMENSIONAL MAP
   Map<String, String> mp = d.asMap(String.class,String.class);
   l.getUsername().sendKeys(mp.get("username"));
   l.getPassword().sendKeys(mp.get("password"));
   System.out.println(mp.get("mailid"));
}


@When("User has to enter any  vvalid uusername and any vvalid ppassword")
public void user_has_to_enter_any_vvalid_uusername_and_any_vvalid_ppassword(io.cucumber.datatable.DataTable d) {
    //TWO DIMENSIONAL MAP
	List<Map<String, String>> mp = d.asMaps();
	l.getUsername().sendKeys(mp.get(1).get("username"));
	l.getPassword().sendKeys(mp.get(1).get("password"));
	System.out.println(mp.get(1).get("mailid"));
}


//Signup feature
@Given("User has to enter the correct email id")
public void user_has_to_enter_the_correct_email_id(io.cucumber.datatable.DataTable d) {
   List li= d.asList(String.class);
   System.out.println(li);
}
@Then("it should navigate to main cart")
public void it_should_navigate_to_main_cart() {
  System.out.println("That's it ");
}





}
