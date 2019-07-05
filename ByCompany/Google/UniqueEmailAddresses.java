import java.util.HashSet;

/**
 * https://leetcode.com/problems/unique-email-addresses/.
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        if (emails == null || emails.length == 0) return 0;
        HashSet<String> hs = new HashSet<>();
        String[] a;
        String[] plus;
        String preA, postA, prePlus, postPlus;
        for (String ad : emails) {
            StringBuilder sb = new StringBuilder();
            a = ad.split("@");
            postA = a[1];
            preA = a[0].replaceAll("\\.", "");
            if (preA.contains("+")) {
                prePlus = preA.split("\\+")[0];
                sb.append(prePlus);
            } else {
                sb.append(preA);
            }
            sb.append("@");
            sb.append(postA);
            hs.add(sb.toString());
        }
        return hs.size();
    }
}
