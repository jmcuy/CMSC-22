/**
 * Created by thegi on 08/12/2016.
 */
public class Rule30Threaded {
    int size;
    String cells = "";
    final int THREAD_COUNT = 10;

    public Rule30Threaded(int size) {
        this.size = size;
        for(int i = 0; i < size; i++){
            if(i == size / 2){
                cells += "1";
            } else {
                cells += "0";
            }
        }
    }
    public void print(String prev){
        for(int i = 0; i < prev.length();i++){
            System.out.print(prev.charAt(i) + " ");
        }
        System.out.print("\n");
    }
    public void nextGen(){
        int numThreads = THREAD_COUNT;
        if (size < THREAD_COUNT){
            numThreads = size;
        }
        int range = size / numThreads;
        String prev = cells;
        print(prev);
        Threaded[] threads = new Threaded[numThreads];
        int start;
        for (int i = 0; i < size - 1; i++){
            start = 0;
            for (int t = 0; t < numThreads - 1; t++){
                threads[t] = new Threaded(prev, start, start + range);
                start = start + range;
            }
            threads[numThreads - 1] = new Threaded(prev, start, size);

            for (int s = 0; s < numThreads; s++){
                threads[s].start();
            }

            for (int j = 0; j < numThreads; j++){
                while (threads[j].isAlive()){
                    try{
                        threads[j].join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            prev = "";
            for (int r = 0; r < numThreads; r++){
                prev += threads[r].getResult();
            }
            print(prev);

        }
    }
}
