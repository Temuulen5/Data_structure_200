import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 5; i++) {
            numbers.add(random.nextInt(100));
        }

        ArrayLinearList arrayLinearList = new ArrayLinearList();

        System.out.println("-------------------------------------------------------------------------");
        System.out.println("numbers : " + numbers);
        System.out.println("max : " + arrayLinearList.max(numbers));
        System.out.println("min : " + arrayLinearList.min(numbers));
        System.out.println("sorted : " + arrayLinearList.sort(numbers));
        System.out.println("sum : " + arrayLinearList.sum(numbers));
        System.out.println("removeOdd : " + arrayLinearList.removeOdd(numbers));
        System.out.println("average : " + arrayLinearList.avg(numbers));
    }
}