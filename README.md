# food-delivery-application
Food Delivery Service Application

### Functional Requirements:
```
User can search a restaurant based on restaurant name. 
Then user can order food by choosing different menu item,
quantity and add a note about his/her diet restrictions 
and etc. 
User can also fills in the delivery address. 
After user places an order, 
the order should contain food items user ordered, 
quantity, price and order time.

User then needs to pay for his/her order by providing credit card number, 
expiration date, and security code. 

After payment is made successfully, 
it should return payment ID, 
timestamp and then the order is considered as completed 
so the user can see the estimated delivery time.
```

###Service Structure & End Point

######Restaurant Query Service

`food-delivery-restaurant-query-service`

```text Query Restaurant Detail By Restaurant Name 
GET http://localhost:8080/restaurant/query/{restaurantName}
```

```text Query Restaurant Menu
GET http://localhost:8080/restaurant/menu/{restaurantId}
```

```text Query Restaurant Comment
GET http://localhost:8080/restaurant/comment/{restaurantId}
```

```text Query Restaurant Location
GET http://localhost:8080/restaurant/location/{restaurantId}
```

######Order Service

`food-delivery-order-service`

```text Client Order Food
POST http://localhost:8080/order

Request Body:
[{
userInfo:{
    name:'John Doe'
    phone:'999111',
    address:''
},
itemInfoList:{[
    itemInfo:{
        restaurantId:'ABC',
        itemId:'001',
        quantity:1
    },
    itemInfo:{
            restaurantId:'ABC',
            itemId:'002',
            quantity:1
        },
    itemInfo:{
            restaurantId:'ABC',
            itemId:'003',
            quantity:1
        }
]},

notes:'Please help to give more xxxx, because I want some blablabla'
}]
```

```text Client Order Status
GET http://localhost:8080/order/{orderId}
```

######Payment Service

`food-delivery-payment-service`

```text Client Pay Order
POST http://localhost:8080/pay/

Request Body:
[{
orderId:'abc123456789-123-123-123',
payType:'CreditType',
creditNumber:'123456789',
expirationDate:'2020-01-01',
securityCode:'123',
ownerFirstName:'John',
ownerFamilyName:'Doe'
}]
```

```text Query Order Payment Status
GET http://localhost:8080/pay/{orderId}
```

######Recommend Service

`food-delivery-recommend-service`
```text User Food Recommend 
GET http://localhost:8080/recommend/{foodName}
```

#LICENSE

[Apache License 2.0](https://github.com/icyhins/food-delivery-service-application/blob/master/LICENSE "Apache License 2.0")