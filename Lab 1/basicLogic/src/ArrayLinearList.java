import java.util.ArrayList;
import java.util.List;

public class ArrayLinearList {

    public ArrayLinearList() {
    }

    protected int max(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            int max = Integer.MIN_VALUE;
            for (Integer number : numbers) {
                if (number > max) {
                    max = number;
                }
            }
            return max;
        }
        return 0;
    }

    protected int min(List<Integer> numbers) {
        if (!numbers.isEmpty()) {
            int min = Integer.MAX_VALUE;
            for (Integer number : numbers) {
                if (number < min) {
                    min = number;
                }
            }
            return min;
        }
        return 0;
    }

    protected int sum(List<Integer> numbers) {
        int sum = 0;
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }

    protected double avg(List<Integer> numbers) {
        if (!numbers.isEmpty())
            return (double) sum(numbers) / numbers.size();
        return 0;
    }

    protected List<Integer> removeOdd(List<Integer> numbers) {
        List<Integer> evenOnly = new ArrayList<>();
        for (Integer number : numbers) {
            if (number % 2 == 0) {
                evenOnly.add(number);
            }
        }
        return evenOnly;
    }

    protected List<Integer> sort(List<Integer> numbers) {
        List<Integer> copy = new ArrayList<>(numbers);
        List<Integer> sorted = new ArrayList<>();
        int size = copy.size();
        for (int i = 0; i < size; i++) {
            int min = min(copy);
            sorted.add(min);
            copy.remove(Integer.valueOf(min));
        }
        return sorted;
    }
}
