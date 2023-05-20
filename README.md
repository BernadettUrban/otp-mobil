# otp-mobil

- A program futattása előtt MySQL adatbázis létrehozás és bekonfigurálása szükséges.
- http://localhost:8080/savePayments és http://localhost:8080/saveCustomers endpointon az adatbázis feltöltése a csv fájl alapján

- A riport01-et az alábbi SQL lekérdezéssel hoztam létre és a src/main/resources/static mappába mentettem:

``` sql 
SELECT name, address, SUM(amount) as purchase FROM otp_mobil.customer
LEFT join otp_mobil.payment p on customer.webshop_customer_id = p.webshop_customer_id
GROUP BY customer.webshop_customer_id;
```

- top.csv ugyanígy a src/main/resources/static mappába mentettem:

``` sql 
SELECT name, address, SUM(amount) as purchase FROM otp_mobil.customer
LEFT join otp_mobil.payment p on customer.webshop_customer_id = p.webshop_customer_id
GROUP BY customer.webshop_customer_id
LIMIT 2;
```
- report02.csv lekérdezése:
``` sql 
SELECT otp_mobil.payment.webshop_id, SUM(CASE WHEN payment_mode LIKE 'card' THEN amount END) as cardPurchase,
       SUM(CASE WHEN payment_mode LIKE 'transfer' THEN amount END) as transferPurchase
FROM otp_mobil.payment
GROUP BY webshop_id;
```