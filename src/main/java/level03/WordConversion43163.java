package level03;

/**
 * 단어 변환
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/43163
 */
public class WordConversion43163 {

    /*
    입출력 예
    begin	target	words	return
    "hit"	"cog"	["hot", "dot", "dog", "lot", "log", "cog"]	4
    "hit"	"cog"	["hot", "dot", "dog", "lot", "log"]	0
     */
    public static void main(String[] args) {
        System.out.println(new WordConversion43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(new WordConversion43163().solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }

    public int solution(String begin, String target, String[] words) {
        int answer = dfs(begin, target, words, new boolean[words.length]);

        if(answer > words.length) return 0;
        return answer;
    }

    private int dfs(String word, String target, String[] words, boolean[] uses) {
        if(word.equals(target)) return 0;

        int minimum = words.length;
        for(int i = 0; i < words.length; i++) {
            if(uses[i]) continue;

            if(possibleConversion(word, words[i])) {
                uses[i] = true;

                int minCount = dfs(words[i], target, words, uses);
                minimum = Math.min(minCount, minimum);

                uses[i] = false;
            }
        }

        return minimum + 1;
    }

    private boolean possibleConversion(String w1, String w2) {
        int diffCount = 0;
        for(int i = 0 ; i < w1.length(); i++) {
            if(w1.charAt(i) != w2.charAt(i)) {
                diffCount++;
            }

            if(diffCount > 1) {
                return false;
            }
        }

        return diffCount == 1;
    }
}
