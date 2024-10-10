package com.learn.Identity_service.service;

import com.learn.Identity_service.dto.request.RoleRequest;
import com.learn.Identity_service.dto.response.RoleResponse;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

//@PreAuthorize("hasRole('admin')")
@PreAuthorize("hasRole('admin') or hasRole('pm')")
//@RolesAllowed({ "admin", "user" })
public interface RoleService {

    //    @PreAuthorize("hasRole('admin')")
    List<RoleResponse> getAll();

    RoleResponse create(RoleRequest request);

    void delete(String name);
}
