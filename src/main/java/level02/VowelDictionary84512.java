package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 모음 사전
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/84512
 */
public class VowelDictionary84512 {

    /*
    입출력 예
    word	result
    "AAAAE"	6
    "AAAE"	10
    "I"	1563
    "EIO"	1189
     */
    public static void main(String[] args) {
        VowelDictionary84512 vowelDictionary = new VowelDictionary84512();
        System.out.println(vowelDictionary.solution("AAAAE"));
        System.out.println(vowelDictionary.solution("AAAE"));
        System.out.println(vowelDictionary.solution("I"));
        System.out.println(vowelDictionary.solution("EIO"));
    }

    public int solution(String word) {
        List<Character> elements = new ArrayList<>();

        elements.add('A');
        int answer = 1;

        while(!isEqual(word, elements)) {
            answer++;
            if(elements.size() == 5) {
                changeLastCh(elements);
            } else {
                elements.add('A');
            }
        }

        return answer;
    }

    private boolean isEqual(String word, List<Character> elements) {
        if(word.length() != elements.size()) return false;

        for(int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != elements.get(i)) return false;
        }
        return true;
    }

    private void changeLastCh(List<Character> elements) {
        int lastIdx = elements.size() - 1;
        char lastCh = elements.get(lastIdx);

        switch(lastCh) {
            case 'A':
                elements.set(lastIdx, 'E');
                break;
            case 'E':
                elements.set(lastIdx, 'I');
                break;
            case 'I':
                elements.set(lastIdx, 'O');
                break;
            case 'O':
                elements.set(lastIdx, 'U');
                break;
            case 'U':
                elements.remove(lastIdx);
                changeLastCh(elements);
                break;
        }
    }
}
