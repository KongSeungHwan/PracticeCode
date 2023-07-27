package CodingTest;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class CodingTest02 {
	static int c=0;
	public static void main(String[] args) {
			int[] a = {30, 10, 23, 6, 100};
			int[] b = {};
			c=a.length;
			b=a;
			Map<Integer,Integer> map=Arrays.stream(a)
					.sorted().boxed().collect(Collectors.toMap(h->h,h->c--));
			System.out.println(map);
			for (int i = 0; i < a.length; i++)b[i]=map.get(a[i]);
			Arrays.stream(b).forEach(System.out::println);

	}

}
