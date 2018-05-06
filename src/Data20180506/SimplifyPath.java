package Data20180506;

import java.util.LinkedList;

public class SimplifyPath {

    public static void main(String args[]){
        String str = "/..";
        System.out.println(new SimplifyPath().simplifyPath(str));

    }
    public String simplifyPath(String path){
        LinkedList<String> res = new LinkedList<>();
        String[] temp = path.split("/");

        for(String name : temp){
            if(name.equals(".") || name.equals(""))
                continue;
            else if(name.equals("..")) {
                if (!res.isEmpty())
                    res.removeLast();
            }
            else
                res.add(name);
        }

        StringBuilder result = new StringBuilder();
        for(String name : res){
            result.append("/");
            result.append(name);
        }

        return result.toString().equals("") ? "/" : result.toString();
    }
    public String simplifyPath1(String path){
        int i = 0;
        int j = 0;
        StringBuilder sb = new StringBuilder();
        while(true){
            if(i == -1)
                break;
            j = path.indexOf('/', j + 1);
            String subString = (j == -1) ? path.substring(i) : path.substring(i, j);
            if(subString.equals("/.")){
                i = j;
                continue;
            }else if(subString.equals("/..")){
                int idx = sb.lastIndexOf("/");
                if(idx != -1) {
                    sb = new StringBuilder(sb.substring(0, idx));
                }
                i = j;
                continue;
            }else if(subString.equals("/")){
                i = j;
                continue;
            }
            sb.append(subString);
            i = j;
        }
        return sb.toString().equals("") ? "/" : sb.toString() ;
    }

}
