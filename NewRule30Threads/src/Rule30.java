import java.util.Scanner;

/**
 * Created by thegi on 08/12/2016.
 */
public class Rule30 {
    int size;
    String cells = "";
    String[] ruleSet = {"0","1","1","1","1","0","0","0"}, edgeSet = {"0","1","1","1"};

    public Rule30(int size){
        this.size = size;
        for(int i = 0; i < size; i++){
            if(i == size / 2){
                cells += "1";
            } else {
                cells += "0";
            }
        }
    }
    public String rules(String s){
        int index = Integer.parseInt(s,2);
        return ruleSet[index];
    }
    public String edgerules(String s){
        int index = Integer.parseInt(s, 2);
        return edgeSet[index];
    }

    public void nextGen(){
        String next = "";
        for(int i = 0; i < size ; i++){
            if(i == 0){
               next += edgerules(cells.substring(i, i + 2));
            }
            if(i == size - 1){
                next +=  edgerules(cells.substring(size - 2));
            }
            if(i > 0 && i < size - 1){
                    next += rules(cells.substring(i - 1, i + 2));
            }
        }
        cells = next;
    }
    public void print(){
        for(int i = 0; i < size;i++){
            System.out.print(cells.charAt(i) + " ");
        }
        System.out.print("\n");
    }


}
