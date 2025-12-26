package swfinal.sw.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swfinal.sw.dto.DishDto;
import swfinal.sw.service.DishService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/dishes")
public class DishApi {

    private final DishService dishService;

    @GetMapping
    public ResponseEntity<List<DishDto>> getAll() {
        return new ResponseEntity<>(dishService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody DishDto dishDto) {
        dishService.create(dishDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<DishDto>> searchByPrice(@RequestParam double min, @RequestParam double max) {
        return new ResponseEntity<>(dishService.findByPriceRange(min, max), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        dishService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}