public final class Temperature {
    private static void finite(double value) {
        if (!Double.isFinite(value)) throw new IllegalArgumentException("Нужно конечное число");
    }
    public static double toFahrenheit(double c) { finite(c); return c*9/5+32; }
    public static double toCelsius(double f) { finite(f); return (f-32)*5/9; }
}
