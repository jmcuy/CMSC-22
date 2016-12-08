import java.util.Arrays;

public class Rule30Threaded {
    int size;
    String cells = "";
    final int THREAD_COUNT = 10;

    public Rule30Threaded(int size) {
        this.size = size;
        if(size > 0){
            char[] arr = new char[size];
            Arrays.fill(arr, '0');
            arr[size / 2] = '1';
            cells = new String(arr);
        }
    }
    public void print(String prev){
        for(int i = 0; i < prev.length();i++){
            System.out.print(prev.charAt(i) + " ");
        }
        System.out.print("\n");
    }
    public void nextGen() throws Exception{
        int numThreads = THREAD_COUNT;
        int start;
        int end;
        if (size < THREAD_COUNT){
            numThreads = size;
        }
        int threadRange = size / numThreads;


        String prev = cells;
        print(prev);
        Threaded[] threads = new Threaded[numThreads];

        for (int i = 0; i < size - 1; i++){
            start = 0;
            for (int t = 0; t < numThreads - 1; t++){
                end = start + threadRange;
                threads[t] = new Threaded(prev, start, end);
                start = end;
            }
            threads[numThreads - 1] = new Threaded(prev, start, size);

            for (int thread = 0; thread < numThreads; thread++){
                threads[thread].start();
            }

            for (int t = 0; t < numThreads; t++){
                if(threads[t].isAlive()){
                    threads[t].join();
                }
            }

            prev = "";
            for (int p = 0; p < numThreads; p++){
                prev += threads[p].getResult();
            }
            print(prev);

        }
    }
}
