public class LCUtility {
    public static int minOf3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    public static int minOf4(int a, int b, int c, int d) {
        return Math.min(minOf3(a, b, c), d);
    }

    public static int maxOf3(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
}
