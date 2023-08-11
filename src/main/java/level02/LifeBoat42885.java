package level02;

import java.util.Arrays;

/**
 * 구명보트
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42885
 */
public class LifeBoat42885 {

    /*
    입출력 예
    people	limit	return
    [70, 50, 80, 50]	100	3
    [70, 80, 50]	100	3
     */
    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }

    public static int solution(int[] people, int limit) {
        Arrays.sort(people);

        int answer = 0;
        int min = 0;
        int max = people.length - 1;
        while(min <= max) {
            if(min == max) {
                // 혼자 남아서 타는경우
                answer++;
                break;
            }

            if(people[min] + people[max] <= limit) {
                // 두사람이 나눠타는 경우
                answer++;
                min++;
                max--;
            } else {
                // 무거운 사람이 혼자 타는 경우
                answer++;
                max--;
            }

        }

        return answer;
    }
}
