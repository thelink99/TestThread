package cache;

import java.util.concurrent.atomic.AtomicInteger;

public class TesterProva implements Runnable{

    public static int c = 0;

    public void run(){

        c++;

    }

    public static void main(String[] args) {

        int a = 2;
        AtomicInteger b = new AtomicInteger(2);

    }

}
