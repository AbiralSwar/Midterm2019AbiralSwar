package math.problems;

import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {
         /*
          Write 40 Fibonacci numbers with java.
          0,1,1,2,3,5,8,13
         */
        int i=1;
        int j=0;
        System.out.print("40 Fibonacci numbers: ");
        for (int k=1; k<=40; k++){
            int sum=i+j;
            i=j;
            j=sum;
            System.out.print(sum+ " ");

        }}


        public static ArrayList<Integer> arrayFibo(int fab[]){

            ArrayList<Integer> ar = new ArrayList<>();

            for (int m = 0; m < fab.length; m++) {
                if (m < 2) {
                    fab[m] = m;
                    ar.add(fab[m]);

                } else {
                    fab[m] = fab[m - 2] + fab[m - 1];
                    ar.add(fab[m]);
                }
            }

            return ar;
        }


    }

