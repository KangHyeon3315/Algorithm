package level01;

/**
 * 옹알이 (2)
 * <p>
 * https://school.programmers.co.kr/learn/courses/30/lessons/133499
 */
public class Babbling133499 {

    /*
    입출력 예
    babbling	result
    ["aya", "yee", "u", "maa"]	1
    ["ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"]	2
     */
    public static void main(String[] args) {
        String[] babbling = {"aya", "yee", "u", "maa"};

        int result = solution(babbling);
        System.out.println(result);

        babbling = new String[]{"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"};
        result = solution(babbling);
        System.out.println(result);
    }

    public static int solution(String[] babbling) {
        int answer = 0;
        String[] babbleable = {"aya", "ye", "woo", "ma"};

        for(String word : babbling) {
            String lastWord = "";

            int idx = 0;
            while(idx < word.length()) {
                boolean finded = false;

                for(String babbleableWord : babbleable) {
                    if(!lastWord.equals(babbleableWord) && word.startsWith(babbleableWord, idx)) {
                        lastWord = babbleableWord;
                        idx += babbleableWord.length();
                        finded = true;
                        break;
                    }
                }

                if(!finded) break;
            }

            if(idx >= word.length()) answer++;
        }
        return answer;
    }
}
