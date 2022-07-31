package ua.ithillel.Lievientsov.HomeworkThirteen;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Arrays;

/*
 * - Заданы три целочисленных массива. Записать эти массивы в файл в паралельних потоках.
 * Создать класс SaveAsThread для представления потока, который записывает целочисленный массив в файл.
 */


public class TaskTwo {
    public static void main(String[] args) throws IOException {
        int[] array1 = new int[10];
        int[] array2 = new int[5];
        int[] array3 = new int[7];
        for (int i = 0; i < array1.length; i++) {
            array1[i] = ((int) (Math.random() * 11) + 1);
        }
        for (int i = 0; i < array2.length; i++) {
            array2[i] = ((int) (Math.random() * 6) + 1);
        }
        for (int i = 0; i < array3.length; i++) {
            array3[i] = ((int) (Math.random() * 8) + 1);
        }

        SaveAsThread thread1 = new SaveAsThread(array1, "Test1.txt", "thread1");
        SaveAsThread thread2 = new SaveAsThread(array2, "Test2.txt", "thread2");
        SaveAsThread thread3 = new SaveAsThread(array3, "Test3.txt", "thread3");

        System.out.println("Array content: " + Arrays.toString(array1));
        System.out.println("Array content: " + Arrays.toString(array2));
        System.out.println("Array content: " + Arrays.toString(array3));
        System.out.println("================================");

        thread1.start();
        thread2.start();
        thread3.start();

    }

    static class SaveAsThread implements Runnable {
        private final int[] arrayOne;
        private final String filename;
        private final String threadName;
        private final Thread threadOne;

        public SaveAsThread(int[] arrayOne, String filename, String threadName) {
            this.arrayOne = arrayOne;
            this.filename = filename;
            this.threadName = threadName;
            threadOne = new Thread(this, "SaveThread");
        }

        public void start() {
            threadOne.start();
        }

        public void run() {
            System.out.println("Start thread: " + threadName);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(filename);
                PrintStream printStream = new PrintStream(fileOutputStream);
                printStream.println(arrayOne.length);

                for (int j : arrayOne) {
                    printStream.println(j);
                }

                printStream.close();
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println("End thread: " + threadName);
        }
    }


}
