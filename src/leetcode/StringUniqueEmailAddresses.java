package leetcode;

import java.util.HashSet;
import java.util.Set;

public class StringUniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> seen = new HashSet<>();
        for (String email : emails) {
          int i = email.indexOf('@');
          String local = email.substring(0, i);
          String domain = email.substring(i);
          if (local.contains("+")) {
            local = local.substring(0, local.indexOf('+'));
          }
          // Note: one should escape the specific character '.',
          // since it is treated as a regex expression.
          local = local.replaceAll("\\.", "");
          seen.add(local + domain);
        }
        return seen.size();
    }
}