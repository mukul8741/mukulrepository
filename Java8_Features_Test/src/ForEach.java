import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//interface phone {
//    void call(int i);
////	System.out.println("Making a Call") {
//		
////		List<Integer> values = Arrays.asList(1,2,3,4);
////		
////		values.forEach(i -> System.out.println("i => "+i));
//	 
////	void show();
//	
//	static void reject() {
////		System.out.println("Rejecting a Call");
//		
//		LocalTime t = LocalTime.now();
//		System.out.println(t);
//		
////		LocalDate d = LocalDate.now();
////		System.out.println(d);
//		
//		LocalDateTime dt = LocalDateTime.now(ZoneId.of("Asia/Aden"));
//		System.out.println(dt);
//	}
//	
// }

public class ForEach {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		phone obj;
//		
//		obj = (o) -> System.out.println("Making a Call " + o);
//		obj.call(50);
//		phone.reject();
		
		Stream<Integer> stream = Stream.of(1,2,3,4);
		Stream<Integer> stream2 = Stream.of(new Integer[] {1,2,3,4});
	    Stream<String> stream3 = Stream.iterate("abc", (i) -> i);
		
		List<String> strList = stream3.collect(Collectors.toList());
		
//		for(String i:strList) {
			stream2.forEach(p -> System.out.println(p));
//		}
	}

} 
