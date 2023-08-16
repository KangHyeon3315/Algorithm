package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로세스
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 */
public class Process42587 {

    /*
    입출력 예
    priorities	location	return
    [2, 1, 3, 2]	2	1
    [1, 1, 9, 1, 1, 1]	0	5
     */
    public static void main(String[] args) {
        System.out.println(new Process42587().solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(new Process42587().solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }

    public int solution(int[] priorities, int location) {
        int maxPriority = -1;
        List<Integer> q = new ArrayList<>();
        for(int p : priorities) {
            q.add(p);
            maxPriority = Math.max(maxPriority, p);
        }

        int answer = 0;
        while(q.size() > 0 && location >= 0) {
            int poped = q.remove(0);
            location--; // 앞으로 한칸 이동

            if(poped < maxPriority) {
                q.add(poped);

                if(location == -1) { // 알고싶은 프로세스가 뒤로간 경우
                    location = q.size() - 1;
                }
            } else {
                answer++;

                // 새로운 maxPriority 탐색
                maxPriority = -1;
                for(int p : q) maxPriority = Math.max(maxPriority, p);
            }
        }

        return answer;
    }
}
