package level01;

/**
 * 문자열 다루기 기본
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12918
 */
public class BasicString12918 {

    /*
    입출력 예
    s	return
    "a234"	false
    "1234"	true
     */
    public static void main(String[] args) {
        String s = "a234";
        boolean result = solution(s);
        System.out.println(result);

        s = "1234";
        result = solution(s);
        System.out.println(result);
    }

    public static boolean solution(String s) {
        if(s.length() != 4 && s.length() != 6) {
            return false;
        }

        for(char ch : s.toCharArray()) {
            if(ch < '0' || ch > '9') {
                return false;
            }
        }

        return true;
    }
}
