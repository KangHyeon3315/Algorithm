package level03;

import java.util.Queue;

public class DoublePriorityQueue42628 {

    class Node {
        private int value;

        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
            this.leftChild = null;
            this.rightChild = null;
        }

        public void add(int num) {
            if(value > num) {
                if(leftChild == null) {
                    leftChild = new Node(num);
                } else {
                    leftChild.add(num);
                }
            } else {
                if(rightChild == null) {
                    rightChild = new Node(num);
                } else {
                    rightChild.add(num);
                }
            }
        }

        public Node deleteMin() {
            if(leftChild == null) {
                // 본인이 최소값인 경우
                return rightChild;
            }

            leftChild = leftChild.deleteMin();

            return this;
        }

        public Node deleteMax() {
            if(rightChild == null) {
                return leftChild;
            }

            rightChild = rightChild.deleteMax();
            return this;
        }

        public int getMin() {
            if(leftChild == null) return value;
            return leftChild.getMin();
        }

        public int getMax() {
            if(rightChild == null) return value;
            return rightChild.getMax();
        }
    }

    /*
    입출력 예
    operations	return
    ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"]	[0,0]
    ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"]	[333, -45]
     */
    public static void main(String[] args) {
        DoublePriorityQueue42628 d = new DoublePriorityQueue42628();
        System.out.println(d.solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}));
        System.out.println(d.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}));
    }

    // 더 좋은방법 : 우선순위 큐를 이용한 연산
    public int[] solution(String[] operations) {
        Node n = null;
        for(String op : operations) {
            if(op.equals("D 1")) {
                if(n == null) continue;
                n = n.deleteMax();
            } else if(op.equals("D -1")) {
                if(n == null) continue;
                n = n.deleteMin();
            } else {
                int insertValue = Integer.parseInt(op.substring(2));
                if(n == null) {
                    n = new Node(insertValue);
                } else {
                    n.add(insertValue);
                }
            }
        }

        if(n == null) {
            return new int[]{0, 0};
        }

        return new int[]{n.getMax(), n.getMin()};
    }
}

