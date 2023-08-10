package level02;

/**
 * 카펫
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42842
 */
public class Carpet42842 {

    /*
    입출력 예
    brown	yellow	return
    10	2	[4, 3]
    8	1	[3, 3]
    24	24	[8, 6]
     */
    public static void main(String[] args) {
        int[] result = solution(10, 2);
        System.out.println(result[0] + ", " + result[1]);

        result = solution(8, 1);
        System.out.println(result[0] + ", " + result[1]);

        result = solution(24, 24);
        System.out.println(result[0] + ", " + result[1]);
    }

    public static int[] solution(int brown, int yellow) {
        int area = brown + yellow;

        int h = 0;
        int w = 0;
        for(int i = 3 ; i * i <= area; i++) {
            if(area % i == 0) {
                w = area / i;
                h = i;

                if(yellow == (w - 2) * (h - 2))
                    break;
            }
        }

        return new int[]{w, h};
    }
}
