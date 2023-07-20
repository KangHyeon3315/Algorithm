package level01;

import java.util.ArrayList;
import java.util.List;

/**
 * 햄버거 만들기
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/133502
 */
public class MakingBurgers133502 {

    /*
    1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1
    1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1
    1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1
    2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1
    2, 3, 2, 3, 1, 2, 3, 1
    2, 3, 2, 3,

     */
    public static void main(String[] args) {
        int[] ingredient = {1, 1, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1, 2, 3, 1};

        int result = solution(ingredient);
        System.out.println(result);
    }

    public static int solution(int[] ingredient) {
        int answer = 0;

        ArrayList<Integer> ingredientStack = new ArrayList<>();
        for(int i = 0 ; i < ingredient.length; i++) {
            ingredientStack.add(ingredient[i]);
            int stackSize = ingredientStack.size();

            if(stackSize < 4) continue;

            if(ingredientStack.get(stackSize - 1) == 1 &&
                    ingredientStack.get(stackSize - 2) == 3 &&
                    ingredientStack.get(stackSize - 3) == 2 &&
                    ingredientStack.get(stackSize - 4) == 1
            ) {
                answer++;
                ingredientStack.remove(stackSize - 1);
                ingredientStack.remove(stackSize - 2);
                ingredientStack.remove(stackSize - 3);
                ingredientStack.remove(stackSize - 4);

            }
        }
        return answer;
    }

    private static void printStack(List<Integer> stack) {
        for(int i : stack) {
            System.out.printf("%d, ", i);
        }
        System.out.println();
    }

}
