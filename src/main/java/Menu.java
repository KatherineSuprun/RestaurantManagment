import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Menu {

    private Map<Integer, Dish> dishes;

    public Menu() {
        dishes = new HashMap<>();
    }

    public void addDish(int number, Dish dish) {
        dishes.put(number, dish);
    }

    public Dish getDishByNumber(int number) {
        return dishes.get(number);
    }

    public void displayMenu() {
        System.out.println("Меню ресторану:");
        for (Map.Entry<Integer, Dish> entry : dishes.entrySet()) {
            System.out.println(entry.getKey() + ". " + entry.getValue().getName());
        }
    }
}


