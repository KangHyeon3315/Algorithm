package level02;

/**
 * 두 원 사이의 정수 쌍
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/181187
 */
public class IntegerPairBetweenTwoCircles181187 {

    public static void main(String[] args) {
        int r1 = 2;
        int r2 = 3;

        long result = solution(r1, r2);
        System.out.println(result);
    }

    public static long solution(int r1, int r2) {
        long answer = 0;
        for (long x = 1; x <= r2; x++) {
            double y2 = Math.sqrt((long)r2 * r2 - x * x);
            if (x < r1) {
                double y1 = Math.sqrt((long)r1 * r1 - x * x);
                double pointCount = Math.floor(y2) - Math.ceil(y1) + 1;
                answer += pointCount;
            } else {
                answer += Math.floor(y2) + 1;
            }
        }

        return answer * 4;
    }
}
