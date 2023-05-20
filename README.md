# otp-mobil

-A program futattása előtt MySQL adatbázis létrehozás és bekonfigurálása szükséges.
-A riport01-et az alábbi SQL lekérdezéssel hoztam létre és a src/main/resources/static mappába mentettem:

``` sql 
SELECT name, address, SUM(amount) as purchase FROM otp_mobil.customer
LEFT join otp_mobil.payment p on customer.webshop_customer_id = p.webshop_customer_id
GROUP BY customer.webshop_customer_id;
```

-top.csv ugyanígy a src/main/resources/static mappába mentettem:

``` sql 
SELECT name, address, SUM(amount) as purchase FROM otp_mobil.customer
LEFT join otp_mobil.payment p on customer.webshop_customer_id = p.webshop_customer_id
GROUP BY customer.webshop_customer_id
LIMIT 2;
```
