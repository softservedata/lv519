# SingUpTests
Implementation of automation tests for registration page according to different test cases.
Project divided into 4 parts:

#test.logic  
In this part, we declare action sequence and assert result.

#constantParameters
In this part, we declare selectors, links, etc. 
That gives us an opportunity to use it in methods parameters to avoid misclicks, also make code more readable.

#widgets
Classes and methods to interact with different parts of project.
Like open that open page, click, setFor(send string to input), etc;
Some of them have multiple realizations.

#verifications
Interfaces that contains default and abstract methods with asserts and compare.

#helpers
Methods like screenshot, delay, command line to use cmd.exe, etc. 
Just to make life easier. Unnecessary but useful.


Extra part
#EmailUtils
Bunch of methods to interact with email.

