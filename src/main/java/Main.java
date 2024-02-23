import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Ingredient tomato = new Ingredient("Помідор");
        Ingredient cheese = new Ingredient("Сир");
        Ingredient dough = new Ingredient("Тісто");

        Dish pizza = new Dish(1, "Піца", Arrays.asList(tomato, cheese, dough));

        Cook cook1 = new Cook("Іван");
        Cook cook2 = new Cook("Петро");
        List<Cook> chefs = new ArrayList<>(Arrays.asList(cook1, cook2));
        Kitchen kitchen = new Kitchen(chefs);

        Bar bar = new Bar();

        Waiter waiter = new Waiter();

        Menu menu = new Menu();
        menu.addDish(1, pizza);
        menu.addDish(2, new Dish(2, "Кава", null));
        menu.addDish(3, new Dish(3, "Чай", null));
        menu.addDish(4, new Dish(4, "Коктейль", null));

        Restaurant restaurant = new Restaurant(menu, kitchen, bar, waiter);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Вас вітає ресторан Supra! Виберіть дію:");
        System.out.println("1. Подивитись меню");
        System.out.println("2. Замовити");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                restaurant.getMenu().displayMenu();
                break;
            case 2:
                System.out.println("Введіть номер столика:");
                int tableNumber = scanner.nextInt();
                System.out.println("Введіть номер блюда (для завершення введіть -1):");
                List<Integer> orderedItems = new ArrayList<>();
                int itemNumber = scanner.nextInt();
                while (itemNumber != -1) {
                    orderedItems.add(itemNumber);
                    System.out.println("Введіть наступний номер блюда (для завершення введіть -1):");
                    itemNumber = scanner.nextInt();
                }
                restaurant.takeOrder(tableNumber, orderedItems);
                break;
            default:
                System.out.println("Невірний вибір");
        }

    }
}
