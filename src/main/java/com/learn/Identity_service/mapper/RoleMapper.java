package com.learn.Identity_service.mapper;

import com.learn.Identity_service.dto.request.RoleRequest;
import com.learn.Identity_service.dto.response.RoleResponse;
import com.learn.Identity_service.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    @Mapping(target = "permissions", ignore = true)
    RoleResponse toRoleResponse(Role role);

    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest roleRequest);
}
