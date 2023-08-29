package level02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 삼각 달팽이
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68645
 */
public class TriangularSnail68645 {

    /*
    입출력 예
    n	result
    4	[1,2,9,3,10,8,4,5,6,7]
    5	[1,2,12,3,13,11,4,14,15,10,5,6,7,8,9]
    6	[1,2,15,3,16,14,4,17,21,13,5,18,19,20,12,6,7,8,9,10,11]
     */
    public static void main(String[] args) {
        TriangularSnail68645 triangularSnail68645 = new TriangularSnail68645();

        int n = 4;

        int[] answer = triangularSnail68645.solution(n);

        for(int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    enum Mode {
        topToBottom,
        leftToRight,
        bottomToTop;
    }

    public int[] solution(int n) {
        Map<Integer, List<Integer>> tri = new HashMap<>();
        for(int i = 0; i < n; i++) {
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j <= i; j++) row.add(0);
            tri.put(i, row);
        }

        int i = 1;
        int x = 0;
        int y = 0;
        Mode mode = Mode.topToBottom;
        while(true) {
            if(y >= n || x >= tri.get(y).size() || tri.get(y).get(x) != 0) break;
            tri.get(y).set(x, i++);

            switch(mode) {
                case topToBottom:
                    if(y + 1 < n && tri.get(y + 1).get(x) == 0) {
                        y += 1;
                    } else {
                        mode = Mode.leftToRight;
                        x += 1;
                    }
                    break;
                case leftToRight:
                    if(x + 1 < tri.get(y).size() && tri.get(y).get(x + 1) == 0) {
                        x += 1;
                    } else {
                        mode = Mode.bottomToTop;
                        x -= 1;
                        y -= 1;
                    }
                    break;
                case bottomToTop:
                    if(y - 1 >= 0 && x - 1 >= 0 && tri.get(y - 1).get(x - 1) == 0) {
                        x -= 1;
                        y -= 1;
                    } else {
                        mode = Mode.topToBottom;
                        y += 1;
                    }
                    break;
            }
        }

        List<Integer> answer = new ArrayList<>();
        for(y = 0; y < n; y++) {
            answer.addAll(tri.get(y));
        }

        return answer.stream().mapToInt(v -> v).toArray();
    }
}
