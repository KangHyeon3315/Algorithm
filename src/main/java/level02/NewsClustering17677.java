package level02;

import java.util.ArrayList;
import java.util.List;

/**
 * 뉴스 클러스터링
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
 */
public class NewsClustering17677 {

    /*
    예제 입출력
    str1	str2	answer
    FRANCE	french	16384
    handshake	shake hands	65536
    aa1+aa2	AAAA12	43690
    E=M*C^2	e=m*c^2	65536
     */
    public static void main(String[] args) {
        System.out.println(new NewsClustering17677().solution("FRANCE", "french"));
        System.out.println(new NewsClustering17677().solution("handshake", "shake hands"));
        System.out.println(new NewsClustering17677().solution("aa1+aa2", "AAAA12"));
        System.out.println(new NewsClustering17677().solution("E=M*C^2", "e=m*c^2"));
    }

    public int solution(String str1, String str2) {
        List<String> elements1 = parseStr(str1);
        List<String> elements2 = parseStr(str2);

        int intersection = 0;
        int union = elements1.size();
        for(String el : elements1) {
            if(elements2.contains(el)) {
                intersection++;
                elements2.remove(el);
            }
        }
        union += elements2.size(); // elements2의 중복되지 않는 문자열 갯수 추가

        double jacquard = union > 0 ? (double)intersection / union : 1.;

        return (int)(jacquard * 65536);
    }

    private List<String> parseStr(String str) {
        List<String> elements = new ArrayList<>();
        for(int i = 0; i < str.length() - 1; i++) {
            String s = str.substring(i, i + 2).toLowerCase();
            if(isAlpha(s))
                elements.add(s);
        }

        return elements;
    }

    private boolean isAlpha(String s) {
        for(char ch : s.toCharArray()) {
            if(ch < 'a' || ch > 'z')
                return false;
        }
        return true;
    }
}
