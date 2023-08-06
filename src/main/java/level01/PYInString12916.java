package level01;

/**
 * 문자열 내 p와 y의 개수
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/12916
 */
public class PYInString12916 {

    /*
    입출력 예
    s	answer
    "pPoooyY"	true
    "Pyy"	false
     */
    public static void main(String[] args) {
        String s = "pPoooyY";
        boolean result = solution(s);
        System.out.println(result);

        s = "Pyy";
        result = solution(s);
        System.out.println(result);
    }

    public static boolean solution(String s) {
        int yCount = 0;
        int pCount = 0;

        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch == 'y') yCount++;
            else if (ch == 'p') pCount++;
        }

        return yCount == pCount;
    }
}
