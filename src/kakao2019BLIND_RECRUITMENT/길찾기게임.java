package kakao2019BLIND_RECRUITMENT;

import java.util.*;


public class 길찾기게임 {

    class Node{
        int idx;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int idx, int x, int y){
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

    }


    int[][] answer;
    int cnt = 0;

    public int[][] solution(int[][] nodeinfo) {
        Node[] node = new Node[nodeinfo.length];
        answer = new int[2][nodeinfo.length];


        for(int i = 0; i < nodeinfo.length; i++) {
            node[i] = new Node(i+1, nodeinfo[i][0], nodeinfo[i][1]);
        }


        Arrays.sort(node, (n1, n2) -> {
            if(n1.y == n2.y) return n1.x - n2.x;
            else return n2.y - n1.y;
        });

        // 처음, 루트 노드
        Node root = node[0];

        for(int i = 1; i < node.length; i++) {
            makeTree(root, node[i]);
        }

        preOrder(root);
        cnt = 0;
        postOrder(root);


        return answer;
    }

    public void makeTree(Node root, Node child){
        Node curr = root;

        while (true){
            if(curr.x > child.x){ // left
                if(curr.left != null){
                    curr = curr.left;
                }
                else{ // left가 없을 때
                    curr.left = child;
                    break;
                }
            }
            else{ // right
                if(curr.right != null){
                    curr = curr.right;
                }
                else{
                    curr.right = child;
                    break;
                }
            }
        }
    }

    public void preOrder(Node root){
        answer[0][cnt++] = root.idx;
        System.out.println(root.idx);
        if(root.left != null)preOrder(root.left);
        if(root.right != null)preOrder(root.right);

    }

    public void postOrder(Node root){
        if(root.left != null)postOrder(root.left);
        if(root.right != null)postOrder(root.right);
        System.out.println(root.idx);
        answer[1][cnt++] =root.idx;
    }

    public static void main(String[] args) {
        int[][] node = new int[][]{{1, 2}, {1, 3}, {2, 1}};

        Arrays.sort(node, (o1, o2) -> o2[1] - o1[1]);

        for (int[] ints : node) {
            System.out.println("x = "+ ints[0] + "y =" + ints[1]);
        }

    }




}
