package exercises;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class roman_numerals {

	public static void main(String[] args) {
//		System.out.println(getRomanNumeralValue("MMMCMXCIX"));
//		System.out.println(getRomanNumeralValue("MMMDCCCLXXXVIII"));
//		System.out.println(getRomanNumeralValue("CMC"));
//		System.out.println(getRomanNumeralValue("CDC"));
//		System.out.println(getRomanNumeralValue("CDXC"));
		System.out.println(getRomanNumeralValue("CMD"));
	}
	
	public static String getRomanNumeralValue(String s) {
		HashMap<String, Integer> numerals = new HashMap<String, Integer>();
        numerals.put("M", 1000);
        numerals.put("D", 500);
        numerals.put("C", 100);
        numerals.put("L", 50);
        numerals.put("X", 10);
        numerals.put("V", 5);
        numerals.put("I", 1);

        String[] roman = s.split("");
        Set<String> restrictedLetters = new HashSet<String>();
        int count = 0;
        
        if (roman.length == 1) {
            return Integer.toString(numerals.get(s));
        } else {
            for (int i = 0; i < roman.length; i++) {
            	count += numerals.get(roman[i]);
            	
            	if (restrictedLetters.contains(roman[i])) {
            		return "Error: Invalid roman numeral. Invalid letter used after subtracted form (e.g.: CMM)";
            	}
            	
                if (i >= 1) { 
                	if (roman[i].equals("M")) {
                		if (!roman[i - 1].equals("M") && !roman[i - 1].equals("C")) {
                			return "Error: Invalid roman numeral '" + roman[i - 1] + "' used before 'M'";
                		} else if (roman[i - 1].equals("C")) {
            				count -= 200;
                			restrict("CM", restrictedLetters);
                		}
                		
	                } else if (roman[i].equals("D")) {
	                	if (!roman[i - 1].equals("M") && !roman[i - 1].equals("C")) {
	                		return "Error: Invalid roman numeral '" + roman[i - 1] + "' used before 'D'";
	                	} else if (roman[i - 1].equals("C")) {
	                		count -= 200;
	                		restrict("CD", restrictedLetters);
	                	}
	                	
	                } else if (roman[i].equals("C")) {
	                	if (roman[i - 1].equals("L") 
	                			|| roman[i - 1].equals("V") 
	                			|| roman[i - 1].equals("I")) {
	                		return "Error: Invalid roman numeral '" + roman[i - 1] + "' used before 'C'";
	                	} else if (roman[i - 1].equals("X")) {
	                		count -= 20;
	                		restrict("XC", restrictedLetters);
	                	}
	                	
	                } else if (roman[i].equals("L")) {
	                	if (roman[i - 1].equals("V") 
	                			||  roman[i - 1].equals("I")
	                			||  roman[i - 1].equals("L")) {
	                		return "Error: Invalid roman numeral '" + roman[i - 1] + "' used before 'L'";
	                	} else if (roman[i - 1].equals("X")) {
	                		count -= 20;
	                		restrict("XL", restrictedLetters);
	                	}
	                	
	                } else if ( roman[i].equals("X")) {
	                	if (roman[i - 1].equals("V")) {
	                		return "Error: Invalid roman numeral. 'V' used before 'X'";
	                	} else if (roman[i - 1].equals("I")) {
	                		count -= 2;
	                		restrict("IX", restrictedLetters);
	                	}
	                	
	                } else if (roman[i].equals("V")) {
	                	if (roman[i - 1].equals("V")) {
	                		return "Error: Invalid roman numeral. 'V' used before 'V'";
	                	} else if (roman[i - 1].equals("I")) {
	                		count -= 2;
	                		restrict("IV", restrictedLetters);
	                	}
	                }
                }
                
                if (i >= 2) {
                	if (roman[i].equals("C")) {
                		if (roman[i - 2].equals("C") && roman[i - 1].equals("M")) {
                			return "Error: Invalid roman numeral, 'C' used after 'CM'";
                		} else if (roman[i - 2].equals("C") && roman[i - 1].equals("D")) {
                			return "Error: Invalid roman numeral, 'C' used after 'CD'";
                		}
                	} else if (roman[i].equals("X")) {
                		if (roman[i - 2].equals("X") && roman[i - 1].equals("C")) {
                			return "Error: Invalid roman numeral, 'X' used after 'XC'";
                		} else if (roman[i - 2].equals("X") && roman[i - 1].equals("L")) {
                			return "Error: Invalid roman numeral, 'X' used after 'XL'";
                		}
                	}
                }
                
                if (i >= 3
                		&& roman[i].equals(roman[i - 1])
                		&& roman[i].equals(roman[i - 2])
                		&& roman[i].equals(roman[i - 3])
                				) {
                    return "Error: Invalid format: Roman numeral " + roman[i] + " repeated 4 times";
                }
            }
        }
        return Integer.toString(count);
	}
	
	public static void restrict (String s, Set<String> set) {
		switch (s) {
		case "CM":
		case "CD":
			set.add("M");
			set.add("D");
			break;
		case "XC":
		case "XL":
			set.add("M");
			set.add("D");
			set.add("C");
			set.add("L");
			break;
		case "IX":
		case "IV":
			set.add("M");
			set.add("D");
			set.add("C");
			set.add("L");
			set.add("X");
			set.add("I");
		}
	}
}
  