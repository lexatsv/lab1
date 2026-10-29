public final class Temperature {
    private static void finite(double value) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Нужно конечное число");
    }
    public static double toFahrenheit(double c) { finite(c); if (c < -273.15) throw new IllegalArgumentException("Ниже абсолютного нуля"); return c*9/5+32; }
    public static double toCelsius(double f) { finite(f); if (f < -459.67) throw new IllegalArgumentException("Ниже абсолютного нуля"); return (f-32)*5/9; }
}
