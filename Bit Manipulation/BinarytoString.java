/*
5.2 Binary to String: Given a real number between 8 and 1 (e.g., 0.72) that is passed in as a double,
print the binary representation. If the number cannot be represented accurately in binary with at
most 32 characters, print "ERROR:'
*/

/*
Approach:
1. r = num * 2. 
2. if r>1: num = r-1 and record 1
	else: record 0 and num=r;
3. repeat 2 until num>0	
*/
import java.util.*;

class BinarytoString{
	String printBinary(double num){
		if (num>=1 || num<=0){
			return "ERROR";
		}

	StringBuilder sb = new StringBuilder();
	sb.append(".");
	System.out.println(sb.toString());
	while (num>0){
		System.out.println("num "+num+" binary "+sb);
		if (sb.length()>=32){
			return "ERROR";
		}
		double r = num*2;
		if (r>=1){
			sb.append(1);
			num = r-1;
		}else {
			sb.append(0);
			num = r;
		}
	}
	return sb.toString();
	}

	public static void main(String[] args){
		String s = new BinarytoString().printBinary(0.75);
		System.out.println(s);
	}

}