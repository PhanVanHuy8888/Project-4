package project4.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import project4.dto.request.OrderRequest;
import project4.entity.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    @Mapping(target = "status", ignore = true)
    @Mapping(target = "code", ignore = true)
    @Mapping(target = "createDate", ignore = true)
    Order createOrder(OrderRequest request);

}
