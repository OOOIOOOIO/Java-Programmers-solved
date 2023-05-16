package level2;

public class 연속된부분수열의합_투포인터 {

    public static void main(String[] args) {
        int[] sequence = new int[]{1, 2, 3, 4, 5};
        int k = 7;

        int[] solution = solution(sequence, k);

        for (int i : solution) {
            System.out.println("i = " + i);
        }
    }

    public static int[] solution(int[] sequence, int k) {

        int startIdx = 0;
        int endIdx = 0;
        int left = 0;
        int right;
        int sum = 0;
        int length = sequence.length;

        for(right = 0; right < sequence.length; right++){
            sum += sequence[right];

            // 더 클 경우 왼쪽 포인터 이동
            while(sum > k){
                sum -= sequence[left];
                left++;
            }

            // 같을 경우
            if(sum == k){
                // 길이 비교
                // 초기
                if(length > right - left){
                    length = right - left;
                    startIdx = left;
                    endIdx = right;
                }
                else if (length == right - left) { // 길이가 같을 경우
                    // 시작 인덱스 비교
                    startIdx = Math.min(startIdx, left);
                    endIdx = Math.min(endIdx, right);
                }
            }


        }
        return new int[]{startIdx, endIdx};
    }

}
