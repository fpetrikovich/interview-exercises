import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {
    private List<String> res = new LinkedList<>();

    public List<String> generateParenthesis(int n) {
        dfs("", 0, 0, n);
        return res;
    }

    private void dfs(String curr, int open, int close, int n) {
        // String is finished
        if (curr.length() == n * 2) res.add(curr);

        if (open < n) dfs(curr + "(", open + 1, close, n);
        if (close < open) dfs(curr + ")", open, close + 1, n);
    }

    /**
     public List<String> generateParenthesis(int n) {

     List<String> res  = new ArrayList();

     genResult(res,"",n,n);

     return res;
     }

     public void genResult(List<String> res, String str, int open, int close){
     if(open==0 && close==0){
     res.add(str);
     return;
     }

     if(open>0 && open<=close){
     genResult(res,str+'(',open-1,close);
     }
     if(close>0){
     genResult(res,str+')',open,close-1);
     }
     }
     */
}
