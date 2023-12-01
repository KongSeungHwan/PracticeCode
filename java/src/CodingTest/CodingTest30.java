package CodingTest;

public class CodingTest30 {
    public static void main(String[] args) {
        int[] date1= {2021, 12, 28};
        int[] date2= {2021, 12, 29};
        int result =0;
        if(date1[0] != date2[0]){
            result= date1[0] < date2[0] ? 1 : 0;
        }
        if(date1[1] != date2[1]) {
            result= date1[1] < date2[1] ? 1 : 0;
        }
        if(date1[2] != date2[2]) {
            result= date1[2] < date2[2] ? 1 : 0;
        }
        System.out.println(result);
    }
}
