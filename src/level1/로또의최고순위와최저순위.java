package level1;

public class 로또의최고순위와최저순위 {
	public static void main(String[] args) {
		
		int[] lottos = {1, 2, 3, 4, 5, 6};
		int[] win_nums = {1, 2, 3, 4, 5, 6};
		
		
		int[] result = solution(lottos, win_nums);
		
		for(int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
	
	 public static int[] solution(int[] lottos, int[] win_nums) {
	        int[] answer = {};
	        
	        int zeroCnt = 0;
	        int corrCnt = 0;
	        
	        
	        // Arrays.sort(win_nums);
	        // Arrays.binarySearch(배열, target) >= 0 -> 있다 / 음수 -> 없다
	        
	        for(int i = 0; i < win_nums.length; i++){
	            if(lottos[i] == 0){
	                zeroCnt++;
	                continue;
	            } 
	            
	            for(int j = 0; j < win_nums.length; j++){
	                if(lottos[i] == win_nums[j]){
	                    corrCnt++;
	                }
	            }

	        }
	        
	        // 0이 없을 때 -> corrCnt가 최고, 최저
	        if(zeroCnt == 0){
	            if(corrCnt > 1){
	                answer = new int[]{6 - corrCnt + 1, 6 - corrCnt + 1};    
	            }
	            else{
	                answer = new int[]{6, 6};
	            }
	            
	           
	        }
	        // 0이 있을 때 -> corrCnt가 최저, zeroCnt를 더한 값이 최고
	        else{
	            if(corrCnt > 1){            
	                
	                answer = new int[]{6 - (corrCnt + zeroCnt) + 1, 6 - corrCnt + 1};
	            }
	            else{

	                answer = new int[]{6 - (corrCnt + zeroCnt) +1, 6};  
	               
	            }
	        }
	        
	        return answer;
	    }
}
