import java.util.*;

class Regex {
	public static void main(String[] args){
		String num="123456789";
		int target = 100;
		List<String> res = addOperator(num,target);
		System.out.println(res.size());
	}

	public static List<String> addOperator(String num, int target){
		List<String> result = new ArrayList<String>();
		if (num.length()==0){
			return result;
		}
		dfs(num, target, 0,"",0,0,result);
		return result;
	}

	public static void dfs(String num, int target, int pos,String exp, long temp_sum, long last, List<String> res){
		
		if (pos==num.length()){
			if (temp_sum==target && !res.contains(exp)){
				res.add(exp);
				System.out.println(exp);
			}
		}

		for (int i =pos;i<num.length();i++){
			long x = Long.valueOf(num.substring(pos,i+1));
			if (pos==0){
				dfs(num, target, i+1, exp+x, x, x, res);
			}else{
				dfs(num, target, i+1, exp+"*"+x, temp_sum-last+last*x, last*x,res);
				dfs(num, target, i+1, exp+"-"+x, temp_sum-x,-x,res);
				dfs(num, target, i+1, exp+"+"+x, temp_sum+x, x,res);
			}
			if (x==0){
				break;
			}
		}
	}
}