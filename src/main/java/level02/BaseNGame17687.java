package level02;

/**
 * n진수 게임
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17687
 */
public class BaseNGame17687 {

    /*
    입출력 예제
    n	t	m	p	result
    2	4	2	1	"0111"
    16	16	2	1	"02468ACE11111111"
    16	16	2	2	"13579BDF01234567"
     */
    public static void main(String[] args) {
        System.out.println(new BaseNGame17687().solution(2, 4, 2, 1));
        System.out.println(new BaseNGame17687().solution(16, 16, 2, 1));
        System.out.println(new BaseNGame17687().solution(16, 16, 2, 2));
    }

    public String solution(int n, int t, int m, int p) {
        StringBuilder sb = new StringBuilder();

        int num = 0;
        int idx = p - 1;
        while(sb.length() < t) {
            String numBaseN = Integer.toString(num, n).toUpperCase();

            while(sb.length() < t && numBaseN.length() > idx) {
                char ch = numBaseN.charAt(idx);
                sb.append(ch);
                idx += m;
            }

            idx -= numBaseN.length();
            num++;
        }

        return sb.toString();
    }
}
