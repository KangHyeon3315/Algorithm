package level01;

import java.util.List;

/**
 * 숫자 문자열과 영단어
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/81301
 */
public class NumericStringEnglishWord81301 {

    /*
    입출력 예
    s	result
    "one4seveneight"	1478
    "23four5six7"	234567
    "2three45sixseven"	234567
    "123"	123
     */
    public static void main(String[] args) {
        String s = "one4seveneight";
        int result = solution(s);
        System.out.println(result);

        s = "23four5six7";
        result = solution(s);
        System.out.println(result);

        s = "2three45sixseven";
        result = solution(s);
        System.out.println(result);

        s = "123";
        result = solution(s);
        System.out.println(result);
    }

    public static int solution(String s) {
        List<String> words = List.of("zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine");

        for(int i = 0 ; i < words.size(); i++) {
            s = s.replaceAll(words.get(i), i + "");
        }

        return Integer.parseInt(s);
    }
}
