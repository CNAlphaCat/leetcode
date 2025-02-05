package cnlyon.leetcode.problems;

import java.util.*;

public class lc49_GroupAnagrams {
  public List<List<String>> groupAnagrams(String[] strs) {
    HashMap<String, List<String>> anagramsMap = new HashMap<>();
    for (String str : strs) {
      String sortedStr = sortString(str);
      List<String> anagramList = anagramsMap.getOrDefault(sortedStr, new ArrayList<>());
      anagramList.add(str);
      anagramsMap.put(sortedStr, anagramList);
    }
    return new ArrayList<>(anagramsMap.values());
  }

  private String sortString(String str) {
    char[] chars = str.toCharArray();
    Arrays.sort(chars);
    return new String(chars);
  }
}
