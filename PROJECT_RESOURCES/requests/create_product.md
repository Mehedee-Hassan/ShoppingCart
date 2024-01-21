### CREATE PRODUCT

```commandline
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--header 'Cookie: csrftoken=4qNKaGyIymwnKbHuC23Sn2EoGPGFFOY3' \
--data '{
"name" : "Samsung",
"price": 2100,
"quantity": 2
}'

```

```commandline
curl --location 'http://localhost:8080/product' \
--header 'Content-Type: application/json' \
--header 'Cookie: csrftoken=4qNKaGyIymwnKbHuC23Sn2EoGPGFFOY3' \
--data ' {
     "name" : "iPhone",
     "price": 1100,
     "quantity": 3
 },

```


### CHECK PRODUCT WITH ID

```commandline

curl --location 'http://localhost:8080/product/1' \
--header 'Cookie: csrftoken=4qNKaGyIymwnKbHuC23Sn2EoGPGFFOY3' \
--data ''
```