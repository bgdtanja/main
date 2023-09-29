`                                                       `**Test report**

Project information:Pets Meet app ,https://petsmeet.org/

The application for animal lovers, enables the creation of pet profiles, information about pet friendly facilities, connecting owners and joint pet walks,and many other features.

Team assigned:Tanja Ćerimović

**Document overview:**

**Scope:**

Log in

Home page:

Creating a new post with the photo

Commenting on posts

Following other users

Send and receive messages 

The appearance of notifications

Opening and viewing other users profile

Explore page:

Every field and every image are visible and clickable

Section “Map” is functional

Reels page:

Visibility of all Reels posts

Pet page:

Walk pet

Grooming session

Training session

Adoption

Profile page:

Change profile picture

Change contact info/update profile

View numbers of posts,followers and users follow

Add pet

Change pet photo

Settings on profile page:

Security-change password

Security-delete account

Security-delete pet account

Change language 

Log out

**Not in scope:**

Reels page:

Posting a new Reels posts

Match pet

Report pet as lost

Test objective:

Found 4 potential bugs:

2 High priority

1 Medium priority

1 Low priority

All 4 bugs are Functional bugs

The number of test cases executed:30

The number of test cases passed:22

The number of test cases failed:4

The number of test cases skipped:4

Pass percentage:73,4 %

Fail percentage:13.3 %

Skipped percentage:13,3 %

Comments:

Blockers and critical issues are not found.

Skipped sections are:

Recommended activities:View all

Grooming session

Training session

Adoption

Test are skipped because of the functionality is not yet complete.(Coming soon)

Defects:

Total number of bugs:4

Breakdown by severity and priority:

There are 4 functional bugs with 2 high priority ,1 medium and 1 low severity/priority.

Testing executed:

Exploratory testing.

**Test executed details:**

Number of tests by type:

Passed:22

Failed:4

Skipped:4

4 bugs are found.

Login page

**Summary bug 01:**

Reset password page - Form is not submiting with valid registered email.

Expected result:An email is sent to the user with a link to reset the password

Actual result:Form is not submited.Error message displayed under the field Email:”Email already exist”


**Summary bug 02:**

At section "Add pet" list of dogs breed is not visible after the first click

Expected result:User is able to choose breed type out of the list

Actual result:The list with dog breeds does not appear, even though the user has already clicked and marked the dog's image in step no. 5,It only appears message: "First choose the type of pet".The user must click again several times on the dog's image and again on the breed field in order for the list from which he must choose to appear.


**Summary bug 03:**

App is crashed after user click on back button several times

Expected result:User exit the app without any problems

Actual result:When user exit the app crash message dialog appears.

**Summary bug 04:**

No new message notification

Expected result:When another user sends us a message, we receive a notification

about the received message or a red number with new unread messages

appears on the message icon.

Actual result:When another user sends us a message, there is no notification

of a new incoming message. The message can only be seen when we click on the message icon.




**Test environment:**

Devices:

Mobile phone Motorola G72-Android 12

Laptop HP EliteBook 8540w- Windows 10-Chrome version

**Recomendation:**

We can add new features which can improve the users expirience and stand out from the competition.

**1.Improvement:**

Current:Home page is without content. It only says "no post yet"

Request:The “Cat and dogs 20 take care tips”content of the "explore" tab should be transferred to the Home page

Reason:When the home page is empty, there is nothing to interest the user to continue using the application.

**2.Improvement:**

Current:In the "Pet friendly" section there are only parks for dogs.

Request:In the section “Pet friendly”at “Explore our partners”,add partners which are pet friendly, cafes, restaurants, hotels etc.And for all types of pets.

Reason:That information is of more interest to pet owners

**3.Improvement:**

Current:Pet username are mandatory and can only be entered in lowercase letters. Only Pet username are written under the picture of the dog.

Request:Make it possible to write the dog's name under the picture instead of username

Reason:Pet username is unnecessary. Alternatively if it must exist,make it possible to start with uppercase letter.

**4.Improvement:**

Current:In the "Map" option, only the current location and objects near it are shown

Request:In the "Map" option, enable entering a certain address / street / part of the city

Reason:Users are sometimes interested in whether there is a veterinarian or a park in another part of the city where they are going

**5.Improvement:**

Current:User search is only possible by name or username

Request:Enable "near me"or “ Nearby” search option.The user clicks on “Nearby” and a list of nearby users appears.

Reason:People connect more easily with people who are close to them

**6.Improvement:**

Current:The entire website www.petsmeet.org is in English

Request:Add the option of choosing the Serbian language,or some others languages,too

Reason:Considering that there are many users from Serbia, those who do not know English will not be able to read what is written on the site.

**7.Improvement:**

Current:If some information about the pet is incorrect, there is no option to change it.The only solution is to delete the entire profile of the pet and create a new one.

Request:Add edit option in the Profile section to edit the information about pet. After user click on pet icon the comment is visible to edit, user should have two options Edit or Cancel.

Reason:Users often make mistakes when entering data for the first time, it is necessary to enable editing


**Exit criteria:**

No critical bugs are found.

Any other opened issues have an action planned and are targeted for the next release cycle.










