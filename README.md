
# Java E-COMMERCE WEBSITE SIMULATOR
A java e-commerce application that simulates real world e-commerce websites functionalities such as viewing products , adding products to cart and ordering products 
for customers .In addition to that , we have admin's functionalities such as removing users and  editing products .
## 1st Page 
Like every Website , we start with a authentification system where you have two options:
auth package is responsible in this part of the project.
### Sign in: 
Based on the given input , we verify your informations in the users.txt and admins.txt file and then decide whether you get access or not . A message describing the problem will be given.
### Sign up:
After giving the desired inputs , we add your informations in the file represting customers , Your password will not be visible because we use hash encryption to secure your private infos.
## 2nd Page (Customer version):
You will get an output with all the functionalities that you can use:
all these functionalities are implemented in the functionalities/adminPermission.java file
Customer will have a cart attribute that represents the items he added .
### Browsing and shopping 
you can view Products and filter them based on category , price range or rating 

you can add items to your cart , edit quantity and remove the undesired items
###  Rate Products added in your cart
Give your honest opinion about products you bought to help other customers make their decisions.

### Order products
You can proceed to checkout . 

You can apply coupons if you have to get a discount.

#Order History 
All orders will be saved in orders.txt file

## 2nd Page(Admin version):
### Products
The ability to add and edit products ( all changes will be saved in the products.txt file ) 

### Users
The ability to remove users data from the users.txt file

The ability to add a new admin to the admins.txt file

 



