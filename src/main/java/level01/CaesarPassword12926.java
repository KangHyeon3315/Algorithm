package level01;

/**
 * 시저 암호
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12926
 */
public class CaesarPassword12926 {

    /*
    입출력 예
    s	n	result
    "AB"	1	"BC"
    "z"	1	"a"
    "a B z"	4	"e F d"
     */
    public static void main(String[] args) {
        String s = "AB";
        int n = 1;
        String result = solution(s, n);
        System.out.println(result);

        s = "z";
        n = 1;
        result = solution(s, n);
        System.out.println(result);

        s = "a B z";
        n = 4;
        result = solution(s, n);
        System.out.println(result);
    }

    public static String solution(String s, int n) {
        char[] sArr = s.toCharArray();

        for(int i = 0 ; i < sArr.length; i++) {
            if(sArr[i] == ' ') continue;

            if(sArr[i] >= 'a' && sArr[i] <= 'z') {
                sArr[i] += n;

                if(sArr[i] > 'z') {
                    sArr[i] = (char)('a' - 1 + (sArr[i] - 'z'));
                }
            } else if(sArr[i] >= 'A' && sArr[i] <= 'Z') {
                sArr[i] += n;

                if(sArr[i] > 'Z') {
                    sArr[i] = (char)('A' - 1 + (sArr[i] - 'Z'));
                }
            }
        }

        return String.valueOf(sArr);
    }
}
