package level01;

/**
 * 콜라츠 추측
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12943
 */
public class ColatzConjecture12943 {

    /*
    입출력 예
    n	result
    6	8
    16	4
    626331	-1
     */
    public static void main(String[] args) {
        int num = 6;
        int result = solution(num);
        System.out.println(result);

        num = 16;
        result = solution(num);
        System.out.println(result);

        num = 626331;
        result = solution(num);
        System.out.println(result);
    }

    public static int solution(int num) {
        long a = (long)num;
        int count = 0;

        while(a != 1) {
            count++;

            if(a % 2 == 0) a /= 2;
            else a = a * 3 + 1;

            if(count > 500) {
                count = -1;
                break;
            }
        }

        return count;
    }
}
