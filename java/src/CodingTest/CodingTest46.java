package CodingTest;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class CodingTest46 {
    static Set<Integer> set;
    static boolean[] visited = new boolean[5];
    public static void main(String args[]){
        System.out.println(solution("10957"));
    }
    public static int solution(String numbers){
        int answer = 0;
        set = new HashSet<>();
        dfs(numbers,"",0);
        for(Integer n : set){
            if(isPrime(n)) {
                System.out.println(n);
                answer++;
            }
        }
        return answer;
    }
    public static boolean isPrime(int n){
        if(n<2) return false;

        for(int i = 2; i<=(int)Math.sqrt(n);i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public static void dfs(String numbers, String s, int depth){
        if(depth > numbers.length()) return;

        IntStream.rangeClosed(0,numbers.length()-1).boxed().forEach(e->{
            if(!visited[e]){
                visited[e] = true;
                set.add(Integer.parseInt(s+numbers.charAt(e)));
                dfs(numbers,s+numbers.charAt(e),depth+1);
                visited[e] = false;
            }
        });
    }
}

