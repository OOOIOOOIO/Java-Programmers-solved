import java.util.*;

class Solution {
    public int solution(int[] ingredient) {
        ArrayList<Integer> temp = new ArrayList();
        int result = 0;

        // 받아옴
        for (int i=0; i<ingredient.length; i++) {
          
            temp.add(ingredient[i]);
            
            // 길이가 4 이상일 경우에만
            if (temp.size()>=4){
                // 1 2 3 1 검사
                if(temp.get(temp.size()-4)==1 && temp.get(temp.size()-3)==2 && temp.get(temp.size()-2)==3 && temp.get(temp.size()-1)==1) {

                    result++;
                  
                    // 삭제
                    for(int j=0; j<4; j++) {
                        temp.remove(temp.size()-1); // 실시간으로 줄어드니 -1
                    }
                }

            }
        }
        
        return result;
    }
}
