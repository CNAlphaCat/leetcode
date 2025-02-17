package cnlyon.leetcode.problems;

import cnlyon.leetcode.annotations.Microsoft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Microsoft
public class LC17_LetterCombinationsOfAPhoneNumber {
  private static final Map<Character, List<String>> PHONE_NUM_TO_CHAR_MAP = getPhoneNumToCharMap();

  public List<String> letterCombinations(String digits) {
    if(digits.isEmpty()){
      return new ArrayList<>();
    }
    List<String> letterCombinations = new ArrayList<>();
    letterCombinations(letterCombinations, digits, new StringBuilder(), 0);
    return letterCombinations;
  }

  private void letterCombinations(
          List<String> letterCombinations, String digits, StringBuilder combinationString, int index) {
    if (index == digits.length()) {
      letterCombinations.add(combinationString.toString());
      return;
    }
    Character num = digits.charAt(index);
    List<String> letterList = PHONE_NUM_TO_CHAR_MAP.get(num);
    for (String letter : letterList) {
      combinationString.append(letter);
      letterCombinations(letterCombinations, digits, combinationString, index + 1);
      combinationString.deleteCharAt(index);
    }
  }

  private static Map<Character, List<String>> getPhoneNumToCharMap() {
    Map<Character, List<String>> phoneNumToCharMap = new HashMap<>();
    List<String> numTwoList = new ArrayList<>();
    numTwoList.add("a");
    numTwoList.add("b");
    numTwoList.add("c");
    phoneNumToCharMap.put('2', numTwoList);

    List<String> numThreeList = new ArrayList<>();
    numThreeList.add("d");
    numThreeList.add("e");
    numThreeList.add("f");
    phoneNumToCharMap.put('3', numThreeList);

    List<String> numFourList = new ArrayList<>();
    numFourList.add("g");
    numFourList.add("h");
    numFourList.add("i");
    phoneNumToCharMap.put('4', numFourList);

    List<String> numFiveList = new ArrayList<>();
    numFiveList.add("j");
    numFiveList.add("k");
    numFiveList.add("l");
    phoneNumToCharMap.put('5', numFiveList);

    List<String> numSixList = new ArrayList<>();
    numSixList.add("m");
    numSixList.add("n");
    numSixList.add("o");
    phoneNumToCharMap.put('6', numSixList);

    List<String> numSevenList = new ArrayList<>();
    numSevenList.add("p");
    numSevenList.add("q");
    numSevenList.add("r");
    numSevenList.add("s");
    phoneNumToCharMap.put('7', numSevenList);

    List<String> numEightList = new ArrayList<>();
    numEightList.add("t");
    numEightList.add("u");
    numEightList.add("v");
    phoneNumToCharMap.put('8', numEightList);

    List<String> numNineList = new ArrayList<>();
    numNineList.add("w");
    numNineList.add("x");
    numNineList.add("y");
    numNineList.add("z");
    phoneNumToCharMap.put('9', numNineList);

    return phoneNumToCharMap;
  }
}
