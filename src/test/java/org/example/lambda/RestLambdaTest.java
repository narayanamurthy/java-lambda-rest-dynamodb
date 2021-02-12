package org.example.lambda;

import org.example.lambda.model.Address;
import org.example.lambda.util.TestContext;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.beans.EventHandler;

import static org.junit.jupiter.api.Assertions.*;

class RestLambdaTest {

    private RestLambda restLambda;

    @BeforeEach
    private void init() {
        restLambda = new RestLambda();
    }


    @Test
    void testCreate() {
        // Given
        Address address = new Address();
        address.setLine1("Line 1");
        address.setLine2("Line 2");
        address.setLine3("Line 3");
        address.setLocation("Location");

        // When
        Address createdAddress = restLambda.create(address,new TestContext());

        // Then
        Assertions.assertNotNull(createdAddress.getId(),"Address Created Successfully");
    }
}