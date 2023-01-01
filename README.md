# Software_project

 # i) How to build the project

1) the project run on Eclipse IDE for Enterprise Java and Web Developers (2022-12)

2) have application server tomcat installed in Eclipse IDE

3) put the project in the same direct of tomcat

4) run project as maven project 

5) from Eclipse select file -> select open project from file system

6) choose Directory and import the project

7) make sure portnumber : 8084 in file application.properties with path src/resouces

8) run the project ^_^

 
# ii) Note
1) this maven project depends on Java 11

1) mybe you need to setup tomcat as jdk 17.0.5 for this use this link https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html


# iii) Project overview

                                                               Description

In this project you will work on building something similar to Fawry system. This system should be user by users to pay for different services.
The initial services are
1) Mobile recharge services.
i Vodafone

ii Etisalat

iii. Orange

iv. We

2) Internet Payment services.
i. Vodafone

ii. Etisalat

iii. Orange

iv. We

3) Landline services
i. Monthly receipt

ii. Quarter receipt 

4) Donations
i. Cancer Hospital

ii. Schools

iii. NGOs (Non profitable organizations)

                                                          Requirements User
1) The user should be able to sign-in to the system. Given the user’s email and a
password, the user can login to the system and use any of the system functionalities.

2) The user should be able to sign up to the system. The user should provide his
username, email and password. The system should check if the username or the email
is registered before, if they are not registered before then the signup process should
complete successfully, if not, the system will show an error to the user

3) The user should be able to search for any service in the system. The user can type the
service name and the system will return all services that match the user query.

4) The user can pay for any service in the system. The system should prompt the user to
the payment form when the user asks to pay for any service. The default way is to pay
via credit card. The system should allow the user to consume from the wallet (check
Req. 6) for this payment. If the service that should to receive the payment accepts cache
on delivery, then this option should be visible too.

5) The user can ask for a refund for any complete transaction to any given service. The
refund request will be issued by the user and sent to the admin. If the admin approves
the refund then the refund process should complete successfully.

6) The system maintain a wallet balance for each user. The user should be able to add any
funds to the wallet. Adding funds to the wallet should be done via credit card.

7) The user should be able to check any discount for any service in the system. Discounts
could be added by the admin (this will be discussed later).

                                                                    Admin
1) The admin should be able to add any new service provider to the system. Provider
consists of a form to be sent to the user and a handler for this form. So for example
Vodafone Cash provider consists of a form (Mobile number, amount) and a handler for
this form (given the user answers to this form then provider will handle the user request).
The form could consist of any number of field. The type of fields that are supported are
text field and drop down field

2) The admin should be able to add discounts to the system. There are two types of discounts.

a. Overall discounts. For example the user should have 10% discount for the first
transaction (regardless the service)

b. Specific discount.. For example the admin can apply 20% discount for all mobile
recharge services.

For any given service. All overall discounts and specific discounts for this service should
apply.

3) The admin should be able to list all user transactions. The transactions types are
a. Payment transaction.

b. Add to wallet transaction.

c. Refund transaction.

4) The admin should be able to list all refund requests. Each refund request should contain the related service and the amount to be refunded.
The admin should be able to accept or reject any refund request and if any refund request got accepted a refund transaction
should be processed.



