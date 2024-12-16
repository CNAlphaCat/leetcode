package cnlyon.leetcode.problems;

import java.util.HashMap;

public class lc28_FindTheIndexOfTheFirstOccurrenceInAString {
  public int strStr(String haystack, String needle) {
    if (needle.length() > haystack.length()) {
      return -1;
    }
    int i = 0;
    HashMap<Character, Integer> characterIntegerHashMap = buildSundayOffSetMap(needle);
    while (i < haystack.length()) {
      if (isMatch(haystack, i, needle)) {
        return i;
      }
      if (i + needle.length() >= haystack.length()) {
        break;
      }
      char letter = haystack.charAt(i + needle.length());
      i += characterIntegerHashMap.getOrDefault(letter, needle.length() + 1);
    }
    return -1;
  }

  private HashMap<Character, Integer> buildSundayOffSetMap(String needle) {
    HashMap<Character, Integer> sundayOffSetMap = new HashMap<>();
    for (int i = needle.length() - 1; i >= 0; i--) {
      char letter = needle.charAt(i);
      int offset = needle.length() - i;
      sundayOffSetMap.putIfAbsent(letter, offset);
    }
    return sundayOffSetMap;
  }

  private boolean isMatch(String haystack, int index, String needle) {
    if (index + needle.length() > haystack.length()) {
      return false;
    }
    for (int i = 0; i < needle.length(); i++) {
      if (haystack.charAt(index + i) != needle.charAt(i)) {
        return false;
      }
    }
    return true;
  }
}
