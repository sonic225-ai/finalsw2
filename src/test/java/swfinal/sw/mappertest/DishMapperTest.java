package swfinal.sw.mappertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import swfinal.sw.dto.DishDto;
import swfinal.sw.entity.DishEntity;
import swfinal.sw.entity.RestaurantEntity;
import swfinal.sw.mapper.DishMapper;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DishMapperTest {

    @Autowired
    private DishMapper dishMapper;

    @Test
    void testToDto() {
        RestaurantEntity restaurant = new RestaurantEntity();
        restaurant.setId(5L);

        DishEntity entity = new DishEntity();
        entity.setId(1L);
        entity.setName("Pasta");
        entity.setPrice(2500.0);
        entity.setRestaurant(restaurant);

        DishDto dto = dishMapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
        assertEquals(entity.getPrice(), dto.getPrice());
        assertEquals(5L, dto.getRestaurantId());
    }

    @Test
    void testToEntity() {
        DishDto dto = DishDto.builder()
                .id(1L)
                .name("Pasta")
                .price(2500.0)
                .build();

        DishEntity entity = dishMapper.toEntity(dto);

        assertNotNull(entity);
        assertEquals(dto.getName(), entity.getName());
        assertEquals(dto.getPrice(), entity.getPrice());
    }
}