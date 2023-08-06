package level01;

/**
 * 이상한 문자 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12930
 */
public class MakeStrangeChar12930 {

    /*
    입출력 예
    s	return
    "try hello world"	"TrY HeLlO WoRlD"
     */
    public static void main(String[] args) {
        String s = "try hello world";
        String result = solution(s);
        System.out.println(result);
    }

    public static String solution(String s) {
        int dist = 'a' - 'A';

        char[] sArr = s.toCharArray();

        int wordStartIdx = 0;
        for(int i = 0; i < sArr.length; i++) {
            if(sArr[i] == ' ') {
                wordStartIdx = i + 1;
                continue;
            }

            if((i - wordStartIdx) % 2 == 0) {
                if(sArr[i] >= 'a' && sArr[i] <= 'z')
                    sArr[i] = (char)((int)sArr[i] - dist);
            } else {
                if(sArr[i] >= 'A' && sArr[i] <= 'Z')
                    sArr[i] = (char)((int)sArr[i] + dist);
            }
        }

        return String.valueOf(sArr);
    }
}
