/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.smartcrop.restApi.controllers;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.smartcrop.restApi.model.dto.Token;
import com.smartcrop.restApi.model.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Frederick
 */
@RestController
@RequestMapping("/api")
public class AuthController {
    @RequestMapping(value = "/auth/validate", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<?> validarToken(@RequestBody Token token) {
        Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
        try {
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("http://localhost:8081/api/login")
                    .build();

            DecodedJWT decodedJWT = verifier.verify(token.getAccess_token());

            System.out.println("Verify JWT token success.");
        } catch (JWTVerificationException ex) {
            System.out.println("Verify JWT token fail: " + ex.getMessage());
            return ResponseEntity.status(406).build();
        }
        return ResponseEntity.ok().build();
    }
}
