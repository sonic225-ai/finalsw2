package swfinal.sw.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swfinal.sw.dto.RestaurantDto;
import swfinal.sw.entity.RestaurantEntity;
import swfinal.sw.mapper.RestaurantMapper;
import swfinal.sw.repository.RestaurantRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;
    private final RestaurantMapper restaurantMapper;

    public List<RestaurantDto> getAll() {
        return restaurantMapper.toDtoList(restaurantRepository.findAll());
    }

    public void create(RestaurantDto dto) {
        RestaurantEntity entity = restaurantMapper.toEntity(dto);
        restaurantRepository.save(entity);
    }

    public void update(Long id, RestaurantDto dto) {
        RestaurantEntity entity = restaurantRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Restaurant not found"));
        entity.setName(dto.getName());
        entity.setAddress(dto.getAddress());
        restaurantRepository.save(entity);
    }

    public void delete(Long id) {
        restaurantRepository.deleteById(id);
    }
}