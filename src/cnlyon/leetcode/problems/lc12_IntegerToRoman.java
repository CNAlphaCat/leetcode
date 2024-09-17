package cnlyon.leetcode.problems;

import java.util.LinkedHashMap;
import java.util.Map;

public class lc12_IntegerToRoman {

  public String intToRoman(int num) {
    LinkedHashMap<Integer, String> hashMap = buildRomanHashMap();
    StringBuilder sb = new StringBuilder();
    for (Map.Entry<Integer, String> entry : hashMap.entrySet()) {
      Integer arabicNum = entry.getKey();
      while (num - arabicNum >= 0) {
        sb.append(entry.getValue());
        num -= arabicNum;
      }
      if (num == 0) {
        break;
      }
    }
    return sb.toString();
  }

  private LinkedHashMap<Integer, String> buildRomanHashMap() {
    LinkedHashMap<Integer, String> hashMap = new LinkedHashMap<>();
    hashMap.put(1000, "M");
    hashMap.put(900, "CM");
    hashMap.put(500, "D");
    hashMap.put(400, "CD");
    hashMap.put(100, "C");
    hashMap.put(90, "XC");
    hashMap.put(50, "L");
    hashMap.put(40, "XL");
    hashMap.put(10, "X");
    hashMap.put(9, "IX");
    hashMap.put(5, "V");
    hashMap.put(4, "IV");
    hashMap.put(1, "I");
    return hashMap;
  }
}
