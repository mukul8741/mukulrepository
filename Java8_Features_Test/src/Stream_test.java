import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.IntToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public class Stream_test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int j = 0;
//		
//		List<Integer> MyList = new ArrayList();
//		List<String> MyList1 = new ArrayList();
//		
//		for(int i = 0; i<=100; i++) {
//			MyList.add(i);
//		}
//		
//		Stream<Integer> stream = MyList.stream();
//		Stream<Integer> stream2 = stream.filter(i -> i < 50);
//		
//		Stream<String> mapstream = stream.map(s -> {
//			                                if(s%2 == 0) {
//			                                	return (s+" is an even number");
//			                                } else {
//			                                	return (s+" is an odd number");
//			                                }
//			                               
//		});
		
//		MyList1 = mapstream.collect(Collectors.toList());
//		for(String str:MyList1) {
//			System.out.println(str);
		
		/**
		 * Sorting
		 */
		
//      Stream<Integer> stream3 = Stream.of(1,3,6,2,4,5);
//		
//      System.out.println(stream3.sorted(Comparator.reverseOrder() ).collect(Collectors.toList()));		
	
		/**
		 * FlatMap
		 */
		
//		Stream<List<Integer>> straem4 = Stream.of(
//				Arrays.asList(1,2,3,4),
//				Arrays.asList(10,11,12,13),
//				Arrays.asList(21,22,23)
//				);
//		
//		Stream<Integer> streaflatmap = straem4.flatMap(intlist -> intlist.stream());
//		
//		straem4.forEach(i -> System.out.print(i + " "));
	
	    /**
	     * Terminal functions
	     */
		
		/* reduce */
		
//		Stream<Integer> stream = Stream.of(1,2,3,4,5);
//	    
//		Optional<Integer> opt = stream.reduce((i,j) -> {return i+j;});
//		
//		
//		if(opt.isPresent()) {
//			System.out.print(opt.get());
//		}
	
		
		Stream<List<Integer>> stream = Stream.of(
				Arrays.asList(1,2),
				Arrays.asList(3,4));
////		Stream<Integer> stream1 = stream.filter(i -> i >= 3);
//		
//		System.out.print(stream.filter(i -> i%2 == 0 || i > 2 ).collect(Collectors.toList()));


//		Map<Integer,Integer> map = stream.flatMap(strList -> strList.stream()).collect(Collectors.toMap(i -> i, j -> j*10));
//		System.out.print(map);

//		List<Integer> list = stream.flatMap(strList -> strList.stream()).collect(Collectors.toList());
//		IntToLongFunction fun = i -> 1000000 * i; 
//		
//		System.out.print("" + list.get(4));
//		for(int i = 0;i > 0;i++) {
//			if(list.get(i) == null) {
//				break;
//			} else {
//				System.out.println(fun.applyAsLong(list.get(i)));
//			}
//		}
		
		/**
		 * Annomies declaration of functions
		 */
		
		
	}
}



