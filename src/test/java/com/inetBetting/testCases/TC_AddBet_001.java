package com.inetBetting.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.inetBetting.base.BaseClass;
import com.inetBetting.base.Constants;
import com.inetBetting.pages.HomePage;
import com.inetBetting.utilities.Common;

public class TC_AddBet_001 extends Constants {

	String expecteditemname;

	@Test(priority = 1,enabled = true, description = "to check if the 1 bet is added", groups = { "regression", "sra" })
	public void validatingcartwith1BetAddded() throws IOException, InterruptedException {
		String firstHorseNameOnBet = "";
		boolean flag = false;
		try {
			homePage = new HomePage(driver);
			
			homePage.clickfirstcardonNexttoJump();
			
			String firstHorseNameonBet = homePage.getFirstHorseNameOnBet();
						
			driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
			
			//String getBetamounttobeAdded = driver.findElement(By.xpath("//div[@data-automation-id='racecard-body']/div[2]//div[@data-automation-id='racecard-outcome-0-L-price']//span[@data-automation-id='price-text']")).getText();
			
			homePage.clickOnAddBetButton();
			
			String item1oncart = homePage.getFirstHorseNameOnCart();
						
			Boolean flag1 = false;
			Boolean flag2 = false;
			if(item1oncart.contains(firstHorseNameOnBet))
				flag1 = true;
			
			
			//System.out.println("value of BetAmt added " +getBetamounttobeAdded);
			System.out.println("value of BetAmt added " +homePage.getfirstbetamounttobeadded());
			System.out.println("Expected Betamount shown on cart is "+homePage.getfirstBetamountonCart());
			if(homePage.getfirstbetamounttobeadded().equalsIgnoreCase(homePage.getfirstBetamountonCart()))
				flag2 = true;
			
			
			Assert.assertTrue(flag1 && flag2);
			logger.info("Test case is PASSED");
		} catch (Exception ex) {
			logger.error("Test case is FAILED. " + ex.getMessage());
			ex.printStackTrace();
		}

	}
	
	
	@Test(priority = 2,enabled = false, description = "to check if added items are in the Bet Slip", groups = "regression")
	public void validateMultipleBetsOnCart() throws InterruptedException {

		homePage = new HomePage(driver);

		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		//clicking on the firstcardonNexttoJump as the weblement changed now
		driver.findElement(By.xpath("//div[@class='containerCarouselMobile_fadt96g']"));
		//homePage.clickfirstcardonNexttoJump();
		
				
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("kyt']//div[2]//div[1]//div[1]//div[3]//div[1]//div[1]//div[1]//div[1]//button[1]//div[1]//div[1]//div[1]//span[1]//div[1]//div[1]//div[1]//span[1]")));
		
		//adding first element to Bet
		homePage.clickOnAddBetButton();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				
		//closing the betcart before adding second bet
		//driver.findElement(By.xpath("//i[@data-automation-id='betslip-header-hide']")).click();
		Thread.sleep(3000);
		
		
		//clicking outside the BetSlip to activate home window
		WebElement runner = driver.findElement(By.xpath("//*[@data-automation-id='sportsbet-logo']"));
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", runner);
		
		Actions act = new Actions(driver);
		act.sendKeys(Keys.PAGE_UP).build().perform();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		act.sendKeys(Keys.PAGE_UP).build().perform();
		
		//again clikingonfirstcardonNexttoJump 
		driver.findElement(By.xpath("(//div[@class='eventTitleContainer_f1drbrc0'])[1]/span")).click();
		//homePage.clickfirstcardonNexttoJump();
		
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		//adding second element to Bet		
		driver.findElement(By.xpath("//div[@class='racecardBody_fuj30vh']/child::div[3]/descendant::button[1]")).click();
		
		
		
		//fetching the name of the elements added to Bet
		String seconditemamt = driver.findElement(By.xpath("//div[@class='racecardBody_fuj30vh']/child::div[3]/descendant::button[1]/div/div/div/span/div/div/div/span")).getText();
		System.out.println("value of seconditemamt choosen for adding bet is "+seconditemamt);
		
		//click the bet cart to validate the items
		driver.findElement(By.xpath("//div[@class='counter_f603tfs entered_f1w4fzq5']")).click();
						
		String itemcount = homePage.getcountofItemsonCart();

		System.out.println("the count of items selected is " + itemcount);

			
		driver.findElement(By.xpath("//div[@class='counter_f603tfs entered_f1w4fzq5']")).click();

		String item1oncart = driver.findElement(By.xpath("(//span[@class='size14_f7opyze medium_f1wf24vo title_f1j6bku7'])[1]"))
				.getText();
		String item2oncart = driver.findElement(By.xpath("(//span[@class='size14_f7opyze medium_f1wf24vo title_f1j6bku7'])[2]"))
				.getText();
		
		System.out.println(" First itemname from cart is " + item1oncart);
		System.out.println(" Second itemname from cart is " + item2oncart);
		
		String rateof1stitemonCart = driver
				.findElement(By.xpath("//div[@class='stakeAllSingles_f1iv0qtb']/following-sibling::div[1]/descendant::div[@class='betContainerDetailsColumn_f1jisjqt oddsColumn_f15uu7nv']/div[2]/span")).getText();
		
		
		String rateof2ndtitemonCart = driver
				.findElement(By.xpath("//div[@class='stakeAllSingles_f1iv0qtb']/following-sibling::div[2]/descendant::div[@class='betContainerDetailsColumn_f1jisjqt oddsColumn_f15uu7nv']/div[2]/span")).getText();
		
		
		System.out.println("rate of first item from cart is " + rateof1stitemonCart);
		System.out.println("rate of first item from cart is " + rateof2ndtitemonCart);
		
		
			
		//Assert.assertTrue(itemname.contains(expecteditemname));
		logger.info("Item 1 added succesfully");

	}

}
