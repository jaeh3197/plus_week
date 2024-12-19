package com.example.demo.util;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PasswordEncoderTest {

    PasswordEncoder encoder;

    @Test
    void encode() {
        String password = "password";
        String encodedPassword = encoder.encode(password);
        System.out.println(encodedPassword);
    }

    @Test
    void matches() {
        String encodedPassword = "$2a$04$RypROaN/IrB4BcsfOchH9.ec5kQfuCr8rN.DNYURN6NrNsHVFZQFe";

        String newpassword = "password";

        if (encoder.matches(newpassword, encodedPassword)) {
            System.out.println("matched");
        } else {
            System.out.println("not matched");
        }
    }
}