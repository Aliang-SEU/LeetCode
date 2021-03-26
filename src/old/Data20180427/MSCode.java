package old.Data20180427;

public class MSCode {
    public static void main(String[] args) {
        String s = "aab";
        boolean flag = isChinese(s);
        int[] a = new int[256];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i)] += 1;
        }
        for (int i = 0; i < s.length(); i++) {
            if (a[s.charAt(i)] == 1)
                System.out.println(s.charAt(i));
        }

    }
    public static boolean isChinese(String str) {
        if (str == null) return false;
        for (char c : str.toCharArray()) {
            if (isChinese(c)) return true;// 有一个中文字符就返回
        }
        return false;
    }
    public static boolean isChinese(char c) {
        return c >= 0x4E00 &&  c <= 0x9FA5;// 根据字节码判断
    }
}
