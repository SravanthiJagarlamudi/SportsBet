# SportsBet
Sportsbet Automation challenge

This code works on Seleniumtool with TestNG framework using JAVA code base on Eclipse tool

Due to dynamically changing WEBELEMENTS this Automation framework works for Automating below scenario:-
1.Open the browser (https://www.sportsbet.com.au) with the dimensions mentioned.
2. click on the first card under the ‘Next to Jump’ carousel which 
3. Add a horse bet.
4. Verify the betSlip with the correct Horse details added.

Problems encountered 
While adding multiple bets in the browser with given dimensions:-
Adding first bet automatically opens the betSlip , so when we close that betslip, the previously opened Bet page (used to select other bets) is no longer shown.
Hence need to again navigate to that page and then add second bet.

Note :If we are adding multiple bets in the regular browser(without dimensions), then we are able to properly verify cart with all bets added.

Challenges: Due to dynamically changing webpages , locating WEBELEMENTS  with XPATH traversing is a bit challenging. 

Framework :
Added the PageObjects for Home page under com.inetbetting.pages folder
Also added the necessary utility files under com.inetbetting.utilities folder
Added  Actual test cases under inetbetting.testcases folder
Added a folder to save the Input test data under inetbetting.testData folder( in this case no test data needed)
TestNG reports are generated


As the test suite grows we can addomodate files under the respective folder structures.
