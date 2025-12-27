package swfinal.sw.servicetest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import swfinal.sw.dto.OrderDto;
import swfinal.sw.entity.OrderEntity;
import swfinal.sw.mapper.OrderMapper;
import swfinal.sw.repository.OrderRepository;
import swfinal.sw.service.OrderService;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OrderServiceTest {

    @Mock
    private OrderRepository orderRepository;
    @Mock
    private OrderMapper orderMapper;

    @InjectMocks
    private OrderService orderService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetById() {
        Long id = 1L;
        OrderEntity entity = new OrderEntity();
        OrderDto dto = new OrderDto();

        when(orderRepository.findById(id)).thenReturn(Optional.of(entity));
        when(orderMapper.toDto(entity)).thenReturn(dto);

        OrderDto result = orderService.getById(id);

        assertNotNull(result);
        assertEquals(dto, result);
        verify(orderRepository).findById(id);
    }

    @Test
    void testCreateOrder() {
        OrderDto dto = new OrderDto();
        OrderEntity entity = new OrderEntity();

        when(orderMapper.toEntity(dto)).thenReturn(entity);

        orderService.create(dto);

        verify(orderRepository).save(entity);
    }

    @Test
    void testDeleteOrder() {
        orderService.delete(5L);
        verify(orderRepository).deleteById(5L);
    }
}

