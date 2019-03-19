
public class TestPattern {
	
	public String nextPattern(String pattern) {
		
		int i,j = -1;
		int character = 0;
		int length;
		
		String temp = "";
		String tempSubPattern;
		
		String subPattern = "";
		int intSubPattern = 0;
		
		
		
		for(i=1; i<=3; i++) {
			try {
				
				subPattern = pattern.substring(i);
				
				intSubPattern = Integer.parseInt(subPattern);
												
				tempSubPattern = "" + (intSubPattern + 1);
								
				length = tempSubPattern.length();
				
				if(4-i-length != 0) {
					
				  for(j=0; j < (4-i-length); j++) {
					  tempSubPattern = "0" + tempSubPattern;
				  }
				} else {
					
				}
				
				if(tempSubPattern.length() > Integer.toString(intSubPattern).length() && Integer.toString(intSubPattern).charAt(0) == '9') {
					
					character = pattern.charAt(i-1);
					
					if((char) character == 'Z') {
						temp = pattern.substring(0, i) + "A";
						
					} else {
						temp = pattern.substring(0, i-1) + (char) ++character;
					}
					

					for(j=0; j < (pattern.length() - temp.length()); j++) {
						temp = temp + "0";
					}
					 
					if(4-i-length == 0) {
						temp = temp + "0";
					}
					break;
					
				} else {
					
					temp = pattern.substring(0,i) + tempSubPattern;
					break;
				}
				
				
			}catch(Exception e) {
				if(i==3 && pattern.charAt(3) == 'Z') {
					
					System.out.println("Cannot increment Further");
					break;
					
				} else if (i == 3) {
					
					character = pattern.charAt(3);
					
					temp = pattern.substring(0,3) + ((char) ++character);
					break;
					
				}
				continue;
			}
		}
		
		return temp;
		
	}

	public static void main(String[] args) {
		
		TestPattern obj = new TestPattern();
		String pattern = "A000";
		try {
			
			while (pattern != "ZZZZ")
			{
				pattern = obj.nextPattern(pattern);
				System.out.println(pattern);
			}
		
		}catch(Exception e) {
			
		}
		
	}
  
}
