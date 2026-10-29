import java.util.Locale;
public final class Palindrome {
    public static boolean check(String value) {
        if (value==null || value.isBlank()) throw new IllegalArgumentException("Строка пуста");
        String text=value.replaceAll("[^\\p{L}\\p{N}]", "").toLowerCase(Locale.ROOT);
        if (text.isEmpty()) throw new IllegalArgumentException("Нет букв или цифр");
        return text.contentEquals(new StringBuilder(text).reverse());
    }
}
