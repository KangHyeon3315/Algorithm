package level01;

import java.util.Arrays;

/**
 * 문자열 내 마음대로 정렬하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12915
 */
public class StringSort12915 {

    /*
    입출력 예
    strings	n	return
    ["sun", "bed", "car"]	1	["car", "bed", "sun"]
    ["abce", "abcd", "cdx"]	2	["abcd", "abce", "cdx"]
     */
    public static void main(String[] args) {
        String[] strings = {"sun", "bed", "car"};
        int n = 1;
        String[] result = solution(strings, n);
        System.out.println(Arrays.toString(result));

        strings = new String[]{"abce", "abcd", "cdx"};
        n = 2;
        result = solution(strings, n);
        System.out.println(Arrays.toString(result));
    }

    public static String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (o1, o2) -> {
            if(o1.charAt(n) != o2.charAt(n))
                return o1.charAt(n) - o2.charAt(n);

            return o1.compareTo(o2);
        });

        return strings;
    }
}
