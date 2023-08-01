package level01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeSet;

/**
 * 체육복
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42862
 */
public class WorkoutClothes42862 {

    /*
    입출력 예
    n	lost	reserve	return
    5	[2, 4]	[1, 3, 5]	5
    5	[2, 4]	[3]	4
    3	[3]	[1]	2
     */
    public static void main(String[] args) {
        int n = 5;
        int[] lost = {2, 4};
        int[] reserve = {1, 3, 5};

        int result = solution(n, lost, reserve);
        System.out.println(result);

        n = 5;
        lost = new int[]{2, 4};
        reserve = new int[]{3};
        result = solution(n, lost, reserve);
        System.out.println(result);

        n = 3;
        lost = new int[]{3};
        reserve = new int[]{1};
        result = solution(n, lost, reserve);
        System.out.println(result);

        n = 5;
        lost = new int[]{4, 5};
        reserve = new int[]{3, 4};
        result = solution(n, lost, reserve);
        System.out.println(result);
    }

    public static int solution(int n, int[] lost, int[] reserve) {
        TreeSet<Integer> losts = new TreeSet<>();
        for(int l : lost) losts.add(l);

        TreeSet<Integer> reserves = new TreeSet<>();
        for(int r : reserve) reserves.add(r);

        int answer = n - lost.length;
        TreeSet<Integer> removed = new TreeSet<>();
        for(int reserveStudent : reserves) {
            if(losts.contains(reserveStudent)) { // 본인이 도난맞은 경우
                answer++;
                losts.remove(reserveStudent);
                removed.add(reserveStudent);
            }
        }
        reserves.removeAll(removed);

        for(int reserveStudent : reserves) {
            if(losts.contains(reserveStudent - 1)) { // 왼쪽 학생이 도난맞은 경우
                answer++;
                losts.remove(reserveStudent - 1);
            } else if(losts.contains(reserveStudent + 1)) { // 오른쪽 학생이 도난맞은 경우
                answer++;
                losts.remove(reserveStudent + 1);
            }
        }
        return answer;
    }
}
