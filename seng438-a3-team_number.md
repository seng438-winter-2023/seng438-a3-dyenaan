**SENG 438 - Software Testing, Reliability, and Quality**

**Lab. Report #3 – Code Coverage, Adequacy Criteria and Test Case Correlation**

| Group \12:      |     |
| -------------- | --- |
| Student Names: |     |
|Esohe Aideyan       |     |
|Jack Barrie         |  30088832   |
|Tamunomiete Brown   |     |
|Dyenaan Dapoet      |  30126758   |

# 1 Introduction

The objective of this assignment was to get familiar with white-box coverage testing by using different testing tools to analyze methods. We made use of different coverage tools, covering three different coverage metrics to test the Range and DataUtilities classes. Data Flow Coverage was manually conducted as well which helped us gain better understanding of how coverage tools work. Finally, test suites were updated to improve coverage to fit the adequacy criteria.

# 2 Manual data-flow coverage calculations for X and Y methods




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
