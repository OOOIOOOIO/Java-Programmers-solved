package kakao2019개발자겨울인턴십;

import java.util.*;
public class 호텔방배정 {

    Map<Long, Long> map = new HashMap<>();

    public long[] solution(long k, long[] room_number) {

        int size = room_number.length;

        long[] answer = new long[size];



        for(int i = 0; i < size; i++){
            answer[i] = findRoom(room_number[i]);
        }

        return answer;
    }

    public long findRoom(long roomNum){
        if(!map.containsKey(roomNum)){
            map.put(roomNum, roomNum+1); // 바로 다음 방번호까지
            return roomNum;
        }


        long nextRoomNum = map.get(roomNum);
        long checkRoomNum = findRoom(nextRoomNum);
        map.put(roomNum, checkRoomNum);
        return checkRoomNum;
    }

    //==================

    private static class Node{
        private int depth = 1;
        private Node parent = null;

        private long max;

        public Node(long value){
            this.max = value;
        }

        public boolean isConnected(Node node){
            return root() == node.root();
        }

        public long max(){
            return root().max;
        }

        public void merge(Node node){
            if(isConnected(node)) return;

            Node root1 = root();
            Node root2 = node.root();

            if(root1.depth > root2.depth){
                root2.parent = root1;
            }
            else if(root1.depth < root2.depth){
                root1.parent = root2;
            }
            else{
                root2.parent = root1;
                root1.depth += 1;
            }
        }

        private Node root(){
            if(parent == null) return this;

            return parent.root();
        }






    }

    public long[] solution2(long k, long[] room_number) {
        long[] answer = {};

        List<Long> assigned = new ArrayList<>();
        Map<Long, Node> nodes = new HashMap<>();

        for (long number : room_number) {
            if (nodes.containsKey(number)) {
                number = nodes.get(number).max() +1;
            }

            Node node = new Node(number);
            nodes.put(number, node);

            if(nodes.containsKey(number - 1)){
                node.merge(nodes.get(number - 1));
            }
            if(nodes.containsKey(number + 1)){
                node.merge(nodes.get(number + 1));
            }

            assigned.add(number);
        }


        return assigned.stream().mapToLong(Long::longValue).toArray();
    }

}
