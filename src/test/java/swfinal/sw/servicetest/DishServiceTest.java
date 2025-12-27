package swfinal.sw.servicetest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import swfinal.sw.dto.DishDto;
import swfinal.sw.entity.DishEntity;
import swfinal.sw.mapper.DishMapper;
import swfinal.sw.repository.DishRepository;
import swfinal.sw.service.DishService;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.*;

class DishServiceTest {

    @Mock
    private DishRepository dishRepository;

    @Mock
    private DishMapper dishMapper;

    @InjectMocks
    private DishService dishService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Тест получения всех блюд")
    void testGetAll() {
        List<DishEntity> entities = List.of(new DishEntity());
        List<DishDto> dtos = List.of(new DishDto());

        when(dishRepository.findAll()).thenReturn(entities);
        when(dishMapper.toDtoList(entities)).thenReturn(dtos);

        List<DishDto> result = dishService.getAll();

        assertEquals(dtos, result);
        verify(dishRepository).findAll();
    }

    @Test
    @DisplayName("Тест создания нового блюда")
    void testCreate() {
        DishDto dto = new DishDto();
        DishEntity entity = new DishEntity();

        when(dishMapper.toEntity(dto)).thenReturn(entity);

        dishService.create(dto);

        verify(dishRepository).save(entity);
    }

    @Test
    @DisplayName("Тест фильтрации по диапазону цен")
    void testFindByPriceRange() {
        DishEntity d1 = new DishEntity();
        d1.setPrice(100.0);

        DishEntity d2 = new DishEntity();
        d2.setPrice(500.0);

        List<DishEntity> entities = List.of(d1, d2);

        when(dishRepository.findAll()).thenReturn(entities);

        dishService.findByPriceRange(50.0, 200.0);

        verify(dishMapper).toDtoList(argThat(list ->
                list.size() == 1 && list.get(0).getPrice() == 100.0
        ));
    }

    @Test
    @DisplayName("Тест удаления блюда")
    void testDelete() {
        Long dishId = 1L;

        dishService.delete(dishId);

        verify(dishRepository).deleteById(dishId);
    }
}