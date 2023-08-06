package level01;

/**
 * 가운데 글자 가져오기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12903
 */
public class GetCenterChar12903 {

    /*
    입출력 예
    s	return
    "abcde"	"c"
    "qwer"	"we"
     */
    public static void main(String[] args) {
        String s = "abcde";
        String result = solution(s);
        System.out.println(result);

        s = "qwer";
        result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        if(s.length() % 2 == 0) {
            return s.substring(s.length() / 2 - 1, s.length() / 2 + 1);
        } else {
            return s.substring(s.length() / 2, s.length() / 2 + 1);
        }

    }
}
