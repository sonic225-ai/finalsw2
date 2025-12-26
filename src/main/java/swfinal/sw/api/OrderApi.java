package swfinal.sw.api;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import swfinal.sw.dto.OrderDto;
import swfinal.sw.service.OrderService;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderApi {

    private final OrderService orderService;

    @GetMapping
    public ResponseEntity<List<OrderDto>> getAllOrders() {
        return new ResponseEntity<>(orderService.getAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Void> createOrder(@RequestBody OrderDto orderDto) {
        orderService.create(orderDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderDto> getOrderById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(orderService.getById(id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable("id") Long id) {
        orderService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}