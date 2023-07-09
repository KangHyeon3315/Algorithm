package level01;

/**
 * 카드 뭉치
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/159994?language=java
 */
public class BunchOfCards159994 {

    public static void main(String[] args) {
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        String result = solution(cards1, cards2, goal);
        System.out.println(result);
    }

    public static String solution(String[] cards1, String[] cards2, String[] goal) {
        int card1Idx = 0;
        int card2Idx = 0;

        for(int i = 0 ; i < goal.length; i++) {
            String word = goal[i];

            if(cards1.length > card1Idx && word.equals(cards1[card1Idx])) {
                card1Idx++;
                continue;
            }

            if(cards2.length > card2Idx && word.equals(cards2[card2Idx])) {
                card2Idx++;
                continue;
            }

            return "No";
        }
        return "Yes";
    }
}
