import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Lotto {
    public static void main(String[] args) {
        Random random = new Random(System.nanoTime());
        List<Integer> numbers = new ArrayList<Integer>();
        int num;
        for (int i = 0; i < 6; i++) {
            while (true) {
                num = random.nextInt(45) + 1;
                if (numbers.contains(num)) {
                    continue;
                } else {
                    numbers.add(num);
                    System.out.print(num+" ");
                    break;
                }
            }
        }
        System.out.println("");
    }
}
