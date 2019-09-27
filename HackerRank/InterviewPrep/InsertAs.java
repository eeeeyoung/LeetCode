public class InsertAs {

    private static final String DoubleA = "aa";
    private static final String SingleA = "a";
    // There is a better way: Pick all non-As and stick DoubleA in between them
    public static void main(String[] args) {
        System.out.println(insertA("adggag"));
        System.out.println(insertA("aagdaa"));
        System.out.println(insertA("aagadada"));
    }

    private static String insertA(String input) {
        char[] charArray = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        if (charArray[0] != 'a') {
            sb.append(DoubleA);
        } else if (1 < charArray.length && charArray[1] != 'a') {
            sb.append(SingleA);
        }
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a') {
                sb.append(SingleA);
            } else {
                // charArray[i] != 'a'
                if (i + 2 < charArray.length) {
                    if (charArray[i + 1] == 'a' && charArray[i + 2] != 'a') {
                        sb.append(charArray[i]);
                        sb.append(SingleA);
                    } else if (charArray[i + 1] != 'a') {
                        sb.append(charArray[i]);
                        sb.append(DoubleA);
                    } else if (charArray[i + 1] == 'a' && charArray[i + 2] == 'a') {
                        sb.append(charArray[i]);
                    }
                } else if (i + 1 < charArray.length) {
                    if (charArray[i + 1] == 'a') {
                        sb.append(charArray[i]);
                        sb.append(SingleA);
                    } else {
                        sb.append(charArray[i]);
                        sb.append(DoubleA);
                    }
                } else {
                    // the last position
                    sb.append(charArray[i]);
                    sb.append(DoubleA);
                }
            }
        }
        return sb.toString();
    }
}
