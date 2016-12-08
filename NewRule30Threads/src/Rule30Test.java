import java.util.Scanner;

/**
 * Created by thegi on 08/12/2016.
 */
public class Rule30Test {
    public static void main(String[] args) throws Exception {
        System.out.print("Enter Row/Col size: ");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();

        long currentTime = System.currentTimeMillis();
        System.out.print("=============NON-THREADED==============\n");
        Rule30 r30 = new Rule30(size);
        r30.print();
        for (int i = 1; i < size; i++) {
            r30.nextGen();
            r30.print();
        }
        long end = System.currentTimeMillis() - currentTime;
        System.out.print("NON-THREADED: " + end + "ms");

        System.out.print("\n=============THREADED==============\n");
        long currentTime2 = System.currentTimeMillis();
        Rule30Threaded rt = new Rule30Threaded(size);
        rt.nextGen();
        long end2 = System.currentTimeMillis() - currentTime2;
        System.out.print("THREADED: " + end2 + "ms");


        System.out.print("\n================DIFFERENCE==============\n");
        if(end < end2){
            System.out.println("\nNON-THREADED IS FASTER BY: " + Long.toString(end2 - end) + "ms");
        } else {
            System.out.println("\nTHREADED IS FASTER BY: " + Long.toString(end - end2));
        }

    }
}
