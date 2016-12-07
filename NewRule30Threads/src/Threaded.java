/**
 * Created by thegi on 08/12/2016.
 */
public class Threaded extends Thread {
    String prev;
    int start, end;
    String next = "";
    String[] ruleSet = {"0","1","1","1","1","0","0","0"}, edgeSet = {"0","1","1","1"};

    public Threaded(String prev, int start, int end){
        this.prev = prev;
        this.start = start;
        this.end = end;
    }


    public String rules(String s){
        int index = Integer.parseInt(s,2);
        return ruleSet[index];
    }
    public String edgerules(String s){
        int index = Integer.parseInt(s, 2);
        return edgeSet[index];
    }


    public void run(){
        for(int i = start; i < end ; i++){
            if(i == 0){
                next += edgerules(prev.substring(i, i + 2));
            }
            if(i == prev.length() - 1){
                next +=  edgerules(prev.substring(prev.length() - 2));
            }
            if(i > 0 && i < prev.length() - 1){
                next += rules(prev.substring(i - 1, i + 2));
            }
        }
        prev = next;
    }

    public String getResult(){
        return prev;
    }
}
