package cnlyon.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class lc13_RomanToInteger {

  public int romanToInt(String s) {
    LinkedHashMap<String, Integer> hashMap = buildRomanHashMap();
    int arabicNum = 0;
    StringBuilder sb = new StringBuilder(s);
    for (Map.Entry<String, Integer> entry : hashMap.entrySet()) {
      String roman = entry.getKey();
      while (sb.toString().startsWith(roman)) {
        arabicNum += entry.getValue();
        sb.delete(0, roman.length());
      }
      if (sb.isEmpty()) {
        break;
      }
    }
    return arabicNum;
  }

  private LinkedHashMap<String, Integer> buildRomanHashMap() {
    LinkedHashMap<String, Integer> hashMap = new LinkedHashMap<>();
    hashMap.put("M", 1000);
    hashMap.put("CM", 900);
    hashMap.put("D", 500);
    hashMap.put("CD", 400);
    hashMap.put("C", 100);
    hashMap.put("XC", 90);
    hashMap.put("L", 50);
    hashMap.put("XL", 40);
    hashMap.put("X", 10);
    hashMap.put("IX", 9);
    hashMap.put("V", 5);
    hashMap.put("IV", 4);
    hashMap.put("I", 1);
    return hashMap;
  }
}
