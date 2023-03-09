import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public boolean isHappy(int n) {
        Set<Integer> visited = new HashSet<>();
        int sum = 0;

        while (!visited.contains(n)) {

            visited.add(n);

            while (n > 0) {
                sum += Math.pow((n % 10), 2);
                n = n / 10;
            }
            if (sum == 1) return true;

            n = sum;
            sum = 0;
        }
        return false;
    }
}
