package level1;
import java.util.*;
import java.util.stream.*;

public class 체육복 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        //낮은 순으로
        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌 & 잃어버린 애들
        Set<Integer> owns = Arrays.stream(lost)
                .boxed()
                .collect(Collectors.toSet());

        owns.retainAll(Arrays.stream(reserve)
                .boxed()
                .collect(Collectors.toSet())
        );

        //잃어버린 애들
        Queue<Integer> queue = new LinkedList<>();

        for(int i : lost) queue.add(i);

        int get = 0;

        for(int r : reserve){
            if(owns.contains(r)) continue;

            // -1보다 작은 애들 그리고 중복인 애들 빼기
            while(!queue.isEmpty() && (queue.peek() < r-1 || owns.contains(queue.peek()))){
                queue.poll();
            }

            if(queue.isEmpty()) break;

            if(queue.peek() <= r+1){
                queue.poll();
                get++;
            }

        }


        return n - lost.length + get + owns.size();
    }


    public int solution2(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        //reserve
        for(int i : reserve){
            reserveSet.add(i);
        }

        for(int i : lost){
            if(reserveSet.contains(i)){
                reserveSet.remove(i);
            }
            else{
                lostSet.add(i);
            }
        }

        for(Integer i : reserveSet){
            if(lostSet.contains(i-1)){
                lostSet.remove(i-1);
            }
            else if(lostSet.contains(i+1)){
                lostSet.remove(i+1);
            }
        }



        return n - lostSet.size();
    }

}
