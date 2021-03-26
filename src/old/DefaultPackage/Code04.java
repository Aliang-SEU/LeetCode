package old.DefaultPackage;

public class Code04 {
	public static String convert(String s, int numRows) {
		char[] str = s.toCharArray();
		StringBuffer[] sb = new StringBuffer[numRows];
		for(int i = 0; i < sb.length; ++i) {
			sb[i] = new StringBuffer();
		}
		int i = 0;
		while(i < str.length) {
			for(int j = 0; j < numRows && i < str.length; ++j)
				sb[j].append(str[i++]);
			for(int j = numRows - 2; j >= 1 && i < str.length; --j)
				sb[j].append(str[i++]);
		}
		StringBuffer result = new StringBuffer();
		for(int j = 0; j < numRows; ++j) {
			result.append(sb[j]);
		}

        return result.toString();
    }
	public static void main(String[] args) {
		System.out.println(convert("PAYPALISHIRING",3));
	}
}
