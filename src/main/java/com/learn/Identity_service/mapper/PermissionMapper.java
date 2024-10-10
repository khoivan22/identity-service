package com.learn.Identity_service.mapper;

import com.learn.Identity_service.dto.request.PermissionRequest;
import com.learn.Identity_service.dto.response.PermissionResponse;
import com.learn.Identity_service.entity.Permission;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PermissionMapper {

    PermissionResponse toRoleRespose(Permission permission);

    Permission toRole(PermissionRequest permissionRequest);
}
