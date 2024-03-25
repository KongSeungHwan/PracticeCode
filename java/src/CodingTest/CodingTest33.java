public class CodingTest33{
    public static void main(String args[]){
        int[][] arr ={{5, 192, 33}, {192, 72, 95}, {33, 95, 999}};
        int[][] arr2 = {{19, 498, 258, 587}, {63, 93, 7, 754}, {258, 7, 1000, 723}, {587, 754, 723, 81}};
        System.out.println(IntStream.rangeClosed(0,arr.length-1).boxed().allMatch(i->IntStream.rangeClosed(0, arr.length-1).boxed().allMatch(j->arr[i][j] ==arr[j][i])));
        int n = 3;
        int[][] array=IntStream.range(0, n).mapToObj(i -> IntStream.range(0, n).map(j -> i == j ? 1 : 0).toArray()).toArray(int[][]::new);
        String[] strArr ={"a","bc","d","efg","hi"};

        String str = "adfcwaaawfawfawfawfawfsdafsvsahbtgdfbh";
        System.out.println(Arrays.stream(strArr)
                .collect(Collectors.toMap(a->a.length(),a->1,(x,y)->x+=y)).entrySet().stream().min(Map.Entry.comparingByValue(Integer::compareTo)).get().getValue());
        //map 안의 최대값 구하기
        int[] intArr ={1, 1, 1};
        System.out.println("------------------------------");
        int[] c = IntStream.rangeClosed(0,intArr.length-1).boxed().filter(e->intArr[e]==2).mapToInt(Integer::intValue).toArray();
        System.out.println((c.length==0)? new int[]{-1}:IntStream.rangeClosed(c[0],c[c.length-1]).boxed().map(e->intArr[e]).toArray());
        //2가 모두 포함된 부분집합 중 제일 길이가 작은 배열 리턴 없으면 [-1] 배열 리턴

        /*IntStream.rangeClosed(min,max)
                .boxed().map(s->intArr[s]).forEach(System.out::println);*/


        //이차원 배열 쿼리 처리
    }
}