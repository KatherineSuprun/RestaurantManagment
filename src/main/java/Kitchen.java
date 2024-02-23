import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
@AllArgsConstructor
public class Kitchen {

    private List<Cook> cooks;

    public void addCook(Cook cook) {
        cooks.add(cook);
    }
    public Cook getRandomCook() {
        return cooks.get(new Random().nextInt(cooks.size()));
    }
}

