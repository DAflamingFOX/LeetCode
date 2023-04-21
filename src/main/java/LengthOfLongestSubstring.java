import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int highest = 0;
        int s0 = 0;
        int s1 = 1;

        while (s1 <= s.length()) {
            String sub = s.substring(s0, s1);
            if (containsDupeChar(sub)) {
                s0++;
                s1++;
                continue;
            } else {
                highest = sub.length();
                s1++;
            }
        }

        return highest;
    }

    public boolean containsDupeChar(String s) {
        List<Character> chars = new ArrayList<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (chars.contains(c))
                return true;
            else
                chars.add(c);
        }

        return false;
    }
}
