package com.learn.Identity_service.service.serviceImpl;

import com.learn.Identity_service.dto.request.PermissionRequest;
import com.learn.Identity_service.dto.response.PermissionResponse;
import com.learn.Identity_service.mapper.PermissionMapper;
import com.learn.Identity_service.repository.PermissionRepository;
import com.learn.Identity_service.service.PermissionService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class PermissionServiceImpl implements PermissionService {

    PermissionRepository permissionRepository;
    PermissionMapper permissionMapper;

    @Override
    public List<PermissionResponse> getAll() {
        return permissionRepository.findAll().stream().map(permissionMapper::toRoleRespose).toList();
    }

    @Override
    public PermissionResponse create(PermissionRequest request) {

        var permission = permissionMapper.toRole(request);
        permission = permissionRepository.save(permission);

        return permissionMapper.toRoleRespose(permission);
    }

    @Override
    public void delete(String name) {
        permissionRepository.deleteById(name);
    }
}
