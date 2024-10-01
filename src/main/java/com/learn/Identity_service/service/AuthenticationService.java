package com.learn.Identity_service.service;

import com.learn.Identity_service.dto.request.AuthenticationRequest;
import com.learn.Identity_service.dto.request.IntrospectRequest;
import com.learn.Identity_service.dto.response.AuthenticationResponse;
import com.learn.Identity_service.dto.response.IntrospectResponse;
import com.nimbusds.jose.JOSEException;

import java.text.ParseException;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest);

    IntrospectResponse introspect(IntrospectRequest request) throws JOSEException, ParseException;
}
