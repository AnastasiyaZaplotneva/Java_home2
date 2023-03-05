// Реализуйте алгоритм сортировки пузырьком числового массива, 
// результат после каждой итерации запишите в лог-файл.

import java.util.Arrays;
import java.util.Random;
import java.io.IOException;
import java.util.logging.*;

class MyArray {
    int[] arr;
    int size;
    int limit;
    private static Random random = new Random();

    MyArray() {
        size = 0;
        limit = 0;
    }

    MyArray(MyArray m) {
        size = m.size;
        arr = Arrays.copyOf(m.arr, size);
    }

    public void fillArray(int s, int l) {
        size = s;
        limit = l;
        arr = new int [size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(limit);
        }
    }

    public void print() {
        
        int index = 0;
        while (index < size) {
            System.out.print(arr[index] + " ");
            index = index + 1;
            }
        System.out.println("");
    }

    public void bubbleSort() {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public void bubbleSortLog() throws IOException {
        
        Logger logger = Logger.getLogger(MyArray.class.getName());
        FileHandler fh = new FileHandler("BubleSortingLog.txt");
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j+1] < arr[j]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        String logMsg = fromArrToString();
        logger.info(logMsg);
        }
    }

    private String fromArrToString () {
        String logString = "";
        for (int i = 0; i < arr.length; i++) {
            logString += arr[i] + " ";
        }
        return logString;
    }
}

public class BubleSorting {
    public static void main(String[] args) throws IOException {
        MyArray massive = new MyArray();
        massive.fillArray(10, 20);
        massive.print();
        MyArray sortMassive = new MyArray(massive);
        sortMassive.bubbleSortLog();
        sortMassive.print();
    }
    
}
