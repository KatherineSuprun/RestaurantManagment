import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Restaurant {

    private Menu menu;
    private Kitchen kitchen;
    private Bar bar;
    private Waiter waiter;

    // Метод для прийому замовлення
    public void takeOrder(int tableNumber, List<Integer> orderedItems) {
        for (int itemNumber : orderedItems) {
            Dish dish = menu.getDishByNumber(itemNumber);
            if (dish != null) {
                if (dish.getName().equals("Кава") || dish.getName().equals("Чай") ||
                        dish.getName().equals("Коктейль")) {
                    bar.prepareDrink(dish.getName(), tableNumber);
                } else {
                    Cook cook = kitchen.getRandomCook();
                    waiter.serveOrder(dish.getName(), tableNumber);
                }
            } else {
                System.out.println("Страва з номером " + itemNumber + " відсутня у меню.");
            }
        }
    }
}