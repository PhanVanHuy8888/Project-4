package project4.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project4.dto.request.RoleRequest;
import project4.dto.response.RoleResponse;
import project4.entity.Role;
import project4.mapper.RoleMapper;
import project4.repository.RoleRepo;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepo roleRepo;

    private final RoleMapper roleMapper;

    public RoleResponse createRole(RoleRequest request) {
        Role role = roleMapper.createRole(request);
        return roleMapper.toRoleResponse(roleRepo.save(role));
    }

    public RoleResponse updateRole(String name, RoleRequest request) {
        Role role = roleRepo.findById(name).orElseThrow(() -> new RuntimeException("Role not found by name = " + name));
        roleMapper.updateRole(role, request);
        return roleMapper.toRoleResponse(roleRepo.save(role));
    }

    public List<RoleResponse> getAll() {
        return roleRepo.findAll().stream().map(roleMapper::toRoleResponse).toList();
    }

    public RoleResponse getRoleById(String name) {
        return roleMapper.toRoleResponse(roleRepo.findById(name).orElseThrow(() -> new RuntimeException("Role not found by name = " + name)));
    }


    public void deleteRole(String name) {
        roleRepo.deleteById(name);
    }
}
