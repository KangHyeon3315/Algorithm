package level01;

import java.util.HashMap;

/**
 * 성격 유형 검사하기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 */
public class PersonalityTypeCheck118666 {
    public static void main(String[] args) {
        /*
        입출력 예
        survey	choices	result
        ["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
        ["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
         */

        String[] survey = {"AN", "CF", "MJ", "RT", "NA"};
        int[] choices = {5, 3, 2, 7, 5};
        String result = solution(survey, choices);
        System.out.println("Case 1 : " + result);

        survey = new String[]{"TR", "RT", "TR"};
        choices = new int[]{7, 1, 3};
        result = solution(survey, choices);
        System.out.println("Case 2 : " + result);
    }

    public static String solution(String[] survey, int[] choices) {
        HashMap<Character, Integer> scoreMap = new HashMap<>();

        for(int i = 0 ; i < survey.length; i++) {
            String surveyCase = survey[i];
            int choice = choices[i];

            if(choice > 4) {
                // 비동의
                char ch = surveyCase.charAt(1);
                int score = choice - 4;
                scoreMap.put(ch, scoreMap.getOrDefault(ch, 0) + score);
            } else if(choice < 4) {
                // 동의
                char ch = surveyCase.charAt(0);
                int score = 4 - choice;
                scoreMap.put(ch, scoreMap.getOrDefault(ch, 0) + score);
            }
        }

        return String.format("%c%c%c%c",
                getCase(scoreMap, "RT"),
                getCase(scoreMap, "CF"),
                getCase(scoreMap, "JM"),
                getCase(scoreMap, "AN")
        );
    }

    private static char getCase(HashMap<Character, Integer> scoreMap, String surveyCase) {
        char a = surveyCase.charAt(0);
        char b = surveyCase.charAt(1);
        int aScore = scoreMap.getOrDefault(a, 0);
        int bScore = scoreMap.getOrDefault(b, 0);

        if(aScore > bScore) {
            return a;
        } else if(aScore < bScore) {
            return b;
        } else {
            return a > b ? b : a;
        }
    }
}
