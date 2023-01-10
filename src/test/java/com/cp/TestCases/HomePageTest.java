package com.cp.TestCases;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.sql.Driver;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cp.commonsActions.BaseTest;
import com.cp.Pages.HomePage;

public class HomePageTest extends BaseTest {

	WebDriver driver;
	HomePage homepage;
	String rating = "4.7";
	
	// List<WebElement> ListOfBooks;

	public HomePageTest() throws IOException {
		driver = initiliseDriver();
		driver.get(pro.getProperty("baseurl"));
		homepage = new HomePage(driver);

	}

	@Test
	public void TC_Coursera() throws IOException, InterruptedException {

		// Search course name - "Web Development"
		homepage.getSearchBox().sendKeys(pro.getProperty("course"));
		homepage.getSearchBoxBtn().click();
		String name = homepage.getSearchedCourse().getText();
		Assert.assertTrue(name.contains(homepage.Name));

		// Select Beginner Level
		homepage.getLevel().click();
		List<WebElement> begTxt = homepage.getBegineerText();
		WebElement secondPage = homepage.getSecondPage();


		//assertion of Beginner text on first 2 pages:
		for(int j=0;j<=1;j++)
		{
			for(int i=0;i<begTxt.size();i++)
			{
				String txt = begTxt.get(i).getText();
				Assert.assertTrue(txt.contains("Beginner"));
				System.out.println(txt.contains("Beginner"));
			}
			try 
			{
				secondPage.click();	
			}
			catch (StaleElementReferenceException  e) 
			{
				System.out.println(e);
				break;
			}
		}
		homepage.getFirstPage().click();


		// Select English Language
		homepage.getshowMoreBtn().click();
		homepage.getEnglishLangCheckbox().click();
		homepage.getApplyButton().click();
		String LanguageSelected = homepage.getLanguageCheckbox().getText();
		Assert.assertTrue(LanguageSelected.contains("English"));



		List<WebElement> ratingText = homepage.getRatingText();
		for(int i=1;i<ratingText.size();i++)
			{
			 String txt = ratingText.get(i).getText();
			 //if (txt.equals("3.1")) 
				{
				 for(int j=i;j<=i;j++)
					{
					 WebElement courseName = driver.findElement(By.xpath("(//div[@class='css-1rj417c']/h2)["+(j+1)+"]"));
					 System.out.println(courseName.getText());
					 System.out.println("===================================================================");
					 
					 
					}
				
				}
			}

/*
		// Select first course
		homepage.getselectFirstCourse().click();
		homepage.UserWindowHandle(driver);
		String FirstCourse = homepage.getFirstCourseName().getText();
		System.out.println("First course name : " + FirstCourse);
		Assert.assertEquals(driver.getCurrentUrl(), homepage.firstCourseUrl);

		// Details of first course
		String FirstCourseRating = homepage.getFirstCourseRating().getText();
		System.out.println("First course Rating: " + FirstCourseRating);
		Assert.assertTrue(FirstCourseRating.contains(homepage.courseOneRating));

		String FirstCourseTime = homepage.getFirstCourseTime().getText();
		System.out.println("First course Time: " + FirstCourseTime);
		Assert.assertTrue(FirstCourseTime.contains(homepage.courseOneTime));

		/*
		// Switch back to parent window
		homepage.parentWindowHandle(driver);
		System.out.println("=========================================================");

		// Select second course 
		homepage.getselectSecondCourse().click();
		homepage.UserWindowHandle(driver);
		String SecondCourse = homepage.getSecondCourseName().getText();
		System.out.println("Second course name: " + SecondCourse);
		Assert.assertEquals(driver.getCurrentUrl(), homepage.secondCourseUrl);

		// Details of Second course
		String SecondCourseRating = homepage.getSecondCourseRating().getText();
		System.out.println("Second course Rating: " + SecondCourseRating);
		Assert.assertTrue(SecondCourseRating.contains(homepage.courseTwoRating));

		String SecondCourseTime = homepage.getSecondCourseTime().getText();
		System.out.println("Second course Time: " + SecondCourseTime);
		Assert.assertTrue(SecondCourseTime.contains(homepage.courseTwoTime));
		System.out.println("");
		System.out.println("Finish");
		*/


	}
}
