package level01;

/**
 * 공원 산책
 * <p>
 * 입출력 예
 * park	routes	result
 * ["SOO","OOO","OOO"]	["E 2","S 2","W 1"]	[2,1]
 * ["SOO","OXX","OOO"]	["E 2","S 2","W 1"]	[0,1]
 * ["OSO","OOO","OXO","OOO"]	["E 2","S 3","W 1"]	[0,0]
 */
public class ParkWalk172928 {
    public static void main(String[] args) {
        String[][] parks = {{"SOO", "OOO", "OOO"}, {"SOO", "OXX", "OOO"}, {"OSO", "OOO", "OXO", "OOO"}};
        String[][] routes = {{"E 2", "S 2", "W 1"}, {"E 2", "S 2", "W 1"}, {"E 2", "S 3", "W 1"}};

        for (int i = 0; i < parks.length; i++) {
            int[] result = solution(parks[i], routes[i]);

            for (int r : result) {
                System.out.printf("%d  ", r);
            }
            System.out.println();
        }
    }

    public static int[] solution(String[] park, String[] routes) {
        int height = park.length;
        int width = park[0].length();

        int botX = 0;
        int botY = 0;
        boolean found = false;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (park[y].charAt(x) == 'S') {
                    botX = x;
                    botY = y;
                    found = true;
                    break;
                }
            }

            if (found) break;
        }


        for (String route : routes) {
            char dir = route.charAt(0);
            int n = route.charAt(2) - '0';

            boolean movable = true;
            switch (dir) {
                case 'E':
                    if (botX + n >= width)
                        continue;

                    for (int i = 1; i <= n; i++) {
                        if (park[botY].charAt(botX + i) == 'X') {
                            movable = false;
                            break;
                        }
                    }

                    if (movable) botX += n;
                    break;
                case 'W':
                    if (botX - n < 0)
                        continue;

                    for (int i = 1; i <= n; i++) {
                        if (park[botY].charAt(botX - i) == 'X') {
                            movable = false;
                            break;
                        }
                    }

                    if (movable) botX -= n;
                    break;
                case 'S':
                    if (botY + n >= height)
                        continue;

                    for (int i = 1; i <= n; i++) {
                        if (park[botY + i].charAt(botX) == 'X') {
                            movable = false;
                            break;
                        }
                    }

                    if (movable) botY += n;
                    break;
                case 'N':
                    if (botY - n < 0)
                        continue;

                    for (int i = 1; i <= n; i++) {
                        if (park[botY - i].charAt(botX) == 'X') {
                            movable = false;
                            break;
                        }
                    }

                    if (movable) botY -= n;
                    break;
            }

        }
        return new int[]{botY, botX};
    }
}
