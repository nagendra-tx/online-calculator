Here requirement is to automate addition, substraction and division functionalities of online calculator
link: https://www.online-calculator.com/html5/online-calculator/index.php?v=10

Step 1- Created a cucumber maven project
Step 2- As this omne is canvas based application so we can't find DOM for locators. 
To perform action on specific buttoon eiother we need to rely on action classes from selenium or use javasciptexecutor class to perform javascript action.

Step 3- Once action is performed like 1+1= it will return 2 in output result display. Next step will be to match this expected value with our actula value.
Step 4- As till now we don't have find an option to gets locator or any other means to gets acces to that particular display area, we rely on taking screenshot of entire screen after performing calculation option.
Step 5- We used TakesScreenshot class to get screenshot of the calculator screen and used BufferedImage class to crop the image so that we can pass this cropped image for tess4j library to get text from cropped image.
Step 6- Using tess4j library we gets text from cropped image and peforemd equalassertion of expected value with actual value.

 
