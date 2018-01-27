import java.util.Arrays;
import java.util.List;

public class SumOfArrays {
    public static void main(String[] args) {
        int arr[] = new int[]{1,2,3,4,5,6,7,8,9,10};
        int sumOfAllElements = Arrays.stream(arr).sum();
        System.out.println(String.format("Sum of primitive int array elements is %s",sumOfAllElements));

        //Just for understanding mapToInt method, using an Integer object and converting to int
        //Also, .sum(),.average() methods are available only on primitive data types(not object data types)

        List<Integer> integerArrayList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        int sumOfAllElementsOfIntegeArray = integerArrayList.stream().mapToInt(Integer::intValue).sum();

        //Just notice the mapToInt method in the below comment, that's the power of :: operator,
        // no need to pass the entire object, when we are just invoking a single method.

        //int sumOfAllElementsOfIntegeArray = integerArrayList.stream().mapToInt(i->i.intValue()).sum();

        System.out.format("Sum of Object Integer array elements is %s",sumOfAllElementsOfIntegeArray);
    }
}

