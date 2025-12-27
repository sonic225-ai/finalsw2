package swfinal.sw.dto;

import aQute.bnd.annotation.metatype.Meta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DishDto {
    private long id;
    private String name;
    private double price;
    private long restaurantId;
}