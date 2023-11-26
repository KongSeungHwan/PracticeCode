package CodingTest;

public class CodingTest26 {
    public static void main(String[] args) {
        int[] numLog = {0, 1, 0, 10, 0, 1, 0, 10, 0, -1, -2, -1};
        String control = "";
        for(int i = 1; i < numLog.length; i++){
            if(numLog[i] - numLog[i - 1] == 1)
                control += 'w';
            else if(numLog[i] - numLog[i - 1] == -1)
                control += 's';
            else if (numLog[i] - numLog[i - 1] == 10)
                control += 'd';
            else
                control += 'a';
        }
        System.out.println(control);
    }
}
