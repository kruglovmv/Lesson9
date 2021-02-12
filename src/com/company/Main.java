package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int x;
        x = new Random().nextInt(6)+1;
        String [] [] str = new String[x][x];
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                str[i][j] = Integer.toString(new Random().nextInt(100));
            }
        }
        str[x-1][x-1] = "ghjk";
        System.out.println("Длина массива " + x);
        try {
                System.out.println(stringArrayException(str));
            }catch (MyArrayDataException | MyArraySizeException e) {
                System.out.println(e);
            }
        }


    public static int stringArrayException(String[][] str) throws MyArraySizeException, MyArrayDataException {
        if(str.length!=4)
            throw new MyArraySizeException("Длина массива не соответствует заданному критерию");
        int sum =0;
        int number = 0;
        for (int i = 0; i < str.length; i++) {
            for (int j = 0; j < str[i].length; j++) {
                try { number = Integer.parseInt(str[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException ("В строке " + (i+1) + " столбце " + (j+1) + " невозможно переопределить строку в число");
                }
                sum+=number;
            }
        }
        return sum;
    }
}

