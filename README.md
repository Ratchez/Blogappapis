# Blog App Apis
## Author
Roy Rasugu

## Description
This is a blog app application where as a normal user, one can view blog posts, search for blog posts by the post name, by which category it's under either by editor or admin who have special priviledge roles. A normal user can also edit their own details by user profile. Editor is able to do what a normal user can do and be able to create blog posts, edit blog posts they have posted, delete posts they have posted. The same applies for categories as well. Finally the admin is the super user who can do what both a normal user and editor can do, furthermore, an admin can delete users.

## Livepage
[livelink](http://blogwebapp-env.eba-xdx3tmsm.ap-southeast-2.elasticbeanstalk.com/swagger-ui/index.html)

## Setup Requirements
* Springboot
* Java
* MYSQL

## Setup Installation
* Copy the github repository url
* Clone to your computer
* Open terminal and navigate to the directory of the project you just cloned to your computer
* To the top right of IntelliJ IDE, you'll see the maven name on display, click on it and tap the refresh icon to download the specific dependenices that will not be recognized by the springboot application
* To run the server
* Click the main application java class and run it
* Test the apis using postman
* View the data stored in the database in MYSQL workbench

## Technologies used
* Java
* Springboot
* MYSQL
* Postman
* MYSQL workbench

## Dependencies
1. With swagger-ui index.html, one is able to see the various controllers that have specific CRUD functionalities.
2. All the other controllers are secured and one cannot access them without a JWT access token that's only issued once one logs in.
3. The first process for a new user, one will start of by going to through the auth controller where one presses the ```/api/v1/auth/register``` button signs up by inputting their specific credentials and in return they will see their credentials have been saved.
4. If one inputs an email that already exists, the data is checked whether it exists in the database. In the case where it does, it will not go through as the email belongs to another user.
5. Once that is done, still on the same auth controller one will see the ```api/v1/auth/login``` button where they will input their specific credentials and if they are correct, one will be issued with a JWT acess token and one is able to access some specific CRUD functionalities according to their roles. If the login credentials are false one will get an error message saying their credentials are invalid.
6. If one tries to access the other controllers apart from the auth controllers without a JWT access token then they will receive a http 403 error code saying they are forbidden since they have no access rights to perform the functionalities. 
7. If a normal user with a JWT access token tries to post a blog they will also receive the same http 403 error code because they do not have the authority to perform the functionality. Also if an editor tries to delete a user with their JWT access token they will be forbidden as an admin is the only one with the authority to do so.
8. One can log out by tapping the ```authorize``` button where after they put their JWT access token to login, there is an option to logout.

## Known Bugs
* Issuing of roles does not work as well and it's done by assigning manually through the database.

## Contact Information

You can reach me on my email [royratchizi@gmail.com]

## License
* *MIT License:*
* Copyright (c) 2023 **Roy Rasugu**