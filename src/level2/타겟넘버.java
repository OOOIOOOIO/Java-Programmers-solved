package level2;

public class 타겟넘버 {

    int cnt = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);


        return cnt;
    }


    public void dfs(int[] numbers, int target, int depth, int sum){
        if(numbers.length == depth){ // 종료
            if(sum == target) cnt++;




            return;
        }

        dfs(numbers, target, depth+1, sum + numbers[depth]);
        dfs(numbers, target, depth+1, sum - numbers[depth]);
    }

}
