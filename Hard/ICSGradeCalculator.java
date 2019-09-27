public class ICSGradeCalculator {

    public static void main(String[] args) {
        double total = 0;

        /* Homework assignments */
        total += 5; // AIV and Cord Lab

        total += 7; // Data Lab

        total += 6; // Bomb Lab

        total += 0.95 * 4; // Attack Lab

        total += 0.951 * 5; // Cache Lab

        total += 0.996 * 4; // Malloc Checkpoint

        total += 0.876 * 8; // Malloc Final

        total += 0.90 * 8;  // Shell

        total += 2; // Proxy Checkpoint

        total += 0.932 * 6; // Proxy Final

        /* Exams */
        total += 0.1 * 84.4; // Midterm

        total += 0.35 * 85.4; // Final

        System.out.println(total);
    }
}
