package CodingTest;

public class CodingTest32 {
    public static void main(String args[]){
        int a =3;
        int d = 4;
        boolean[] included = {true, false, false, true, true};

        System.out.println(IntStream.rangeClosed(0,included.length-1).boxed().filter(n-> included[n]).map(e-> a+e*d)
                .collect(Collectors.summingInt(s->s)));

        //등차수열 각 항이 true 인 친구들 합

        String my_string = "people";
        System.out.println(Arrays.stream(my_string.split("")).distinct().collect(Collectors.joining()));
        //중복 문자 제거
        my_string = "apporoograpemmemprs";
        List<String> strArr = Arrays.asList(my_string.split(""));
        int[] indices = {1, 16, 6, 15, 0, 10, 11, 3};
        System.out.println(IntStream.rangeClosed(0,strArr.size()-1).filter(e->!Arrays.stream(indices).boxed().collect(Collectors.toList()).contains(e))
                .mapToObj(ind->strArr.get(ind)).collect(Collectors.joining()));
        //문자 지우고 이어붙이기


        int[] num_list = {12, 4, 15, 1, 14};

        int c =Arrays.stream(num_list).map(e->{int count = 0;while(e!=1){e/=2;count++;}return count;}).sum();
        Arrays.stream(num_list).forEach(System.out::println);
        //연산 수
        String str ="Progra21Sremm3";
        int s = 6;
        int e = 12;
        System.out.println(IntStream.rangeClosed(0,str.split("").length-1)
                .boxed()
                .map(ind->str.split("")[(ind>=s&&ind<=e)?s+e-ind:ind])
                .collect(Collectors.joining()));
        //뒤집기

        int[] date1= {2023, 12, 28},date2=	{2024, 01, 02};
        int[] flag = IntStream.rangeClosed(0,date1.length-1).boxed().mapToInt(r-> date1[r]>date2[r]?1:date1[r]==date2[r]?0:-1)
                .filter(y->y!=0).toArray();

        System.out.println(flag.length!=0?(flag[0]==1)?1:0:0);

        //앞서는 날짜인지 아닌지 판별 로직
//        String myString= "banana";
//        String pat = "ana";
        String myString="aaaa";
        String pat =  "aa";

        System.out.println((int)IntStream
                .rangeClosed(0,myString.length()-pat.length())
                .filter(f-> myString.substring(f,f+pat.length()).equals(pat)).count());

        //문자 패턴이 몇번 등장하는가 판별하는 로직
        int[] array ={7, 77, 17};
        System.out.println(Arrays.stream(array).mapToObj(y-> Arrays.stream(String.valueOf(y).split("")).filter(i->i.equals("7")).count()).collect(Collectors.summingInt(k->k)));
        //7이 몇번 등장하는가 리턴하는 로직
    }
}