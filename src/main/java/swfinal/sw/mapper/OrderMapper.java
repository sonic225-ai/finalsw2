package swfinal.sw.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import swfinal.sw.dto.OrderDto;
import swfinal.sw.entity.DishEntity;
import swfinal.sw.entity.OrderEntity;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    default List<Long> mapDishListToLongList(List<DishEntity> dishes) {
        if (dishes == null) {
            return null;
        }
        return dishes.stream()
                .map(DishEntity::getId)
                .collect(Collectors.toList());
    }

    @Mapping(source = "dishes", target = "dishIds")
    OrderDto toDto(OrderEntity orderEntity);

    @Mapping(target = "dishes", ignore = true)
    OrderEntity toEntity(OrderDto orderDto);

    List<OrderDto> toDtoList(List<OrderEntity> orderEntityList);
}