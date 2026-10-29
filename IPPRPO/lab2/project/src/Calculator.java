import java.math.BigDecimal;
import java.math.RoundingMode;
public final class Calculator {
    public static String title() { return "Калькулятор двух чисел"; }
    public static BigDecimal calculate(BigDecimal a,String operation,BigDecimal b) {
        return switch(operation) {
            case "+" -> a.add(b);
            case "-" -> a.subtract(b);
            case "*" -> a.multiply(b);
            case "/" -> {
                if (b.signum()==0) throw new IllegalArgumentException("Деление на ноль");
                yield a.divide(b,6,RoundingMode.HALF_UP).stripTrailingZeros();
            }
            default -> throw new IllegalArgumentException("Неизвестная операция");
        };
    }
}
