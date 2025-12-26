package swfinal.sw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swfinal.sw.dto.OrderDto;
import swfinal.sw.mapper.OrderMapper;
import swfinal.sw.repository.OrderRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;

    public List<OrderDto> getAll() {
        return orderMapper.toDtoList(orderRepository.findAll());
    }

    public void create(OrderDto dto) {
        orderRepository.save(orderMapper.toEntity(dto));
    }

    public OrderDto getById(Long id) {
        return orderMapper.toDto(orderRepository.findById(id).orElse(null));
    }

    public void delete(Long id) {
        orderRepository.deleteById(id);
    }
}