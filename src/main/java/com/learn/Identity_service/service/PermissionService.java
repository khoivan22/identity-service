package com.learn.Identity_service.service;

import com.learn.Identity_service.dto.request.PermissionRequest;
import com.learn.Identity_service.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {
    List<PermissionResponse> getAll();

    PermissionResponse create(PermissionRequest request);

    void delete(String name);
}
