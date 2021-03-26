package old.Data20180409;

import java.lang.reflect.Modifier;

public class Candy {
	public static void main(String[] args) {
		int[] a = new int[]{5,3,1};
		int[] b = new int[1];
		Candy c = new Candy();

		System.out.println(new Modifier().isStatic((c.getClass().getModifiers())));
		//candy(a);
	}
    public static int candy(int[] ratings) {
        if(ratings.length == 1)
            return 1;
        int[] num = new int[ratings.length];
        
        for(int i = 0; i < num.length; i++) {
        	num[i] = 1;
        }
        for(int i = 0; i < num.length - 1; i++) {
        	if(ratings[i] < ratings[i + 1]) {
        		num[i + 1] = num[i] + 1;
        	}
        }
        for(int i = num.length - 1; i > 0; i--){
            if(ratings[i - 1] > ratings[i] && num[i - 1] <= num[i]) {
                num[i - 1] = num[i] + 1;
            }
        }
        int sum = 0;
        for(int i = 0; i < num.length; i++) {
        	sum += num[i];
        }
        return sum;
    }
}
