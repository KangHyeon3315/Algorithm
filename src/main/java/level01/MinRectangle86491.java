package level01;

/**
 * 최소직사각형
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */
public class MinRectangle86491 {

    public static void main(String[] args) {
        int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
        int result = solution(sizes);
        System.out.println("Case 1 : " + result);

        sizes = new int[][]{{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}};
        result = solution(sizes);
        System.out.println("Case 2 : " + result);

        sizes = new int[][]{{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}};
        result = solution(sizes);
        System.out.println("Case 3 : " + result);
    }

    public static int solution(int[][] sizes) {

        int walletX = 0;
        int walletY = 0;
        for(int[] size : sizes) {
            int x = Math.max(size[0], size[1]);
            int y = Math.min(size[0], size[1]);

            walletX = Math.max(walletX, x);
            walletY = Math.max(walletY, y);
        }

        return walletX * walletY;
    }
}
