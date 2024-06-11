package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import project4.dto.request.UserRequest;
import project4.dto.response.UserResponse;
import project4.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUser(UserRequest request);

    UserResponse toUserResponse(User user);

    void updateUser(@MappingTarget User user, UserRequest request);
}
