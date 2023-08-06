package level01;

import java.util.Arrays;

/**
 * 문자열 내림차순으로 배치하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12917
 */
public class StringDescSort12917 {

    /*
    입출력 예
    s	return
    "Zbcdefg"	"gfedcbZ"
     */
    public static void main(String[] args) {
        String s = "Zbcdefg";
        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        char[] sArr = s.toCharArray();
        Arrays.sort(sArr);
        return new StringBuilder().append(sArr).reverse().toString();
    }
}
