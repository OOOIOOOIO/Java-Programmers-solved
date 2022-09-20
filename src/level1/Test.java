package level1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Test {
	
	public static void main(String[] args) throws IOException{
		

		
	}
	
    public static int[] solution(int[] answers) {
        
        
        int length = answers.length;
        
        int[] s1 = {1, 2, 3, 4, 5}; // 5
        int[] s2 = {2, 1, 2, 3, 2, 4, 2, 5}; // 8
        int[] s3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}; // 10
        
        int k1 = 0;
        int k2 = 0;
        int k3 = 0;
        
        int[] cnt = {0, 0, 0};
        
        for(int i = 0; i < length; i++) {
        	
        	if(k1 == 5) k1 = 0;
        	if(k2 == 8) k2 = 0;
        	if(k3 == 10) k3 = 0;

        	
        	if(answers[i] == s1[k1]) cnt[0]++;        		
        	if(answers[i] == s2[k2]) cnt[1]++;        		
        	if(answers[i] == s3[k3]) cnt[2]++;        		
        	
        	
        	
        	k1++;
        	k2++;
        	k3++;
        	
//        	이게 더 보기 깔끔하다
//	    	if(s1[i % s1.length] == answers[i]) cnt[0]++;
//	        if(s2[i % s2.length] == answers[i]) cnt[1]++;
//	        if(s3[i % s3.length] == answers[i]) cnt[2]++;
        }
        
        ArrayList<Integer> list = new ArrayList<Integer>();
        
        int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));
        
        if(max == cnt[0]) list.add(1);
        if(max == cnt[1]) list.add(2);
        if(max == cnt[2]) list.add(3);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++) {
        	answer[i] = list.get(i);
        }
        
        
        return answer;
    }	
}
