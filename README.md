Utibu Health Backend Documentation
Introduction
The Utibu Health backend is responsible for managing orders, products, users, 
and authentication for the Utibu Health system. It provides RESTful endpoints for interacting with these entities.

Technologies Used
Java
Spring Boot
Spring Security
Hibernate
H2 Database (for development)
JPA
Maven

Endpoints

The project runs on the url: http://localhost:8080

Orders
POST /orders
Endpoint for placing a new order.
Accepts order details and saves the order in the database.
Request:

{
"userId": 1,
"items": [
    {
    "productId": 1,
    "quantity": 2
    },
    {
    "productId": 2,
    "quantity": 1
    }
]
}


GET /orders/{orderId}
Endpoint for retrieving details of a specific order.
Requires orderId as path parameter.
Response:

{
"id": 123,
"userId": 1,
"items": [
{
"productId": 1,
"quantity": 2
},
{
"productId": 2,
"quantity": 1
}
]
}

GET /orders/history/{userId}
Endpoint for retrieving order history for a specific user.
Requires userId as path parameter.
Response:

[  {    "id": 123,    "userId": 1,    "items": [      {        "productId": 1,        "quantity": 2      },      {        "productId": 2,        "quantity": 1      }    ]
},
{
"id": 124,
"userId": 1,
"items": [
{
"productId": 3,
"quantity": 1
}
]
}
]


GET /orders
Endpoint for retrieving all orders in the system.
Response:

[  {    "id": 123,    "userId": 1,    "items": [      {        "productId": 1,        "quantity": 2      },      {        "productId": 2,        "quantity": 1      }    ]
},
{
"id": 124,
"userId": 2,
"items": [
{
"productId": 3,
"quantity": 1
}
]
}
]

Products
GET /products
Endpoint for retrieving all products available in the system.
Response:

[  {    "id": 1,    "name": "Medicine A",    "price": 10.99  },  {    "id": 2,    "name": "Medicine B",    "price": 15.99  }]


GET /products/{productId}
Endpoint for retrieving details of a specific product.
Requires productId as path parameter.

Response:
{
"id": 1,
"name": "Medicine A",
"price": 10.99
}

How to Test
Use tools like Postman or curl to send requests to the provided endpoints.
Verify that the responses match the expected output as described in the documentation.

Conclusion
The Utibu Health backend provides a set of RESTful endpoints for managing users, orders, and products. Follow the provided instructions to test each endpoint and verify the functionality of the system.
