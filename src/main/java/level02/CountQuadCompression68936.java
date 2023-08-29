package level02;

import java.util.Arrays;

/**
 * 쿼드압축 후 개수 세기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
public class CountQuadCompression68936 {

    /*
    입출력 예
    arr	result
    [[1,1,0,0],[1,0,0,0],[1,0,0,1],[1,1,1,1]]	[4,9]
    [[1,1,1,1,1,1,1,1],[0,1,1,1,1,1,1,1],[0,0,0,0,1,1,1,1],[0,1,0,0,1,1,1,1],[0,0,0,0,0,0,1,1],[0,0,0,0,0,0,0,1],[0,0,0,0,1,0,0,1],[0,0,0,0,1,1,1,1]]
     */
    public static void main(String[] args) {
        CountQuadCompression68936 countQuadCompression68936 = new CountQuadCompression68936();

        int[][] arr = {
            {1,1,0,0},
            {1,0,0,0},
            {1,0,0,1},
            {1,1,1,1}
        };

        int[] answer = countQuadCompression68936.solution(arr);

        System.out.println(Arrays.toString(answer));
    }

    public int[] solution(int[][] arr) {
        int size = arr.length;
        int[] answer = new int[2];

        boolean[][] compressed = new boolean[size][size];
        for(int scale = size; scale > 1; scale /= 2) {
            for(int i = 0; i < size / scale; i++) {
                int x1 = scale * i;
                int x2 = scale * (i + 1) - 1;


                for(int j = 0; j < size / scale; j++) {
                    int y1 = scale * j;
                    int y2 = scale * (j + 1) - 1;

                    if(compressed[x1][y1]) continue;

                    if(compressable(arr, x1, x2, y1, y2)) {
                        int value = compress(arr, compressed, x1, x2, y1, y2);
                        answer[value]++;
                    }
                }
            }
        }

        for(int x = 0; x < size; x++) {
            for(int y = 0; y < size; y++) {
                if(!compressed[x][y]) {
                    answer[arr[x][y]]++;
                }
            }
        }


        return answer;
    }

    private boolean compressable(int[][] arr, int x1, int x2, int y1, int y2) {
        int value = arr[x1][y1];
        for(int x = x1; x <= x2; x++) {
            for(int y = y1; y <= y2; y++) {
                if(value != arr[x][y]) {
                    return false;
                }
            }
        }
        return true;
    }

    private int compress(int[][] arr, boolean[][] compressed, int x1, int x2, int y1, int y2) {
        int value = arr[x1][y1];
        for(int x = x1; x <= x2; x++) {
            for(int y = y1; y <= y2; y++) {
                compressed[x][y] = true;
            }
        }
        return value;
    }
}
