package com.cp.Pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public String beginnerLevelUrl = "https://www.coursera.org/search?query=Web%20Development&index=prod_all_launched_products_term_optimization&productDifficultyLevel=Beginner";
	public String firstCourseUrl = "https://www.coursera.org/professional-certificates/meta-front-end-developer";
	public String secondCourseUrl = "https://www.coursera.org/professional-certificates/ibm-full-stack-cloud-developer";
	public String Name = "Web Development";
	public String courseOneRating = "4.7/5";
	public String courseOneTime = "7 Months";
	public String courseTwoRating = "4.5/5";
	public String courseTwoTime = "14 Months";
	public String maxRating = "4.7";
	public String Leveltxt = "Beginner";
	public String allRating = "//div[@data-e2e='SearchCard']//div[2]//div[1]/following-sibling::div/div/p[text()='4.7']";
	public String allheading = "//div[@class='css-ilhc4l']//h2[1]"; // div[@data-e2e=\"SearchCard\"]//child::div[2]//h2";
	public String allcourse = "//div[@class='css-ilhc4l']//p[1]";

	public HomePage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void UserWindowHandle(WebDriver driver) {
		String parentHandle = driver.getWindowHandle();
		Set<String> allhandles = driver.getWindowHandles();
		for (String handle : allhandles) {
			if (!parentHandle.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}
	}

	public void parentWindowHandle(WebDriver driver) {
		String seconhandle = driver.getWindowHandle();
		Set<String> allhandles = driver.getWindowHandles();
		for (String handle : allhandles) {
			if (!seconhandle.equals(handle)) {
				driver.switchTo().window(handle);
			}
		}

	}

	// click on search box enter string
	@FindBy(xpath = "//input[@placeholder='What do you want to learn?']")
	WebElement SearchBox;

	public WebElement getSearchBox() {
		return SearchBox;
	}

	// click on search box button
	@FindBy(xpath = "(//*[name()='svg'])[31]")
	WebElement SearchBoxBtn;

	public WebElement getSearchBoxBtn() {
		return SearchBoxBtn;
	}

	// For name Web Development ////span[text()='1127 results for \"web
	// development\"']
	@FindBy(xpath = "//div[@class='rc-SearchResultsHeader']")
	WebElement SearchedCourse;

	public WebElement getSearchedCourse() {
		return SearchedCourse;
	}

	// click checkbox for beginner level ....(//input[@id='cds-react-aria-72'])[1]
	// span[@id='cds-react-aria-238-label-text']
	@FindBy(xpath = "(//span[text()='Beginner'])[1]")
	WebElement Level;

	public WebElement getLevel() {
		return Level;
	}

	@FindBy(how = How.XPATH, using = "//div[@class='css-ilhc4l']/div[2]/p")
	List<WebElement> begtext;

	public List<WebElement> getBegineerText() {
		return begtext;
	}

	// Click on second page
	@FindBy(xpath = "//button[@id='pagination_number_box_2']/span")
	WebElement secondPage;

	public WebElement getSecondPage() {
		return secondPage;
	}

	// Click on First page
	@FindBy(xpath = "//button[@id='pagination_number_box_1']")
	WebElement FirstPage;

	public WebElement getFirstPage() {
		return FirstPage;
	}

	// for beginner level assertion
	@FindBy(xpath = "(//span[text()='Beginner'])[2]")
	WebElement LevelCheckbox;

	public WebElement getLevelCheckbox() {
		return LevelCheckbox;
	}

	// click on show more for language selection
	@FindBy(xpath = "(//span[text()='Show more'])[4]")
	WebElement showMoreBtn;

	public WebElement getshowMoreBtn() {
		return showMoreBtn;
	}

	// click on checkbox for select english language
	@FindBy(xpath = "//span[text()='English']")
	WebElement englishLangCheckbox;

	public WebElement getEnglishLangCheckbox() {
		return englishLangCheckbox;
	}

	// for beginner level assertion
	@FindBy(xpath = "(//span[text()='English'])[2]")
	WebElement LanguageCheckbox;

	public WebElement getLanguageCheckbox() {
		return LanguageCheckbox;
	}

	// click on apply button
	@FindBy(xpath = "//span[text()='Apply']")
	WebElement ApplyButton;

	public WebElement getApplyButton() {
		return ApplyButton;
	}

	// print list of books //ul[@class='cds-9 css-18msmec cds-10']//li
	@FindBy(xpath = "//div[@class='css-12svhik']")
	List<WebElement> ListOfCourse;

	public List<WebElement> getListOfCourse() {
		return ListOfCourse;
	}

	public int getListSizeOfBooks() {
		return ListOfCourse.size();
	}

	// rating text
	@FindBy(how = How.XPATH, using = "//div[@class='css-pn23ng']/p[1]")
	List<WebElement> ratingText;

	public List<WebElement> getRatingText() {
		return ratingText;
	}

	// course text
	@FindBy(xpath = "(//div[@class='css-1rj417c']/h2)[\"+(j+1)+\"]")
	WebElement CourseText;

	public WebElement getCourseText() {
		return CourseText;
	}

	// for 4.7 rating
	@FindBy(xpath = "//div[@data-e2e='SearchCard']//div[2]//div[1]/following-sibling::div/div/p[text()='4.7']")
	WebElement selRat;

	public WebElement getselRat() {
		return selRat;
	}

	// for rating
	@FindBy(xpath = "//p[@class='cds-119 css-zl0kzj cds-121']")
	WebElement compareRating;

	public WebElement getcompareRating() {
		return compareRating;
	}

	// select first course
	@FindBy(xpath = "(//ul[@class='cds-9 css-18msmec cds-10']/li)[1]")
	WebElement selectFirstCourse;

	public WebElement getselectFirstCourse() {
		return selectFirstCourse;
	}

	// print first course name
	@FindBy(xpath = "//h1[@class='cds-119 css-1shw822 cds-121']")
	WebElement FirstCourseName;

	public WebElement getFirstCourseName() {
		return FirstCourseName;
	}

	// Rating for first course
	@FindBy(xpath = "(//p[@class='cds-119 css-bku0rr cds-121'])[1]")
	WebElement FirstCourseRating;

	public WebElement getFirstCourseRating() {
		return FirstCourseRating;
	}

	// Time to complete first course
	@FindBy(xpath = "(//p[@class='cds-119 css-bku0rr cds-121'])[2]")
	WebElement FirstCourseTime;

	public WebElement getFirstCourseTime() {
		return FirstCourseTime;
	}

	// select second course
	@FindBy(xpath = "(//ul[@class='cds-9 css-18msmec cds-10']/li)[2]")
	WebElement selectSecondCourse;

	public WebElement getselectSecondCourse() {
		return selectSecondCourse;
	}

	// print first course name
	@FindBy(xpath = "//h1[@class='cds-119 css-1shw822 cds-121']")
	WebElement SecondCourseName;

	public WebElement getSecondCourseName() {
		return SecondCourseName;
	}

	// Rating for second course
	@FindBy(xpath = "(//p[@class='cds-119 css-bku0rr cds-121'])[1]")
	WebElement SecondCourseRating;

	public WebElement getSecondCourseRating() {
		return SecondCourseRating;
	}

	// Time to complete second course
	@FindBy(xpath = "(//p[@class='cds-119 css-bku0rr cds-121'])[2]")
	WebElement SecondCourseTime;

	public WebElement getSecondCourseTime() {
		return SecondCourseTime;
	}

}
