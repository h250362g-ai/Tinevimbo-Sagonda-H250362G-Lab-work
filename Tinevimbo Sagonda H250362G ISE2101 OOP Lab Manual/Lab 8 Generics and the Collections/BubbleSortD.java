import java.util.Arrays;

public class BubbleSortD {

    public static <T extends Comparable<T>> void bubbleSort(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            boolean swapped = false;

            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j + 1]) > 0) {
                    T temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;

                    swapped = true;
                }
            }

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] numbers = {5, 2, 9, 1, 6};
        String[] names = {"Tendai", "Tinevimbo", "Tanya", "Faffy"};

        bubbleSort(numbers);
        bubbleSort(names);

        System.out.println("Sorted integers: " + Arrays.toString(numbers));
        System.out.println("Sorted strings: " + Arrays.toString(names));
    }
}
