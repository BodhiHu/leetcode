import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution2 {
  public static String[] restorePossibleIPs(String input) {
    System.out.println("input = " + input);

    List<String> ips = new ArrayList<>();

    search(ips, input, new ArrayList<String>());

    return ips.toArray(new String[0]);
  }

  static void search(List<String> ips, String remaining, List<String> segments) {
    if (remaining == null || remaining.length() == 0) {
      return;
    }

    if ((segments.size() == 4 && remaining.length() > 0)
    || (remaining.length() > ((4 - segments.size()) * 3))
    || (remaining.length() < ((4 - segments.size()) * 1))
    ) {
      return;
    }

    if (segments.size() == 3) {
      if (remaining.length() > 1 && remaining.startsWith("0")) {
        return;
      }
      if (Integer.parseInt(remaining) > 255) {
        return;
      }
      segments.add(remaining);
      ips.add(String.join(".", segments));
      return;
    }

    for (int segLen = 1; segLen <= 3; segLen++) {
      if (remaining.length() < segLen) {
        continue;
      }

      String s = remaining.substring(0, segLen);
      if (segLen > 1 && s.startsWith("0")) {
        continue;
      }
      if (segLen == 3 && Integer.parseInt(s) > 255) {
        continue;
      }

      segments = new ArrayList<>(segments);
      segments.add(s);
      search(ips, remaining.substring(segLen), segments);
    }
  }

  static String ipsToString(String[] ips) {
    return String.join(",", ips);
  }

  public static void main(String[] args) {
    System.out.println("ret = " + ipsToString(restorePossibleIPs(args[0])) + "\n");
    System.out.println("ret = " + ipsToString(restorePossibleIPs("25525511135")) + "\n");
    System.out.println("ret = " + ipsToString(restorePossibleIPs("0000")) + "\n");
    System.out.println("ret = " + ipsToString(restorePossibleIPs("10203040")) + "\n");
    System.out.println("ret = " + ipsToString(restorePossibleIPs("010010")) + "\n");
  }
}
