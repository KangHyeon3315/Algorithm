package level01;

/**
 * 짝수와 홀수
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12937
 */
public class OddEven12937 {

    /*
    입출력 예
    num	return
    3	"Odd"
    4	"Even"
     */
    public static void main(String[] args) {
        int num = 3;
        String result = solution(num);
        System.out.println(result);

        num = 4;
        result = solution(num);
        System.out.println(result);
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }
}
