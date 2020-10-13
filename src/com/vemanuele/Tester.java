package com.vemanuele;

import java.lang.invoke.MethodHandles;

public class Tester implements Runnable{

    public void run(){

        try {

            for (int i = 0; i < 5; i++) {

                Thread.sleep(1000);
                System.out.println("Allah Syria Bashar");

            }

        } catch (InterruptedException e){

            System.out.println("Mi hanno ucciso");

        }

    }

    public static void main(String[] args) {

        Thread t1 = new Thread(new Tester());
        long start = System.currentTimeMillis();
        boolean interrupted = false;
        t1.start();
        while(t1.isAlive()){

            try {
                t1.join(1000);
                if(t1.isAlive() && System.currentTimeMillis() - start > 5000){

                    interrupted = true;
                    t1.interrupt();
                    t1.join();
                    System.out.println("Ucciso!");

                } else if(t1.isAlive()){

                    System.out.println("Still waiting...");

                }
            } catch(InterruptedException e){
                e.printStackTrace();
            }

        }

        if(interrupted){

            System.out.println("Finito interrompendolo");

        } else {

            System.out.println("Finito senza interromperlo");

        }

    }

}
