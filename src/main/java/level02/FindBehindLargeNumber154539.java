package level02;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 뒤에 있는 큰 수 찾기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/154539
 */
public class FindBehindLargeNumber154539 {

    /*
    입출력 예
    numbers	result
    [2, 3, 3, 5]	[3, 5, 5, -1]
    [9, 1, 5, 3, 6, 2]	[-1, 5, 6, 6, -1, -1]
     */
    public static void main(String[] args) {
        FindBehindLargeNumber154539 findBehindLargeNumber = new FindBehindLargeNumber154539();
        int[] numbers = {2, 3, 3, 5};
        System.out.println(findBehindLargeNumber.solution(numbers));

        numbers = new int[] {9, 1, 5, 3, 6, 2};
        System.out.println(findBehindLargeNumber.solution(numbers));
    }

    class Element {
        public final int idx;
        public final int value;

        public Element(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];

        Queue<Element> heap = new PriorityQueue<>((o1, o2) -> o1.value - o2.value);

        for(int i = 0; i < numbers.length; i++) {
            int num = numbers[i];

            while(heap.size() > 0) {
                Element el = heap.poll();

                if(el.value < num) {
                    answer[el.idx] = num;
                } else {
                    heap.add(el);
                    break;
                }
            }

            heap.add(new Element(i, num));
        }

        for(Element el : heap) answer[el.idx] = -1;

        return answer;
    }
}
