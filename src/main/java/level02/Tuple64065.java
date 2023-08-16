package level02;

import java.util.*;

/**
 * 튜플
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/64065
 */
public class Tuple64065 {
    /*
    [입출력 예]
    s	result
    "{{2},{2,1},{2,1,3},{2,1,3,4}}"	[2, 1, 3, 4]
    "{{1,2,3},{2,1},{1,2,4,3},{2}}"	[2, 1, 3, 4]
    "{{20,111},{111}}"	[111, 20]
    "{{123}}"	[123]
    "{{4,2,3},{3},{2,3,4,1},{2,3}}"	[3, 2, 4, 1]
     */
    public static void main(String[] args) {
        Tuple64065 tuple = new Tuple64065();

        int[] result = tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}");
        System.out.println(Arrays.toString(result));

        result = tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}");
        System.out.println(Arrays.toString(result));

        result = tuple.solution("{{20,111},{111}}");
        System.out.println(Arrays.toString(result));

        result = tuple.solution("{{123}}");
        System.out.println(Arrays.toString(result));

        result = tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String s) {
        Map<Integer, List<Integer>> elementsMap = parseS(s);

        int[] answer = new int[elementsMap.keySet().size()];
        for(Integer elSize : elementsMap.keySet()) { // keySet은 기본적으로 정렬되어있음
            List<Integer> elements = elementsMap.get(elSize);

            if(elSize == 1) {
                answer[0] = elements.get(0);
            } else {
                // 이전에 사용한 elements 제거
                for(int i = 0; i < elSize; i++) {
                    int idx = elements.indexOf(answer[i]);
                    if(idx < 0) continue;

                    elements.remove(idx);
                }

                answer[elSize - 1] = elements.get(0);
            }
        }

        return answer;
    }

    private Map<Integer, List<Integer>> parseS(String s) {
        // 가장 바깥의 {} 제거
        String processedS = s.substring(1, s.length() -1);

        // tuple들을 분리
        String[] tuples = processedS.replaceAll("\\},\\{", "} {").split(" ");

        Map<Integer, List<Integer>> elementsMap = new HashMap<>();
        for(String tuple : tuples) {
            String[] elements = tuple.substring(1, tuple.length() -1).split(",");

            List<Integer> elementsList = new ArrayList<>();
            elementsMap.put(elements.length, elementsList);
            for(String el : elements) {
                elementsList.add(Integer.parseInt(el));
            }
        }

        return elementsMap;
    }

}
