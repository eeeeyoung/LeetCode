public class johnGambles {
    public static void main(String[] args) {
        System.out.println(getResult(8, 0));
        System.out.println(getResult(18, 2));
        System.out.println(getResult(10, 10));
    }
    // times of John all-ins <= K
    private static Integer getResult(Integer N, Integer K) {
        int rounds = 0;
        while (N > 1) {
            if ((N & 1) == 0 && K > 0) {
                N /= 2;
                K--;
            } else {
                N--;
            }
            rounds++;
        }
        return rounds;
    }
}
