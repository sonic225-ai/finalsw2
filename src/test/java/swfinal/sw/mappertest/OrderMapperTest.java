package swfinal.sw.mappertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import swfinal.sw.dto.OrderDto;
import swfinal.sw.entity.DishEntity;
import swfinal.sw.entity.OrderEntity;
import swfinal.sw.mapper.OrderMapper;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class OrderMapperTest {

    @Autowired
    private OrderMapper orderMapper;

    @Test
    void testToDtoWithDishes() {
        DishEntity d1 = new DishEntity(); d1.setId(10L);
        DishEntity d2 = new DishEntity(); d2.setId(11L);

        OrderEntity entity = new OrderEntity();
        entity.setId(100L);
        entity.setDishes(List.of(d1, d2));

        OrderDto dto = orderMapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(100L, dto.getId());
        assertEquals(2, dto.getDishIds().size());
        assertTrue(dto.getDishIds().contains(10L));
        assertTrue(dto.getDishIds().contains(11L));
    }

    @Test
    void testToDtoList() {
        OrderEntity e1 = new OrderEntity(); e1.setId(1L);
        OrderEntity e2 = new OrderEntity(); e2.setId(2L);
        List<OrderEntity> entities = List.of(e1, e2);

        List<OrderDto> dtos = orderMapper.toDtoList(entities);

        assertEquals(2, dtos.size());
        assertEquals(1L, dtos.get(0).getId());
        assertEquals(2L, dtos.get(1).getId());
    }
}