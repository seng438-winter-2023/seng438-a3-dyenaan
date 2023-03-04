**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group 12:      |     |
| -------------- | --- |
| Student Names: |     |
|Esohe Aideyan       |     |
|Jack Barrie         |  30088832   |
|Tamunomiete Brown   |     |
|Dyenaan Dapoet      |  30126758   |

# 1 Introduction

The objective of this assignment was to get familiar with white-box coverage testing by using different testing tools to analyze methods. We made use of different coverage tools, covering three different coverage metrics to test the Range and DataUtilities classes. Data Flow Coverage was manually conducted as well which helped us gain better understanding of how coverage tools work. Finally, test suites were updated to improve coverage to fit the adequacy criteria.

# 2 Manual data-flow coverage calculations for X and Y methods
DataUtilities.calculateColumnTotal
![image](https://user-images.githubusercontent.com/91904892/222872852-f039a4a5-6ff6-4cdb-aca1-caff56c7c2a1.png)
Def-use sets per statement
Def(1) = {data, column}, use(1) = {data}
Def(2) = {total}
Def(3) = {rowCount}, use(3) = {data}
Def(4) = {r}, use(4) = {r, rowCount}
Def(5) = {n}, use(5) = {data, r, column}
Def(6) = {}, use(6) = {n}
Def(7) = {}, use(7) = {total, n}
Def(9) = {r2}, use(9) = {r2, rowCount}
Def(10) = {n}, use(10) = { data, r2, column}
Def(11) = {}, Use(11) = {n}
Def(12) = {}, Use(12) = {total, n}
Def(14) = {}, use(14) = {total}
![image](https://user-images.githubusercontent.com/91904892/222872859-966709a8-4679-44cc-b5c7-5cc4ad3b2bde.png)
DU-pairs per variable
Variable	DU Pair
Data	(1,1)(1,3) (1,5) (1,10) 
column	(1,5) (1,10)
total	(2,7) (2,12) (2,14)
r	(4,4) (4,5) 
rowCount	(3,4) (3,9) 
n	(5,6) (5,7) (10,11) (10, 12)
R2	(9,9) (9,10)
![image](https://user-images.githubusercontent.com/91904892/222872879-aaacdfc4-2e0e-457b-a341-c8f0fc66bb03.png)
Pairs covered per test case
Test Case	Pairs Covered
calculateColumnTotalForFourValuesTest	(1,3)(1,5)(2,7) (2,14) (3,4) (3,9) (4,4) (4,5) (5,6) (5,7)(9,9)
calculateColumnTotalForTwoValuesTest	(1,3)(1,5)(2,7) (2,14) (3,4) (3,9) (4,4) (4,5) (5,6) (5,7)(9,9)
nullDataTest	(1,1)
![image](https://user-images.githubusercontent.com/91904892/222872892-e482b6c4-ddcc-4daf-af4d-98cdc7560e32.png)
DU-pair Coverage Calculation


Range.getLowerBound
![image](https://user-images.githubusercontent.com/91904892/222873322-1a804bea-d6d7-408f-85fa-3949686da5aa.png)
Def-use sets per statement
Def-use set per statement
D(1) =  {lower, upper} use(1) = {}
D(2) = {} use(2) = {lower, upper}
D(3) = {msg} , use(3) = {lower, upper}
D(4) = {} use(4) = {lower}
D(5) = {} use(5) = {msg}
![image](https://user-images.githubusercontent.com/91904892/222873387-9e0ea014-b3ba-4791-af4f-c79841f5dfe2.png)
DU-pairs per variable
Variable	DU Pair
lower	(1,2) (1,3) (1,4) 
upper	(1,2) (1,3)
msg	(3,5)
![image](https://user-images.githubusercontent.com/91904892/222873403-5fe56c0e-6af8-400e-8577-06ce89a61d22.png)
Pairs covered per test case
Test Case	Pairs Covered
testCorrectLowerBoundWithPositives	(1,2) (1,4)
testCorrectLowerBoundWithNegatives	(1,2) (1,4)
testCorrectLowerBound1	(1,2) (1,4)
testCorrectLowerBound2	(1,2) (1,4)
illegalArgumentTest	(1,2) (1,3) (1,4) (3,5)
![image](https://user-images.githubusercontent.com/91904892/222873480-ee66292f-2755-4960-b295-b23627636185.png)
DU-pair coverage calculation



# 3 A detailed description of the testing strategy for the new unit test
We approached the white box testing by first viewing the code coverage of the tests we wrote for assignment 2. If the coverage wasnt acceptable, we wrote additional tests for those methods. Then we worked on writing new tests to cover the remaining code in the classes Range and DataUtilities. We used EclEmma in eclipse to see the coverage. We then went method by method writing tests, until we reached sufficient coverage for the classes.

# 4 A high level description of five selected test cases you have designed using coverage information, and how they have increased code coverage
Range: Range(lower, upper)
- The test cases for the Range constructor checked for invalid input, where the upper limit is less than the lower limit, which should throw a exception.
- We also tested that the upper and lower bounds were correctly set
- This resulted in 100% code coverage

Range: constrain(double)
- The test cases first looked at if the range contained the value, which tests the if(!contains(value)) statement
- Then the test cases looked at the two branches within the if statement, first where the value is greater than the upper bound then when it is less than the lower bound. This approach resulted in most of the code being covered

Range: combine(Range, Range)
- The tests cases we wrote first covered either of the two ranges being null
- Then we wrote a test to cover the branch where neither range is null, which will result in a new range being created.
- This approach led to 100% code coverage

Range: scale(Range, double)
- We wrote a test to first cover when the double being passed is less than 0, which should throw an exception
- Then we covered the remaining code by a test that considered when the double is greater than 0
- This resulted in 100% code coverage

Range: equals(Object)
- The first branch we covered was the if statement checking if the passed object is an instance of Range.
- The next branch was testing to see if the upper bound of the passed object matches the calling objects upper bound
- The next branch was similar to the previous test, but testing the lower bound
- This approach resulted in 100% code coverage.


# 5 A detailed report of the coverage achieved of each class and method (a screen shot from the code cover results in green and red color would suffice)
![Screenshot 2023-03-03 135330](https://user-images.githubusercontent.com/85323597/222856567-0f259f49-d16f-4a64-821f-fc64db85519e.png)

# 6 Pros and Cons of coverage tools used and Metrics you report

Text…

# 7 A comparison on the advantages and disadvantages of requirements-based test generation and coverage-based test generation.

Text…

# 8 A discussion on how the team work/effort was divided and managed

Text…

# 9 Any difficulties encountered, challenges overcome, and lessons learned from performing the lab

Text…

# 10 Comments/feedback on the lab itself

Text…
