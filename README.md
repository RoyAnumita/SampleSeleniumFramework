# QA tech challenge with Raisin web page(www.raisin.com)

# What needs to be done:
Considering the following user stories, please define the tests cases, then implement an automation suite to verify it. Your solution should be committed here on this git repository.
## 1. User Stories 
Prerequisites:
Go to Raisin landing page (www.raisin.com) and choose `Other` from the list of regions when asked. The test should start from there.

### Story 1: 
##### At the Offers page (https://www.raisin.com/our-offers/):
* Check the `Easy Access` checkbox;
* Verify that the message regarding the total of offers that match the search is correctly shown in the blue bar just below the search filter.

### Story 2: 
##### Considering you have a list/collection of elements of "Easy access" offers:
* Find the offer with the highest `Interest` rate in the list;
* Click on `Register` button for this offer. 	

### Story 3: 
##### At the Banks page (https://www.raisin.com/bank/):
* Look for the bank with a Moody's Country rating = A1;
* Click on `Learn more`;
* Click on `Invest now` and check if you are being redirected to the Register form.

## 2. Create manual test cases
Prepare 5 test cases that you consider essential to cover Story 3 using any tool of your choice. You can describe the test cases using ".md" files, and delivery it along the automation suite. Otherwise, please commit the Test Case files to the git repository.

## 3. Automate the test cases 
Please automate stories above. You can use any language and framework, but we prefer Java + Selenium and Maven as the build automation tool. If you prefer to make it in another language/tool, just be aware that at Raisin you would be working with those 3 mentioned. And please, provide full instruction about how to build and execute your project.

## 4. Commit and share
Commit and push the code of your project to this repository and let us know when you have finished it. 

**Do not forget to provide full instructions about how to build and execute your solution.**

Please feel free to provide your feedback on the challenge.
