package com.learn.Identity_service.controller;


import com.learn.Identity_service.dto.request.AuthenticationRequest;
import com.learn.Identity_service.dto.request.IntrospectRequest;
import com.learn.Identity_service.dto.response.ApiResponse;
import com.learn.Identity_service.dto.response.AuthenticationResponse;
import com.learn.Identity_service.dto.response.IntrospectResponse;
import com.learn.Identity_service.service.AuthenticationService;
import com.nimbusds.jose.JOSEException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class AuthenticationController {

    private static final Logger log = LoggerFactory.getLogger(AuthenticationController.class);
    AuthenticationService authService;

    @PostMapping("/token")
    ApiResponse<AuthenticationResponse> authenticate(@RequestBody AuthenticationRequest request) {

        return ApiResponse.<AuthenticationResponse>builder()
                .result(authService.authenticate(request))
                .build();
    }

    @PostMapping("/introspect")
    ApiResponse<IntrospectResponse> introspect(@RequestBody IntrospectRequest request) throws ParseException, JOSEException {

        return ApiResponse.<IntrospectResponse>builder()
                .result(authService.introspect(request))
                .build();
    }
}
