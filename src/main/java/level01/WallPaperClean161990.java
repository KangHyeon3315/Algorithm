package level01;

/**
 * 바탕화면 정리
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/161990
 */
public class WallPaperClean161990 {

    public static void main(String[] args) {
        String[][] wallpapers = {{".#...", "..#..", "...#."}, {"..........", ".....#....", "......##..", "...##.....", "....#....."}, {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."}, {"..", "#."}};

        for (String[] wallpaper : wallpapers) {
            int[] result = solution(wallpaper);

            for (int r : result) {
                System.out.printf("%d  ", r);
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] wallpaper) {
        int minX = Integer.MAX_VALUE;
        int maxX = 0;

        int minY = Integer.MAX_VALUE;
        int maxY = 0;

        for(int y = 0; y < wallpaper.length; y++) {
            String row = wallpaper[y];
            for(int x = 0 ; x < row.length(); x++) {
                char ch = row.charAt(x);

                if(ch == '#') {
                    minX = minX < x ? minX : x;
                    maxX = maxX < x ? x : maxX;
                    minY = minY < y ? minY : y;
                    maxY = maxY < y ? y : maxY;
                }
            }
        }

        return new int[]{minY, minX, maxY + 1, maxX + 1};
    }
}
