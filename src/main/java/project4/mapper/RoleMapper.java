package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import project4.dto.request.RoleRequest;
import project4.dto.response.RoleResponse;
import project4.entity.Role;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    Role createRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);

    void updateRole(@MappingTarget Role role, RoleRequest request);
}
