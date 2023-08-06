package level01;

/**
 * 수박수박수박수박수박수?
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12922
 */
public class WaterMelon12922 {

    /*
    입출력 예
    n	return
    3	"수박수"
    4	"수박수박"
     */
    public static void main(String[] args) {
        int n = 3;
        String result = solution(n);
        System.out.println(result);

        n = 4;
        result = solution(n);
        System.out.println(result);
    }

    public static String solution(int n) {
        StringBuilder answer = new StringBuilder();
        for(int i = 0 ; i < n; i++) {
            answer.append(i % 2 == 0 ? "수" : "박");
        }
        return answer.toString();
    }
}
