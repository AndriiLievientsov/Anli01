package HomeworkThirteen;

import java.util.Scanner;

/* ДЗ 13. Многопоточность.
- Пользователь вводит с клавиатуры значение в массив. После чего запускаются два потока.
* Первый поток находит максимум в массиве, второй — минимум. Результаты вычислений возвращаются в метод main().
*/
public class TaskOne {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter array length: ");
        int size = input.nextInt();
        int[] array = new int[size];
        System.out.println("Insert array elements:");
        for (int i = 0; i < size; i++) {
            array[i] = input.nextInt();
        }
        ThreadMinMax thread1 = new ThreadMinMax(array);
        ThreadMinMax thread2 = new ThreadMinMax(array);
        try {
            thread1.getThread().join();
            thread2.getThread().join();
        } catch (InterruptedException e) {
            System.out.println("Error.");
        }
        System.out.println("""
                ==============
                Result:""");
        System.out.println("max = " + thread1.getMax());
        System.out.println("min = " + thread2.getMin());
    }

    static class ThreadMinMax implements Runnable {
        private final Thread threadOne;
        private final int[] arrayOne;
        private int maximum;
        private int minimum;

        public ThreadMinMax(int[] arrayForElements) {
            arrayOne = arrayForElements;
            threadOne = new Thread(this, "Thread1.");
            threadOne.start();
        }

        public void run() {
            int max = arrayOne[0];
            int min = arrayOne[0];
            for (int i = 1; i < arrayOne.length; i++) {
                if (max < arrayOne[i]) max = arrayOne[i];
                if (min > arrayOne[i]) min = arrayOne[i];
            }
            maximum = max;
            minimum = min;
        }

        public Thread getThread() {
            return threadOne;
        }

        public int getMax() {
            return maximum;
        }

        public int getMin() {
            return minimum;
        }
    }
}
