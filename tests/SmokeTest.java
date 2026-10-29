import java.math.BigDecimal;
import java.util.List;
public class SmokeTest {
    private static int count;
    private static void check(boolean condition) { if(!condition) throw new AssertionError("Проверка "+(count+1));count++; }
    public static void main(String[] args) {
        check(Primes.upTo(1).isEmpty());check(Primes.upTo(28).equals(List.of(2,3,5,7,11,13,17,19,23)));
        check(Calculator.calculate(new BigDecimal("12"),"+",new BigDecimal("3")).intValue()==15);
        check(Palindrome.check("А роза упала на лапу Азора"));check(!Palindrome.check("Java"));
        check(Temperature.toFahrenheit(0)==32);check(Temperature.toCelsius(212)==100);
        try { Calculator.calculate(BigDecimal.ONE,"/",BigDecimal.ZERO);throw new AssertionError(); }
        catch(IllegalArgumentException expected) { count++; }
        try { Temperature.toFahrenheit(-274);throw new AssertionError(); }
        catch(IllegalArgumentException expected) { count++; }
        System.out.println("Проверок: "+count+"; ошибок: 0");
    }
}
