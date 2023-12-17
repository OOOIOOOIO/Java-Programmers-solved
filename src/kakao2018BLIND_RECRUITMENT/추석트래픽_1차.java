package kakao2018BLIND_RECRUITMENT;

import java.text.SimpleDateFormat;
import java.util.*;
public class 추석트래픽_1차 {

    public static int solution(String[] lines) throws Exception {
        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");

        int[] counts = new int[lines.length];
        int max = 0;

        for(int i=0; i<lines.length; i++) {
            // 이전 로그의 완료 시점
            String[] pre = lines[i].split(" ");
            Date preEndDate = format.parse(pre[1]);
            long preEnd = preEndDate.getTime();

            // 해당 로그 보다 늦게 종료되는 로그 체크
            for (int j = i ; j < lines.length; j++) {
                // 다음 로그의 시작시점
                String[] next = lines[j].split(" ");
                Date nextEndDate = format.parse(next[1]);
                double sec = Double.parseDouble(next[2].substring(0, next[2].length()-1)); // 처리 시간

                // 다음로그의 종료시점 - 처리 초 + 1;
                // 문제에서 보면 알듯 2016-09-15 01:00:07.000 2s는
                // 01:00:05.001 ~ 01:00:07.000에서 2초 동안 처리된다.
                // 7,000 - 2,000 + 1 = 5.001
                long nextStart = (long) (nextEndDate.getTime() - sec*1000 + 1);

                // 이전 로그의 종료시점부터 + 1초 범위안에 시작되면 + 1
                // 1부터 10의 범위를 가진다고 하면
                // 1 2 3 4 5 6 7 8 9 10 이렇게 가진다.
                // 1 + 10 = 11 이므로 = 부호를 사용하면 안됨
                if(preEnd + 1000 > nextStart) {
                    counts[i] += 1;
                    max = Math.max(max, counts[i]);
                }
            }
        }
        return max;
    }


    class Traffic {
        int start;
        int end;
        Traffic(int start, int end){
            this.start = start;
            this.end = end;
        }
    }
    public int solution2(String[] lines) {
        int answer = 0;
        List<Traffic> t_list = new ArrayList();
        for(int i = 0; i < lines.length; i++) {
            int end =(int)((Integer.parseInt(lines[i].substring(11,13)) * 3600
                    + Integer.parseInt(lines[i].substring(14,16)) * 60) * 1000
                    + Double.parseDouble(lines[i].substring(17,23)) * 1000);
            int treat_time = (int)(Double.parseDouble(lines[i].substring(24, lines[i].length() - 1)) * 1000);
            int start = end - treat_time + 1;
            t_list.add(new Traffic(start, end));
        }
        int max = 1;
        int cnt;
        for(int i = 0; i < t_list.size(); i++) {
            cnt = 1;
            for(int j = i + 1; j < t_list.size(); j++){
                if(t_list.get(i).end + 1000 > t_list.get(j).start)
                    cnt++;
            }
            if(max < cnt)
                max = cnt;
        }
        answer = max;
        return answer;
    }

    public static void main(String[] args) {
        String s = "111";
        String[] lines = new String[]{
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"
        };
    }

}
