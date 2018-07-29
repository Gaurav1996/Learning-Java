public class ClassTypes {
    public static void main(String[] args) {
        System.out.println("Func:"+func(true).getClass());
        System.out.println("Func:"+func(false).getClass());
        System.out.println("Func2:"+func2(true).getClass());
        System.out.println("Func2:"+func2(false).getClass());
        System.out.println("Func3:"+func3(true).getClass());
        System.out.println("Func3:"+func3(false).getClass());
    }

    private static Object func3(boolean b) {
        return b?(Object)Double.valueOf(1.0):(Object)Integer.valueOf(2);
    }

    private static Object func2(boolean b) {
        if(b) {
            return Double.valueOf(1.0);
        }
        else {
            return Integer.valueOf(2);
        }
    }

    private static Object func(boolean b) {
        return b?Double.valueOf(1.0):Integer.valueOf(2); //Numeric promotion?
    }
}
/*
Takeaways:

According to Java Language Specification Section 15.25,
the conditional operator will implement numeric type promotion if there are two different types as 2nd and 3rd operand.

The rules of conversion are defined at Binary Numeric Promotion.
Therefore, according to the rules given, If either operand is of type double, the other is converted to double
 */