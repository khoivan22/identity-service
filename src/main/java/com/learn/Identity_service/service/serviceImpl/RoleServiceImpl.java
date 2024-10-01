package com.learn.Identity_service.service.serviceImpl;

import com.learn.Identity_service.dto.request.RoleRequest;
import com.learn.Identity_service.dto.response.RoleResponse;
import com.learn.Identity_service.mapper.RoleMapper;
import com.learn.Identity_service.repository.PermissionRepository;
import com.learn.Identity_service.repository.RoleRepository;
import com.learn.Identity_service.service.RoleService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;
    RoleMapper roleMapper;
    PermissionRepository permissionRepository;

    @Override
    public List<RoleResponse> getAll() {
        return roleRepository.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    @Override
    public RoleResponse create(RoleRequest request) {

        var role = roleMapper.toRole(request);
        var permissions = permissionRepository.findAllById(request.getPermissions());
        role.setPermissions(new HashSet<>(permissions));

        role = roleRepository.save(role);
        role.setPermissions(new HashSet<>(permissions));

        return roleMapper.toRoleResponse(role);
    }

    @Override
    public void delete(String name) {
        roleRepository.deleteById(name);
    }
}
