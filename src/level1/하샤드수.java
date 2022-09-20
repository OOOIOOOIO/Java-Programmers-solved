package level1;

public class 하샤드수 {
	public static void main(String[] args) {
		int x = 13;
		
		boolean answer = false;
        int sum = 0;
        int temp = x;
        
        if(x < 10){
            sum = x;
        }
        else {
        	while(temp != 0){
        		int r = temp / 10;
        		int q = temp % 10;
        		
        		temp = r;
        		sum += q;
        		
        	}    
        }
        
            
        if(x % sum == 0){
        	answer = true;
        }
        else {
        	answer = false;
        }
        
        System.out.println(x % sum);
        System.out.println(sum);
        System.out.println(answer);
	}
}
