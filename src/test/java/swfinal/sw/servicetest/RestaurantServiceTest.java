package swfinal.sw.servicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import swfinal.sw.dto.RestaurantDto;
import swfinal.sw.entity.RestaurantEntity;
import swfinal.sw.mapper.RestaurantMapper;
import swfinal.sw.repository.RestaurantRepository;
import swfinal.sw.service.RestaurantService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class RestaurantServiceTest {

    @Mock
    private RestaurantRepository restaurantRepository;
    @Mock
    private RestaurantMapper restaurantMapper;

    @InjectMocks
    private RestaurantService restaurantService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAll() {
        List<RestaurantEntity> entities = List.of(new RestaurantEntity());
        List<RestaurantDto> dtos = List.of(new RestaurantDto());

        when(restaurantRepository.findAll()).thenReturn(entities);
        when(restaurantMapper.toDtoList(entities)).thenReturn(dtos);

        assertEquals(dtos, restaurantService.getAll());
        verify(restaurantRepository).findAll();
    }

    @Test
    void testCreate() {
        RestaurantDto dto = new RestaurantDto();
        RestaurantEntity entity = new RestaurantEntity();

        when(restaurantMapper.toEntity(dto)).thenReturn(entity);

        restaurantService.create(dto);

        verify(restaurantRepository).save(entity);
    }

    @Test
    void testUpdate_Success() {
        Long id = 1L;
        RestaurantDto dto = new RestaurantDto();
        dto.setName("New Name");
        dto.setAddress("New Address");

        RestaurantEntity entity = new RestaurantEntity();

        when(restaurantRepository.findById(id)).thenReturn(Optional.of(entity));

        restaurantService.update(id, dto);

        assertEquals("New Name", entity.getName());
        verify(restaurantRepository).save(entity);
    }

    @Test
    void testDelete() {
        restaurantService.delete(1L);
        verify(restaurantRepository).deleteById(1L);
    }
}