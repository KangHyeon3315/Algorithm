package level02;

import java.util.HashSet;

/**
 * 영어 끝말잇기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12981
 */
public class Shiritori12981 {

    /*
    입출력 예
    n	words	result
    3	["tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"]	[3,3]
    5	["hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"]	[0,0]
    2	["hello", "one", "even", "never", "now", "world", "draw"]	[1,3]
     */
    public static void main(String[] args) {
        System.out.println(solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"}));
        System.out.println(solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish", "hang", "gather", "refer", "reference", "estimate", "executive"}));
        System.out.println(solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"}));
    }


    public static int[] solution(int n, String[] words) {
        HashSet<String> wordSet = new HashSet<>();

        int count = 1;
        int player = 0;
        char lastWordCh = words[0].charAt(0);
        boolean complete = true;
        for(String word : words) {
            player += 1;
            if(player > n) {
                player -= n;
                count++;
            }

            if(wordSet.contains(word) || word.charAt(0) != lastWordCh) {
                complete = false;
                break;
            }
            lastWordCh = word.charAt(word.length() - 1);
            wordSet.add(word);
        }

        if(complete) {
            return new int[]{0, 0};
        }

        return new int[]{player, count};
    }
}
