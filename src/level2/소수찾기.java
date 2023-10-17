package level2;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class 소수찾기 {
    public static void main(String[] args) {
        Set<Integer> integerSet = new HashSet<>();
        System.out.println(Set.of());
        System.out.println(Set.of(1));
        System.out.println(Set.of("dd"));

    }
    public int solution(String numbers){
        Set<Integer> primes = new HashSet<>();

        List<Integer> collect = numbers.chars()
                .map(c -> c - '0')
                .boxed() // wrapper class로 변환
                .collect(Collectors.toList());

        int[] nums = numbers.chars().map(c -> c - '0').toArray();
        boolean[] isUsed = new boolean[nums.length];

        getPrimes(0 ,nums, isUsed, primes);


        return 0;
    }

    public boolean isPrime(int n){
        if(n <= 1) return false;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(n % i == 0) return false;
        }

        return true;
    }

    public void getPrimes(int acc, int[] numbers, boolean[] isUsed, Set<Integer> primes){

        if(isPrime(acc)) primes.add(acc); // 소수면 여기서 추가

        for(int i = 0; i < numbers.length; i++){
            if(isUsed[i]) continue;

            int nextNum = acc * 10 + numbers[i];

            isUsed[i] = true;
            getPrimes(nextNum, numbers, isUsed, primes);
            isUsed[i] = false;

        }

    }


}
