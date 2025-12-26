package swfinal.sw.service;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import swfinal.sw.dto.DishDto;
import swfinal.sw.mapper.DishMapper;
import swfinal.sw.repository.DishRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {

    private final DishRepository dishRepository;
    private final DishMapper dishMapper;

    public List<DishDto> getAll() {
        return dishMapper.toDtoList(dishRepository.findAll());
    }

    public void create(DishDto dto) {
        dishRepository.save(dishMapper.toEntity(dto));
    }

    public List<DishDto> findByPriceRange(double min, double max) {
        return dishMapper.toDtoList(dishRepository.findAll().stream()
                .filter(d -> d.getPrice() >= min && d.getPrice() <= max)
                .toList());
    }

    public void delete(Long id) {
        dishRepository.deleteById(id);
    }
}