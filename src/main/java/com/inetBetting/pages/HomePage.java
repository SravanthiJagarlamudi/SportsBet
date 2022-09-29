package com.inetBetting.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.inetBetting.utilities.Common;

public class HomePage extends Common {

	public HomePage(WebDriver rdriver) {
		this.driver = rdriver;
		PageFactory.initElements(rdriver, this);

	}

	@FindBy(xpath ="//div[@class='childrenContainer_f1pi17at'][@data-automation-id='group-1-carousel-1-body-container']/child::div[1]")
	//@FindBy(xpath = "//div[@data-automation-id='group-3-list-1-body-container']/div[1]")
	
	private WebElement firstcardonNexttoJump;

	@FindBy(xpath = "//div[@class='content_f11wsrxy']")
	private WebElement betSlip;

	@FindBy(xpath = "//div[@class='counter_f603tfs entered_f1w4fzq5']/span")
	private WebElement countofItemsonCart;

	@FindBy(xpath = "//div[@data-automation-id='racecard-body']/div[2]//div[@data-automation-id='racecard-outcome-0-L-price']")
	public WebElement btnAddBet;

	@FindBy(xpath = "//div[@class='racecardBody_fuj30vh']/div[2]/div/div/div/div/span[1]")
	private WebElement lblFirstHorseselectedtoBet;

	@FindBy(xpath = "(//span[@class='size14_f7opyze medium_f1wf24vo title_f1j6bku7'])[1]")
	private WebElement lblFirstHorstNameOnCart;
	
	//--@FindBy(xpath =  "//span[@class='size14_f7opyze CodGray_f1tc10rl bold_f1au7gae']")
	@FindBy(xpath = "(//*[@data-automation-id='betslip-bet-odds'])[1]")
	private WebElement firstbetamtonCart;
	
	@FindBy(xpath = "//div[@data-automation-id='racecard-body']/div[2]//div[@data-automation-id='racecard-outcome-0-L-price']//span[@data-automation-id='price-text']")
	private WebElement firstbetamounttobeadded;
	
	// this method returns the first betamout shown in the cart
	public String getfirstBetamountonCart(){
		return firstbetamtonCart.getText();
	}
	
	//this method returns the betamount added to cart
	public String getBetamount(){
		return btnAddBet.getText();
	}
	
	/**
	 * This method is used to return the countofitemsoncart
	 * 
	 * @return count
	 */
	public String getcountofItemsonCart() {
		String count = "";
		try {
			//scrollIntoView(countofItemsonCart);
			count = getText(countofItemsonCart);
			logger.info("Items count in the cart is: " + count);
		} catch (Exception ex) {
			logger.info("Exception occurre while getting the count of items in the cart. " + ex.getMessage());
			ex.printStackTrace();
		}
		return count;

	}
	
	
	public String getfirstbetamounttobeadded() {
		String amt = "";
		try {
			//scrollIntoView(countofItemsonCart);
			amt = getText(firstbetamounttobeadded);
			logger.info("Bet amount to be choosen is: " + amt);
		} catch (Exception ex) {
			logger.info("Exception occurre while getting the count of items in the cart. " + ex.getMessage());
			ex.printStackTrace();
		}
		return amt;

	}

	// Below are the action methods//
	public void clickfirstcardonNexttoJump() {
		try {
			//scrollIntoView(firstcardonNexttoJump);
			click(firstcardonNexttoJump);
			logger.info("First card is clicked on");
		} catch (Exception ex) {
			logger.info("Exception occurre while clicking on first card. " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	/**
	 * This mehtod is used to clickd on bet slip
	 */
	public void clickBetSlip() {
		try {
			//scrollIntoView(betSlip);
			click(betSlip);
			logger.info("Bet Slip is clicked on");
		} catch (Exception ex) {
			logger.info("Exception occurre while clicking on Bet Slip. " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	/**
	 * This method is used to clicked on Add Bet
	 */
	public void clickOnAddBetButton() {
		try {
			//scrollIntoView(btnAddBet);
			click(btnAddBet);
			logger.info("Add Bet button is clicked on");
		} catch (Exception ex) {
			logger.info("Exception occurre while clicking on Add Bet " + ex.getMessage());
			ex.printStackTrace();
		}

	}

	public String getFirstHorseNameOnBet() {
		String nameOfHorse = "";
		try {
			//scrollIntoView(lblFirstHorstNameOnBet);
			nameOfHorse = getText(lblFirstHorseselectedtoBet);
			logger.info("Name of the Firts Horse on bet is: " + nameOfHorse);
		} catch (Exception ex) {
			logger.info("Exception occurre while getting the Name of the Firts Horse on bet " + ex.getMessage());
			ex.printStackTrace();
		}
		return nameOfHorse;
	}

	/**
	 * This method gets first horse name on cart
	 * 
	 * @return nameOfHorse
	 */
	public String getFirstHorseNameOnCart() {
		String nameOfHorse = "";
		try {
			//scrollIntoView(lblFirstHorstNameOnCart);
			nameOfHorse = getText(lblFirstHorstNameOnCart);
			logger.info("Name of the Firts Horse on Cart is: " + nameOfHorse);
		} catch (Exception ex) {
			logger.info("Exception occurre while getting the Name of the Firts Horse on Cart " + ex.getMessage());
			ex.printStackTrace();
		}
		return nameOfHorse;
	}

}
