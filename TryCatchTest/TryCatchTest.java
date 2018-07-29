import java.util.ArrayList;
import java.util.List;

public class TryCatchTest {
    public static void main(String[] args) {
        methodA();
        System.out.println("Hello Gaurav");
    }

    private static void methodA() {
        try{
            List<String> list = new ArrayList<>();
            System.out.println("In try method");
            list.get(1);
        }
        catch (Exception e) {
            System.out.println("Inside catch method");
            throw e;
        }
        finally {
            System.out.println("In finally method");
        }
    }
}
//Takeaways:
//Order of execution is
//1) In case of exception try->catch->finally
//2) In case of NO exception try -> finally
// When you have finally, catch block is not necessary.

