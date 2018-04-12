package DefaultPackage;
import java.util.Queue;
import java.util.Scanner;
import java.util.LinkedList;

public class Code02 {
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int str = sc.nextInt();
		Code02 ob = new Code02();
		System.out.println(ob.reverseInt(str));
	}
	
	public int reverseInt(int x){
		/*if(x>Integer.MAX_VALUE || x<Integer.MIN_VALUE)
			return 0;*/
		Queue<Integer> queue = new LinkedList<>();
		Integer mod = x % 10;
		while(x!=0){
			queue.offer(mod);
			x = x /10;
			mod = x % 10;
		}
		int ans=0;
		while(!queue.isEmpty()){
			int temp =  queue.poll();
			long templong = ans*10 + temp;
			if(templong >Integer.MAX_VALUE || templong<Integer.MIN_VALUE){
				ans = 0; 
				break;
			}
			ans = ans*10 + temp;;
		}
		return ans;
	}
    public int romanToInt(String s) {
        int n = s.length();
        int ans = getRomanNum(s.charAt(0));

        for(int i=1; i<n; ++i){
        	if(getRomanNum(s.charAt(i-1)) < getRomanNum(s.charAt(i)))
        		ans += getRomanNum(s.charAt(i)) - 2* getRomanNum(s.charAt(i-1));
        	else 
        		ans += getRomanNum(s.charAt(i));
        }
        return ans;
    }
    public int getRomanNum(int i){
        switch(i){
            case 'I': return 1;  
            case 'V': return 5;  
            case 'X': return 10;  
            case 'L': return 50;  
            case 'C': return 100;  
            case 'D': return 500;  
            case 'M': return 1000;  
        }
        return 0;
    }
}
