Manual Test Cases
================================

## Test Case - 1: Opening landing page of partner banks. 

### Test Summary: 
```
It's the very first step to move forward for all other test cases. Investors will get an fair
idea about credit ratings about our partner banks from this page. This test case help us to know 
if the landing page of our partnet banks is opening correctly or not.
```
### Test Steps:
* Click on https://www.raisin.com/
* Choose Other from the list of regions provided in the popup. Click on OK.
* Click on 'Banks' button from the top menu.

### Expected Result:
* Verify if it redirected to partner banks page or not.
* Verify redirected URL is https://www.raisin.com/bank/
* Verify header as "Learn more about our partner banks" is displayed.

### Test Data: 
Not applicable for this test case.

***

## Test Case - 2: Displaying all partner banks name, repective country, logo, brief details etc.

### Test Summary: 
```
We have to verify the details of partner banks viz. country, Moody's Country details, logos etc. 
Additionaly, we also need to check if the sort by option is working correctly to sort the listed 
banks as prefered by users.
```
### Test Steps:

* Click on https://www.raisin.com/
* Choose Other from the list of regions provided in the popup. Click on OK.
* Click on 'Banks' button from the top menu.

### Expected Result:
* Verify all the partner bank names are populated or not.
* Verify Bank Names with different details viz. country, Moody's Country Details, logo etc. with the data base.
* Verify Moody's Country Details viz. A1/A2/Aa1 etc. corresponding to the banks from the database.

### Test Data: 
Backend DB information which contain partner bank details.

***

## Test Case - 3: Verifying the link embededed on bank name.

### Test Summary: 
```
This case will help to test the link to open more detailed information related to bank.
```
### Test Steps:
* Click on https://www.raisin.com/
* Click on 'Banks' button from the top menu.
* Hover the mouse on prefered bank names.

### Expected Result:
* Verify if the colour changed to red with underline.


### Test Data: 
Not applicable for this test case.

***

## Test Case - 4: Checking selected partner bank details with learn more option.

### Test Summary: 
```
Each bank details are crucial for investors. Hence need to populate properly and provide correct, compact
information. This test case is all about to make sure each partner bank details are maintained properly viz. 
details of bank, offer details, links to download product information etc.  
```
### Test Steps:
* Click on https://www.raisin.com/
* Click on 'Banks' button from the top menu.
* Click on the bank name.

### Expected Result:
* Verify if it opens the same bank page with more details or not.
* Verify the following sections are clearly visible or not.
	* Brief Intro at the begining.
	* Offer Details.
	* All Offers from the bank.
	* About the country.
	* Deposit guarantee.
	* Tax process and documents.
	* Raisin's Intro.
	* Open an account in 3 easy steps
* Verify the right hand box 'Invest now' should move up/down with the page scroll.
* Verify effective rate %  with the right hand box % number shown in green colour.
* Verify on 'Product Information Sheet' and check the document is opening correctly or not. 

### Test Data: 
Not applicable for this test case.

***

## Test Case - 5: Existence of Invest now button and proper functioning.

### Test Summary: 
```
The most important and critical part is to convert a customer from search to invest. This test enable
that specific criteria. By testing this scenario, we make sure that the button to invest is working absolutely 
OK. It also redirected to registration page and ask relevant information from user for next step.   
```
### Test Steps:
* Click on https://www.raisin.com/
* Click on 'Banks' button from the top menu.
* Click on the bank name.
* Click on the right hand box 'Invest now'.

### Expected Result:
* Verify if it opens/redirected to registration page or not.

### Test Data: 
Not applicable for this test case.
