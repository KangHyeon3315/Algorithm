package level01;

import java.util.HashMap;

/**
 * 숫자 짝꿍
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131128
 */
public class PairNumber131128 {

    public static void main(String[] args) {
        String X = "100";
        String Y = "2345";
        String result = solution(X, Y);
        System.out.println("Case 1 : " + result);

        X = "100";
        Y = "203045";
        result = solution(X, Y);
        System.out.println("Case 2 : " + result);

        X = "100";
        Y = "123450";
        result = solution(X, Y);
        System.out.println("Case 3 : " + result);

        X = "12321";
        Y = "42531";
        result = solution(X, Y);
        System.out.println("Case 4 : " + result);

        X = "5525";
        Y = "1255";
        result = solution(X, Y);
        System.out.println("Case 5 : " + result);
    }

    public static String solution(String X, String Y) {
        HashMap<Character, Integer> xFreqMap = new HashMap<>();
        HashMap<Character, Integer> yFreqMap = new HashMap<>();

        for(char ch : X.toCharArray()) {
            xFreqMap.put(ch, xFreqMap.getOrDefault(ch, 0) + 1);
        }

        for(char ch : Y.toCharArray()) {
            yFreqMap.put(ch, yFreqMap.getOrDefault(ch, 0) + 1);
        }

        StringBuilder answer = new StringBuilder();
        for(char ch = '9'; ch >= '0'; ch--) {
            int xCount = xFreqMap.getOrDefault(ch, 0);
            int yCount = yFreqMap.getOrDefault(ch, 0);
            int minCount = Math.min(xCount, yCount);

            if(minCount > 0) {
                for(int i = 0 ; i < minCount; i++) {
                    answer.append(ch);
                }
            }
        }

        if(answer.length() == 0) return "-1";
        if(answer.charAt(0) == '0') return "0";

        return answer.toString();
    }
}
