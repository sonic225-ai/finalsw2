package swfinal.sw.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swfinal.sw.dto.RestaurantDto;
import swfinal.sw.service.RestaurantService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/restaurants")
public class RestaurantApi {

    private final RestaurantService restaurantService;

    @GetMapping
    public ResponseEntity<List<RestaurantDto>> getAll() {
        return new ResponseEntity<>(restaurantService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody RestaurantDto restaurantDto) {
        restaurantService.create(restaurantDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody RestaurantDto restaurantDto) {
        restaurantService.update(id, restaurantDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        restaurantService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}