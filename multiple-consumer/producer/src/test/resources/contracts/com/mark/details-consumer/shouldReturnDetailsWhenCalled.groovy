package com.mark.details

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return user info when called from login"
    request {
        method GET()
        url("/account") {
            queryParameters {
                parameter("name", "mark")
                parameter("password", "password123")
            }
        }
    }
    response {
        status 200
        headers {
            contentType(applicationJson())
        }
        body """
                {
                    "name" : "mark" ,
                    "email" : "mark@abc.com" ,
                    "password" : "password123" ,
                    "id" : 123 ,
                    "lastLoggedIn" : "2019-01-01" ,
                    "phoneNumber" : 123
                }
            """
    }
}