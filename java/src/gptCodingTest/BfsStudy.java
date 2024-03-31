package gptCodingTest;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class BfsStudy {
    static Set<Integer> set;

    public static void main(String args[]) {
        solution("105");
    }

    public static int solution(String numbers) {
        int answer = 0;
        set = new HashSet<>();
        bfs(numbers);
        for (Integer num : set) {
            System.out.println(num);
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }

    public static void bfs(String numbers) {
        Queue<String> queue = new LinkedList<>();
        for (char c : numbers.toCharArray()) {
            queue.offer(String.valueOf(c));
        }

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.length() == 3) {
                set.add(Integer.parseInt(current));
                continue;
            }

            for (char c : numbers.toCharArray()) {
                queue.offer(current + c);
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}


