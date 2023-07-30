package level01;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 크레인 인형뽑기 게임
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/64061
 */
public class CraneMachineGame64061 {

    /*
    입출력 예
    board	moves	result
    [[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
     */
    public static void main(String[] args) {
        int[][] board = {
                {0, 0, 0, 0, 0},
                {0, 0, 1, 0, 3},
                {0, 2, 5, 0, 1},
                {4, 2, 4, 4, 2},
                {3, 5, 1, 3, 1}
        };

        int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

        int result = solution(board, moves);
        System.out.println(result);
    }

    public static int solution(int[][] board, int[] moves) {
        int[] topIdx = new int[board.length];
        ArrayList<Integer> stack = new ArrayList<>();

        // n * n 사이즈
        for (int x = 0; x < board.length; x++) {
            topIdx[x] = board.length;

            for (int y = 0; y < board.length; y++) {
                if (board[y][x] == 0) continue;

                topIdx[x] = y;
                break;
            }
        }

        int answer = 0;
        for (int move : moves) {
            int x = move - 1;

            if (topIdx[x] >= board.length)
                continue; // 비어있는 칸

            int top = topIdx[x];
            int picked = board[top][x];

            topIdx[x] += 1;

            if (stack.size() > 0 && stack.get(stack.size() - 1) == picked) {
                stack.remove(stack.size() - 1);
                answer += 2;
            } else {
                stack.add(picked);
            }
        }

        return answer;
    }
}
