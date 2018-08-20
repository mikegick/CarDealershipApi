# Car Dealership Web Security Project

## Background
* You will need to create a Mongo Database called CarDealership. Run it through Docker
* You will work in pairs for this exercise
* You will have 30 minutes to complete this exercise

## Part 1
A car dealership has approached you to ask you to update their API to have user password protection.
They've done some research and found that the industry standard is to use a salt to hash passwords when new users are created.
>Update the code to incorporate using a salt with a hash to save user's passwords in the database.
>Your code should be in the appropriate layer of the multi-layered architecture\nYou will need to add application logic as well as updating the entity model to reflect changes

## Part 2
The car dealership has found that while the passwords in the database are now properly encrypted, they now need the ability to log in.
>Add a new endpoint to their API that will receive their Usernames and Passwords and return true if it matches the values in the database

## Part 3 (Stretch Goal)
The car dealership is very happy with all the functionality that you have provided, however, they don't like having to log in to the system every single time they want to make a change.
They were wondering if it was possible to log in once at the beginning, and stay logged in until they are done working.
>Add functionality to your application to generate a JWT when a user logs in that is passed back to the user if they pass in the correct credentials
>Add functionality to your application to receive a JWT on all endpoints to verify the user making the request