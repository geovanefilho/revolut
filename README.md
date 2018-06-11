Revolut Task
=================

Technology
------------
The chosen technologies:
* Java 8
* Undertow + basic http server (Servlet)
* Apache http client (for tests)
* Maven
* Hibernate
* H2 database

How to run
------------
```mvn clean install```

and after, in the target folder

```java -jar SimpleMoneyTransfer-jar-with-dependencies.jar```


Actions in the browser to do tests
------------
To create users and his account use the url like these:

```http://localhost:8080/SimpleMoneyTransfer/User?userName=Geovane&email=geovanefilho.es@gmail.com&accNumber=155&accCurrency=BRL&accBalance=21000```

```http://localhost:8080/SimpleMoneyTransfer/User?userName=JhonDoe&email=jhondoe@gmail.com&accNumber=156&accCurrency=EUR&accBalance=1000```

You can change the values of the userName, email, accNumber, accCurrency and accBalance
userName, email, accNumber accepts Strings
accCurrency accepts the following values (BRL, EUR, GBP and USD)
accBalance accepts just numbers


To find and see information of an user:

```http://localhost:8080/SimpleMoneyTransfer/FindUser?userName=Geovane```

You can change the value of userName to select another user


To do a transference between accounts:

```http://localhost:8080/SimpleMoneyTransfer/Transfer?oriAccNumber=156&destAccNumber=155&amount=1020```

You can change the value of oriAccNumber, destAccNumber and amount to do another transference.
oriAccNumber and destAccNumber accepts only accounts numbers saved before
amount accepts only numbers


To do a credit in an account

```http://localhost:8080/SimpleMoneyTransfer/Account?accNumber=156&amount=3245```

You can change the value of accNumber and amount to do another credit
accNumber accepts only accounts numbers saved before
amount accepts only numbers
