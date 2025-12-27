package swfinal.sw.mappertest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import swfinal.sw.dto.RestaurantDto;
import swfinal.sw.entity.RestaurantEntity;
import swfinal.sw.mapper.RestaurantMapper;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RestaurantMapperTest {

    @Autowired
    private RestaurantMapper restaurantMapper;

    @Test
    void testToDto() {
        RestaurantEntity entity = new RestaurantEntity();
        entity.setId(1L);
        entity.setName("Astana Pizza");

        RestaurantDto dto = restaurantMapper.toDto(entity);

        assertNotNull(dto);
        assertEquals(entity.getId(), dto.getId());
        assertEquals(entity.getName(), dto.getName());
    }
}