package level01;

/**
 * 삼총사
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/131705
 */
public class Trio131705 {
    public static void main(String[] args) {
        int[] number = {-2, 3, 0, 2, -5};

        int result = solution(number);
        System.out.println(result);

        number = new int[]{-3, -2, -1, 0, 1, 2, 3};
        result = solution(number);
        System.out.println(result);

        number = new int[]{-1, 1, -1, 1};
        result = solution(number);
        System.out.println(result);
    }

    public static int solution(int[] number) {
        int answer = 0;

        for(int aIdx = 0; aIdx < number.length - 2; aIdx++) {
            for(int bIdx = aIdx + 1; bIdx < number.length - 1; bIdx++) {
                for(int cIdx = bIdx + 1; cIdx < number.length; cIdx++) {
                    int a = number[aIdx];
                    int b = number[bIdx];
                    int c = number[cIdx];

                    if(a + b + c == 0) answer++;
                }
            }
        }

        return answer;
    }
}
