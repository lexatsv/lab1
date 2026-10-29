import java.util.ArrayList;
import java.util.List;
public final class Primes {
    public static List<Integer> upTo(int n) {
        if (n < 2) return List.of();
        if (n > 1000000) throw new IllegalArgumentException("N не больше 1000000");
        boolean[] composite = new boolean[n+1];
        for (int i=2; i<=n/i; i++) if (!composite[i])
            for (int j=i*i; j<=n; j+=i) composite[j]=true;
        var result=new ArrayList<Integer>();
        for (int i=2;i<=n;i++) if (!composite[i]) result.add(i);
        return List.copyOf(result);
    }
}
