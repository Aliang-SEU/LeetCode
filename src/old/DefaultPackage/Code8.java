package old.DefaultPackage;
import java.util.HashMap;
import java.util.Map;
public class Code8 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length / 2;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < array.length; i++){
            if(map.containsKey(array[i])) {
            	int count = map.get(array[i]);
            	if(count+1 > len)
            		return array[i];
            	else
            		map.put(array[i], map.get(array[i]) + 1);
            	}
            else 
            	map.put(array[i], 1);
                
        }
        return 0;
    }
}