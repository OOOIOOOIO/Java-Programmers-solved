package kakao2018BLIND_RECRUITMENT;

import java.util.*;

public class 셔틀버스_1차 {


    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int changeTimeToInt(String time){

        String[] temp = time.split(":");
        int hours = Integer.parseInt(temp[0]) * 60;
        int minute = Integer.parseInt(temp[1]);


        return hours + minute;

    }

    public String solution(int n, int t, int m, String[] timetable) {
        String answer = "";

        for(String time : timetable){
            if(time.equals("23:59")) continue;

            int intTime = changeTimeToInt(time);
            pq.offer(intTime);
        }

        int startTime = 540; // 09:00
        int lastTime = 0; // 마지막 사람
        int cnt = 0;
        while(n-- > 0){
            cnt = 0; // 대기열 빠지는 사람

            while(!pq.isEmpty()){
                if(pq.peek() <= startTime && cnt < m){ // 시간이 작고 탈 수 있을 때
                    lastTime = pq.poll()-1; // 꽉차면 맨 마지막 애 -1
                    cnt++;
                }
                else break;

            }
            startTime += t; // 시작시간
        }

        // 대기열이 없거나 자리가 남는다면 시작시간이 제일 늦은 시간( -t : n이 1부터 시작하기 떄문)
        if(cnt < m){
            lastTime = startTime -t;
        }

        String hour = String.format("%02d", lastTime / 60); // 포멧
        String minute = String.format("%02d", lastTime % 60);

        return hour + ":" + minute;

    }


    public static void main(String[] args) {

//        n t m
        String[] timeTable = new String[]{"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        셔틀버스_1차 test = new 셔틀버스_1차();


        String solution = test.solution(10, 60, 45, timeTable);

        System.out.println("solution = " + solution);
    }




}
