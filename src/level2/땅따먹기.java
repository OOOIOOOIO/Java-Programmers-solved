package level2;

import java.util.Arrays;

public class 땅따먹기 {
	
	
	public static void main(String[] args) {
		int[][] land = {{1,2,3,5},{5,6,7,8},{4,3,2,1}};
		
		System.out.println(solution(land));
	}
	
	public static int solution(int[][] land) {
		
		// bottom-up
		for(int i = 1; i < land.length; i++) {
			land[i][0] = land[i][0] + Math.max(Math.max(land[i-1][1], land[i-1][2]), land[i-1][3]);
			land[i][1] = land[i][1] + Math.max(Math.max(land[i-1][0], land[i-1][2]), land[i-1][3]);
			land[i][2] = land[i][2] + Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][3]);
			land[i][3] = land[i][3] + Math.max(Math.max(land[i-1][0], land[i-1][1]), land[i-1][2]);
		}
		
		// 마지막 행에 각 열의 최대값이 들어있다.
		int[] arr = land[land.length-1];
		
		Arrays.sort(arr);
		
		int answer = arr[3];
		
		return answer;
	}
}
