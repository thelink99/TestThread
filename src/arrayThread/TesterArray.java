package arrayThread;

import com.vemanuele.Tester;

public class TesterArray implements Runnable{

    private static final int SIZE = 1000000;
    private static int[] array = new int[SIZE];
    private static int start;
    private static int offset;

    public TesterArray(int start, int offset){

        this.start = start;
        this.offset = offset;

    }

    public void run(){

        for(int i = start; i < start+offset; i++){

            for(int j = 0; j < SIZE; j++){

                array[i] = i;

            }

        }

    }

    public static void main(String[] args) throws Exception{

        Thread[] array = new Thread[8];

        for(int numThread = 1; numThread <= 8; numThread++){

            int start = 0, offset = 0;
            long startTime = System.currentTimeMillis();

            for(int j = 0; j < numThread; j++){

                start = start + offset;
                offset = SIZE/numThread;
                array[j] = new Thread(new TesterArray(start, offset));
                array[j].start();

            }

            for(int k = 0; k < numThread; k++){

                array[k].join();

            }
            long endTime = System.currentTimeMillis();
            System.out.println(numThread + " Threads: " + "ha impiegato " + (endTime-startTime) + "ms");

        }

    }

}
