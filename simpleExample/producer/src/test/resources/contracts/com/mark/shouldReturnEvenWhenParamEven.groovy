package com.mark

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return odd when number is odd"
    request {
        method GET()
        url ("/validate/odd-number") {
            queryParameters {
                parameter("number", "2")
            }
        }
    }
    response {
        body "Even"
        status 200
    }
}