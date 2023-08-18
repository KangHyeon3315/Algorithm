package level02;

import java.util.*;

/**
 * [3차] 압축
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/17684
 */
public class Compress17684 {

    /*
    입출력 예제
    msg	answer
    KAKAO	[11, 1, 27, 15]
    TOBEORNOTTOBEORTOBEORNOT	[20, 15, 2, 5, 15, 18, 14, 15, 20, 27, 29, 31, 36, 30, 32, 34]
    ABABABABABABABAB	[1, 2, 27, 29, 28, 31, 30]
     */
    public static void main(String[] args) {
        int[] result = new Compress17684().solution("KAKAO");
        System.out.println(Arrays.toString(result));

        result = new Compress17684().solution("TOBEORNOTTOBEORTOBEORNOT");
        System.out.println(Arrays.toString(result));

        result = new Compress17684().solution("ABABABABABABABAB");
        System.out.println(Arrays.toString(result));
    }

    public int[] solution(String msg) {
        Map<String, Integer> sIMap = new HashMap<>();
        for(int ch = 'A'; ch <= 'Z'; ch++) {
            sIMap.put((char)ch + "", ch - 'A' + 1);
        }

        List<Integer> result = new ArrayList<>();
        String w;
        String c;
        int wStart = 0;
        int wEnd = 0;
        while(wStart < msg.length()) {
            w = msg.substring(wStart, wEnd + 1);
            if(wEnd + 2 <= msg.length()) {
                c = msg.substring(wEnd + 1, wEnd + 2);
            } else {
                c = null;
            }

            if(c == null) {
                result.add(sIMap.get(w));
                break;
            }


            if(!sIMap.containsKey(w + c)) {
                result.add(sIMap.get(w));
                sIMap.put(w + c, sIMap.size() + 1);
                wStart += w.length();
                wEnd = wStart;
            } else {
                wEnd++;
            }
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
