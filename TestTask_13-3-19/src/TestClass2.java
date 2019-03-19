
public class TestClass2 {
	
	public String nextPattern(String pattern) {
		int check,i,j,k,chr;
		
		int temp1 = 0;
		
		String temp1String = null;
		
		char c;
		
		String firstSubString = null;
		String secondSubstring = null;
		
		
		
		for(i = 0; i<pattern.length();i++) {
			
			check = pattern.charAt(i);
			if(check>=65 && check<=90) 
				continue;
			else {
				firstSubString = pattern.substring(0, i);
				secondSubstring = pattern.substring(i);
				break;
			}
		}
		
		if(secondSubstring != null) {
			for(j=(secondSubstring.length()-1); j>=0 ; j--) {
				c = secondSubstring.charAt(j);
				if(secondSubstring.charAt(j) == '9') {
					continue;
				} else {
					temp1 = Integer.parseInt(secondSubstring) + 1;
					break;
				}
			}
			
			if(temp1 != 0) {
				temp1String = Integer.toString(temp1);
				
				if(Integer.toString(temp1).length() < 4 - firstSubString.length()) {
					
					for(k=0; k < (4 - firstSubString.length() - Integer.toString(temp1).length());k++) {
						temp1String = "0" + temp1String;
					}
				}
				
				return firstSubString + temp1String;
				
			} else {
				for(k = (firstSubString.length()-1);k>=0;k--) {
					c = firstSubString.charAt(k);
					
					if(c == 'Z') {
						if(k == 0) {
							temp1String = firstSubString + "A";
							
							int temp1Length = temp1String.length();
							for(j=0;j<(4-temp1Length);j++) {
								temp1String = temp1String + "0";
							}
							
							return temp1String;
						} else {
							continue;
						}
						
					} else {
						chr = c;

						chr++;
						
						if(firstSubString.length()-1 == 0) {
							temp1String = "" + ((char) chr);
						} else {
							
							try {
								temp1String = firstSubString.substring(0, k) + ((char) chr) + firstSubString.substring(k+1);
//								System.out.println(temp1String);
							}catch(Exception e) {
								temp1String = firstSubString.substring(0, k) + ((char) chr);
							}
							
						}
						
						int temp1Length = temp1String.length();
						for(j=0;j<(4-temp1Length);j++) {
							temp1String = temp1String + "0";
						}
						
						return temp1String;
						
						
					}
				}
				
				
			}
		}
		return "ZZZZ"; 
		
	}
	
	public static void main(String[] args) {
		
		TestClass2 obj = new TestClass2();
		
		String pattern = "AZ00";
		
		while(!(pattern.equals("ZZZZ"))) {
			System.out.println(pattern);
			pattern = obj.nextPattern(pattern);
		}
		
		System.out.println("ZZZZ");
	}
  
}
