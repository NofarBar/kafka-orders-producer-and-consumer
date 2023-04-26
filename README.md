# kafka-orders-consumer-producer

In kafka-compose and mysql-compuse run:

docker-compose


in order-consumer and order managet run:

mvn spring-boot:run


To create new order you can run:

curl --location 'http://127.0.0.1:8081/1/orders' \
--header 'Content-Type: application/json' \
--data-raw '{
    "date":"2023-04-25T11:29:06.708Z",
    "shopper_email": "tony stark",
    "shopper_first_name": "tony@gmal.com",
    "shopper_last_name": "test",
    "list_of_products": [{
        "product_id": 1,
        "product_name": "test",
        "product_description": "test",
        "external_product_id": 10,
        "product_price": 13.2,
        "quantity": 10
    }]


}'

 
