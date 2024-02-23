import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Dish {

    private int number;
    private String name;
    private List<Ingredient> ingredients;
}
