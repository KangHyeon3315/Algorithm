package level02;

import java.util.*;

/**
 * 메뉴 리뉴얼
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/72411
 */
public class MenuRenewal72411 {

    /*
    [입출력 예]
    orders	course	result
    ["ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"]	[2,3,4]	["AC", "ACDE", "BCFG", "CDE"]
    ["ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"]	[2,3,5]	["ACD", "AD", "ADE", "CD", "XYZ"]
    ["XYZ", "XWY", "WXA"]	[2,3,4]	["WX", "XY"]
     */
    public static void main(String[] args) {
        MenuRenewal72411 menuRenewal72411 = new MenuRenewal72411();

        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2, 3, 4};

        String[] answer = menuRenewal72411.solution(orders, course);
        System.out.println(Arrays.toString(answer));

        orders = new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"};
        course = new int[]{2, 3, 5};
        answer = menuRenewal72411.solution(orders, course);
        System.out.println(Arrays.toString(answer));

        orders = new String[]{"XYZ", "XWY", "WXA"};
        course = new int[]{2, 3, 4};
        answer = menuRenewal72411.solution(orders, course);
        System.out.println(Arrays.toString(answer));
    }

    public String[] solution(String[] orders, int[] course) {
        // course num : {course 종류 : 주문 수 }
        Map<Integer, Map<String, Integer>> countMap = new HashMap<>();

        for(String order : orders) {
            char[] orderChArr = order.toCharArray();
            Arrays.sort(orderChArr);
            count(countMap, orderChArr, new StringBuilder(), 0);
        }

        List<String> answer = new ArrayList<>();
        for(int courseNum : course) {
            if(!countMap.containsKey(courseNum)) continue;
            Map<String, Integer> courseMap = countMap.get(courseNum);

            int courseOrderNum = 0;
            List<String> courseNames = new ArrayList<>();

            for(String courseName : courseMap.keySet()) {
                int orderNum = courseMap.get(courseName);
                if(orderNum < 2 || courseOrderNum > orderNum) continue;

                if(courseOrderNum == orderNum) {
                    courseNames.add(courseName);
                    continue;
                }

                courseOrderNum = orderNum;
                courseNames = new ArrayList<>();
                courseNames.add(courseName);
            }

            answer.addAll(courseNames);
        }

        return answer.stream().sorted().toArray(String[]::new);
    }

    private void count(Map<Integer, Map<String, Integer>> countMap, char[] order, StringBuilder picked, int idx) {
        for(int i = idx; i < order.length; i++) {
            char ch = order[i];
            picked.append(ch);

            int count = picked.length();
            String course = picked.toString();

            countMap.putIfAbsent(count, new HashMap<>());
            Map<String, Integer> courseMap = countMap.get(count);
            courseMap.put(course, courseMap.getOrDefault(course, 0) + 1);

            count(countMap, order, picked, i + 1);

            picked.deleteCharAt(picked.length() - 1);
        }

    }
}
