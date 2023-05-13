
public class Sort {
    public static void shakerSort(int arr[]) { //Сложность алгоритма: O(n log n)
        int buff;
        int left = 0;
        int right = arr.length - 1;
        do {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    buff = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = buff;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    buff = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = buff;
                }
            }
            left++;
        } while (left < right);
    }

    public static void bubbleSort(int[] sortArr) {           //Сложность алгоритма: О(n2)
        for (int i = 0; i < sortArr.length - 1; i++) {
            for (int j = 0; j < sortArr.length - i - 1; j++) {
                if (sortArr[j + 1] < sortArr[j]) {
                    int swap = sortArr[j];
                    sortArr[j] = sortArr[j + 1];
                    sortArr[j + 1] = swap;
                }
            }
        }
    }

    public static void insertionSort(int[] sortArr) {        //Сложность алгоритма: О(n2)
        int j;
        //сортировку начинаем со второго элемента, т.к. считается, что первый элемент уже отсортирован
        for (int i = 1; i < sortArr.length; i++) {
            //сохраняем ссылку на индекс предыдущего элемента
            int swap = sortArr[i];
            for (j = i; j > 0 && swap < sortArr[j - 1]; j--) {
                //элементы отсортированного сегмента перемещаем вперёд, если они больше элемента для вставки
                sortArr[j] = sortArr[j - 1];
            }
            sortArr[j] = swap;
        }
    }

    public static void selectionSort(int[] sortArr) {     //Сложность алгоритма: О(n2)
        for (int i = 0; i < sortArr.length; i++) {
            int pos = i;
            int min = sortArr[i];
            //цикл выбора наименьшего элемента
            for (int j = i + 1; j < sortArr.length; j++) {
                if (sortArr[j] < min) {
                    //pos - индекс наименьшего элемента
                    pos = j;
                    min = sortArr[j];
                }
            }
            sortArr[pos] = sortArr[i];
            //меняем местами наименьший с sortArr[i]
            sortArr[i] = min;
        }
    }

    //вернуть левого потомка `A[i]`
    private static int LEFT(int i) {                  //Сложность алгоритма: O(n log n)
        return (2 * i + 1);
    }

    //вернуть правого потомка `A[i]`
    private static int RIGHT(int i) {
        return (2 * i + 2);
    }

    //вспомогательная функция для замены двух индексов в массиве
    private static void swap(int[] sortArr, int i, int j) {
        int swap = sortArr[i];
        sortArr[i] = sortArr[j];
        sortArr[j] = swap;
    }

    //рекурсивный алгоритм heapify-down. Узел с индексом `i` и 2 его прямых потомка нарушают свойство кучи
    private static void heapify(int[] sortArr, int i, int size) {
        // получить левый и правый потомки узла с индексом `i`
        int left = LEFT(i);
        int right = RIGHT(i);
        int largest = i;

        //сравниваем `A[i]` с его левым и правым дочерними элементами и находим наибольшее значение
        if (left < size && sortArr[left] > sortArr[i]) largest = left;
        if (right < size && sortArr[right] > sortArr[largest]) largest = right;

        //поменяться местами с потомком, имеющим большее значение и вызовите heapify-down для дочернего элемента
        if (largest != i) {
            swap(sortArr, i, largest);
            heapify(sortArr, largest, size);
        }
    }

    //функция для удаления элемента с наивысшим приоритетом (присутствует в корне)
    public static int pop(int[] sortArr, int size) {
        //если в куче нет элементов
        if (size <= 0) {
            return -1;
        }
        int top = sortArr[0];

        //заменяем корень кучи последним элементом массива
        sortArr[0] = sortArr[size - 1];
        //вызовите heapify-down на корневом узле
        heapify(sortArr, 0, size - 1);
        return top;
    }

    //функция для выполнения пирамидальной сортировки массива `A` размера `n`
    public static void heapSort(int[] sortArr) {
        //строим приоритетную очередь и инициализируем ее заданным массивом
        int n = sortArr.length;

        //build-heap: вызывать heapify, начиная с последнего внутреннего
        //узел до корневого узла
        int i = (n - 2) / 2;
        while (i >= 0) {
            heapify(sortArr, i--, n);
        }

        //несколько раз извлекаем из кучи, пока она не станет пустой
        while (n > 0) {
            sortArr[n - 1] = pop(sortArr, n);
            n--;
        }
    }
}
