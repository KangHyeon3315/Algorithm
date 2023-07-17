package level01;

/**
 * 기사단원의 무기
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/136798
 * <p>
 * 입출력 예
 * number	limit	power	result
 * 10	3	2	21
 */
public class KnightsWeapon {

    public static void main(String[] args) {
        int number = 10;
        int limit = 3;
        int power = 2;

        int result = solution(number, limit, power);
        System.out.println(result);
    }

    public static int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 0; i <= number; i++) {
            int knightPower = getDivisorCount(i);
            answer += knightPower > limit ? power : knightPower;
        }
        return answer;
    }

    private static int getDivisorCount(int num) {
        int count = 0;
        for (int i = 1; i <= Math.sqrt(num); i++) {
            if(num == i * i) count++;
            else if (num % i == 0) count += 2;
        }

        return count;
    }
}
