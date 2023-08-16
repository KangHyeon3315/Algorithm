package level02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 기능개발
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 */
public class FunctionDeelop42586 {

    /*
    입출력 예
    progresses	speeds	return
    [93, 30, 55]	[1, 30, 5]	[2, 1]
    [95, 90, 99, 99, 80, 99]	[1, 1, 1, 1, 1, 1]	[1, 3, 2]
     */
    public static void main(String[] args) {
        int[] result = new FunctionDeelop42586().solution(new int[]{93, 30, 55}, new int[]{1, 30, 5});
        System.out.println(Arrays.toString(result));

        result = new FunctionDeelop42586().solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> publish = new ArrayList<>();
        List<Integer> duration = new ArrayList<>();

        for(int i = 0; i < progresses.length; i++) {
            int rest = (int)Math.ceil((100. - progresses[i]) / speeds[i]);

            if(duration.size() > 0 && duration.get(duration.size() - 1) >= rest) {
                // 뒷 작업이 먼저 끝나거나 같이 끝나는 경우
                int idx = publish.size() - 1;
                publish.set(idx, publish.get(idx) + 1);
            } else {
                publish.add(1);
                duration.add(rest);
            }
        }

        int[] answer = new int[publish.size()];
        for(int i = 0; i < publish.size(); i++) {
            answer[i] = publish.get(i);
        }

        return answer;
    }
}
