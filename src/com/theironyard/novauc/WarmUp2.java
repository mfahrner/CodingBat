package com.theironyard.novauc;

/**
 * Created by mfahrner on 3/18/17.
 */
public class WarmUp2 {

/*
Given a string and a non-negative int n, return a larger string that is n copies of the original string.

stringTimes("Hi", 2) → "HiHi"
stringTimes("Hi", 3) → "HiHiHi"
stringTimes("Hi", 1) → "Hi"
 */

    public String stringTimes(String str, int n) {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < n; i ++) {
            s.append(str);
        }
        return s.toString();
    }

    /*
    Given an array of ints, return the number of 9's in the array.

arrayCount9([1, 2, 9]) → 1
arrayCount9([1, 9, 9]) → 2
arrayCount9([1, 9, 9, 3, 9]) → 3
     */

    public int arrayCount9(int[] nums) {
        int count = 0;
        for (int number : nums) {
            if (number == 9) {
                count++;
            }
        }
        return count;
    }

    /*
    Given a string and a non-negative int n, we'll say that the front of the string is the first 3 chars, or whatever is there if the string is less than length 3. Return n copies of the front;

    frontTimes("Chocolate", 2) → "ChoCho"
    frontTimes("Chocolate", 3) → "ChoChoCho"
    frontTimes("Abc", 3) → "AbcAbcAbc"

    */

    public String frontTimes(String str, int n) {
        StringBuilder result = new StringBuilder();
        String front = "";
        if (str.length() > 3) {
            front = str.substring(0, 3);
        } else {
            front = str;
        }
        for (int i = 0; i < n; i++) {
            result.append(front);
        }
        return result.toString();
    }

/*
Given an array of ints, return true if one of the first 4 elements in the array is a 9. The array length may be less than 4.

arrayFront9([1, 2, 9, 3, 4]) → true
arrayFront9([1, 2, 3, 4, 9]) → false
arrayFront9([1, 2, 3, 4, 5]) → false
 */

    public boolean arrayFront9(int[] nums) {
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (i < 4 && nums[i] == 9) {
                result = true;
            }
        }
        return result;
    }

    /*
    Given an array of ints, return true if the sequence of numbers 1, 2, 3 appears in the array somewhere.

array123([1, 1, 2, 3, 1]) → true
array123([1, 1, 2, 4, 1]) → false
array123([1, 1, 2, 1, 2, 3]) → true
     */

    // SO MUCH EASIER!
    /*
    for (int i=0; i < (nums.length-2); i++) {
    if (nums[i]==1 && nums[i+1]==2 && nums[i+2]==3) return true;
  }
  return false;
     */
    public boolean array123(int[] nums) {
        int iterator = 1;
        boolean result = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == iterator) {
                if (i +1 <= (nums.length - 1) && nums[i +1] == iterator + 1) {
                    if (i + 2 <= (nums.length -1) && nums[i + 2] == iterator + 2) {
                        result = true;
                        return result;
                    }
                }
            }
        }
        return result;
    }

    /*
    Given an array of ints, return true if it contains a 2, 7, 1 pattern -- a value, followed by the value plus 5, followed by the value minus 1. Additionally the 271 counts even if the "1" differs by 2 or less from the correct value.

    has271([1, 2, 7, 1]) → true
    has271([1, 2, 8, 1]) → false
    has271([2, 7, 1]) → true
    */

    /*
    if (nums[i+1] == (val + 5) &&
      Math.abs(nums[i+2] - (val-1)) <= 2)  return true;
     */

    public boolean has271(int[] nums) {
        boolean result = false;
        for (int i = 0; i < nums.length - 2; i++){
            if ((nums[i] == nums[i + 1] - 5) && ((nums[i] + 1) >= (nums[i + 2]) && ((nums[i] - 3) <= (nums[i + 2])))){
                //2 == 2 &&
                result = true;
            }
        }
        return result;
    }

    /*
    Given a string, return a new string made of every other char starting with the first, so "Hello" yields "Hlo".

stringBits("Hello") → "Hlo"
stringBits("Hi") → "H"
stringBits("Heeololeo") → "Hello"
     */

    public String stringBits(String str) {
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < charArr.length; i = i + 2) {
            sb.append(charArr[i]);
        }
        return sb.toString();
    }

    /*
    Given a string, return the count of the number of times that a substring length 2 appears in the string and also as
    the last 2 chars of the string, so "hixxxhi" yields 1 (we won't count the end substring).

last2("hixxhi") → 1
last2("xaxxaxaxx") → 1
last2("axxxaaxx") → 2
     */

    public int last2(String str) {
        int count = 0;
           if  (str.length() <= 2)  {
               return count;
           }

        char last = str.charAt(str.length() - 1);
        char first = str.charAt(str.length() - 2);

        for (int i = 0; i < str.length() - 1; i++) {
            if ((str.charAt(i) == first) && (str.charAt(i + 1) == last)) {
                count++;
            }
        }
        return count - 1;
    }

    /*
    Count the number of "xx" in the given string. We'll say that overlapping is allowed, so "xxx" contains 2 "xx".

countXX("abcxx") → 1
countXX("xxx") → 2
countXX("xxxx") → 3
     */

    int countXX(String str) {
        int count = 0;
        for (int i = 0; i < str.length() - 1; i++) {
            //     if (str.substring(i, i+2).equals("xx")) count++;
            if (str.charAt(i) == 'x' && str.charAt(i + 1) == 'x') {
                count++;
            }
        }
        return count;
    }

    /*
    Given an array of ints, return the number of times that two 6's are next to each other in the array.
    Also count instances where the second "6" is actually a 7.

array667([6, 6, 2]) → 1
array667([6, 6, 2, 6]) → 1
array667([6, 7, 2, 6]) → 1
     */

    public int array667(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if ((nums[i] == 6) && ((nums[i + 1] == 6) || (nums[i + 1] == 7))) {
                count++;
            }
        }
        return count;
    }

    /*
    Given a non-empty string like "Code" return a string like "CCoCodCode".

stringSplosion("Code") → "CCoCodCode"
stringSplosion("abc") → "aababc"
stringSplosion("ab") → "aab"
     */

//abc
    // a
    // ab
    // abc
    public String stringSplosion(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.substring(0, (i + 1)));
        }
        return sb.toString();
    }

/*
    Given a string, return true if the first instance of "x" in the string is immediately followed by another "x".

    doubleX("axxbb") → true
    doubleX("axaxax") → false
    doubleX("xxxxx") → true

    */

/*
int i = str.indexOf("x");
  if (i == -1) return false; // no "x" at all

  // Is char at i+1 also an "x"?
  if (i+1 >= str.length()) return false; // check i+1 in bounds?
  return str.substring(i+1, i+2).equals("x");

  // Another approach -- .startsWith() simplifies the logic
  // String x = str.substring(i);
  // return x.startsWith("xx");
 */

    boolean doubleX(String str) {
        int firstInstance = str.indexOf('x');
        if (firstInstance != -1) {
            for (int i = 0; i < str.length() - 1; i++) {
                if (firstInstance != str.length() -1) {
                    if (str.charAt(firstInstance + 1) == 'x') {
                        return true;
                    }
                }
            }
        }
        return false;
    }
/*
    Given a string, return a version where all the "x" have been removed.
    Except an "x" at the very start or end should not be removed.

    stringX("xxHxix") → "xHix"
    stringX("abxxxcd") → "abcd"
    stringX("xabxxxcdx") → "xabcdx"
    */

    public String stringX(String str) {

        if (str.length() <= 2) {
            return str;
        }
        if (str.charAt(0) == 'x' || str.charAt(str.length() - 1) == 'x') {
            String replacedNoFistOrLast = str.substring(1, str.length() - 1).replaceAll("x", "");
            return "x" + replacedNoFistOrLast + "x";
        } else {
            return str.replaceAll("x", "");
        }

    }


    /*
    Given a string, return a string made of the chars at indexes 0,1, 4,5, 8,9 ... so "kittens" yields "kien".

    altPairs("kitten") → "kien"
    altPairs("Chocolate") → "Chole"
    altPairs("CodingHorror") → "Congrr"
     */

    // substring 0, 1
    // substring 4, 5
    // substring 8, 9

    // TODO: 3/29/17 Finish this still running into the indexoutofbound

    public String altPairs(String str) {
        StringBuilder sb = new StringBuilder();
        if (str.length() <= 2 ) {
            return str;
        }
        for (int i = 0; i <= str.length() - 2; i = i + 4) {
            sb.append(str.substring(i, i + 2));
        }
        return sb.toString();
    }


    /*
    Given an array of ints, we'll say that a triple is a value appearing 3 times in a row in the array.
    Return true if the array does not contain any triples.

noTriples([1, 1, 2, 2, 1]) → true
noTriples([1, 1, 2, 2, 2, 1]) → false
noTriples([1, 1, 1, 2, 2, 2, 1]) → false
     */

    public boolean noTriples(int[] nums) {
        boolean result = true;
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == nums[i + 1] && nums[i] == nums[i + 2]) {
                result = false;
            }
        }
        return result;
    }

/*
Suppose the string "yak" is unlucky. Given a string, return a version where all the "yak" are removed, but the "a" can be any char.
 The "yak" strings will not overlap.

stringYak("yakpak") → "pak"
stringYak("pakyak") → "pak"
stringYak("yak123ya") → "123ya"
 */

    public String stringYak(String str) {
        if (str.length() <= 2) {
            return str;
        }
        String newString = "";
        for (int i = 0; i < str.length() - 2; i++) {
            if (str.charAt(i) == 'y' && str.charAt(i + 2) == 'k') {
                newString = str.replace(str.substring(i, i + 3), "");
            }
        }
        return newString;
    }

    /*
    Given 2 strings, a and b, return the number of the positions where they contain the same length 2 substring.
    So "xxcaazz" and "xxbaaz" yields 3, since the "xx", "aa", and "az" substrings appear in the same place in both strings.

stringMatch("xxcaazz", "xxbaaz") → 3
stringMatch("abc", "abc") → 2
stringMatch("abc", "axc") → 0
     */

    /*
    public int stringMatch(String a, String b) {
  // Figure which string is shorter.
  int len = Math.min(a.length(), b.length());
  int count = 0;

  // Look at both substrings starting at i
  for (int i=0; i<len-1; i++) {
    String aSub = a.substring(i, i+2);
    String bSub = b.substring(i, i+2);
    if (aSub.equals(bSub)) {  // Use .equals() with strings
      count++;
    }
  }

  return count;
}
     */

    public int stringMatch(String a, String b) {
        int count = 0;
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length() - 1; i++) {
                if (b.substring(i, i + 2).equals(a.substring(i, i + 2))) {
                    count++;
                }
            }
        } else {
            for (int i = 0; i < a.length() - 1; i++) {
                if (a.substring(i, i + 2).equals(b.substring(i, i + 2))) {
                    count++;
                }
            }
        }
        return count;
    }




















}
