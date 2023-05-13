import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String stop = "";
        while (!stop.equals("exit")) {
            Scanner reader = new Scanner(System.in);
            if (reader.hasNextInt() && reader.hasNextInt()) {
                int massiv = reader.nextInt();
                if (massiv<1){
                    System.out.println("Неверное число");
                }
                else {
                    int[] arr = new int[massiv];
                    System.out.println("Массив до сортировки");
                    fillArray(arr);
                    System.out.println("Массив после сортировки");
                    Sort.heapSort(arr);
                    System.out.println(Arrays.toString(arr));
                }
            }
            else if (reader.hasNextDouble())
            {
                System.out.println("Неверное число, введите целое число");
            }
            else if (reader.hasNextLine())
                if (reader.nextLine().equals("exit"))
                {
                    stop="exit";
                }
                else System.out.println("Неверный формат данных, введите целое число");
        }
    }

    private static void fillArray(int arr[]) {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 201 - 100);
        }
        System.out.println(Arrays.toString(arr));
    }
}

