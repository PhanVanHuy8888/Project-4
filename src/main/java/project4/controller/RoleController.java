package project4.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project4.dto.request.RoleRequest;
import project4.dto.response.RoleResponse;
import project4.service.RoleService;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@RequiredArgsConstructor
public class RoleController {
    private final RoleService roleService;

    @PostMapping
    public RoleResponse createRole(@RequestBody RoleRequest request) {
        return roleService.createRole(request);
    }

    @GetMapping("/list")
    public List<RoleResponse> getAllRole() {
        return roleService.getAll();
    }

    @GetMapping("/{name}")
    public RoleResponse getRoleById(@PathVariable String name) {
        return roleService.getRoleById(name);
    }

    @PutMapping("/{name}")
    public RoleResponse updateRole(@PathVariable String name, @RequestBody RoleRequest request) {
        return roleService.updateRole(name, request);
    }

    @DeleteMapping("/{name}")
    public String deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
        return "Role has been deleted";
    }

}
