import java.util.Arrays;

public class Sorting_main {
    public static void main(String[] args) {
        Sorting sort = new Sorting();

        int[] array1 = {2, 1, 4, 3, 5};
        //버블 정렬
        sort.sortByBubbleSort(array1);

        //선택 정렬
        int[] array2 = {2, 1, 4, 3, 5};
        sort.sortBySelectionSort(array2);

        //삽입 정렬
        int[] array3 = {2, 1, 4, 3, 5};
        sort.sortByInsertionSort(array3);

        //셸 정렬
        int[] array4 = {2, 1, 4, 3, 5};
        sort.sortByShellSort(array4);

        //합병 정렬
        int[] array5 = {2, 1, 4, 3, 5};
        sort.sortByMergeSort(array5);


        //힙 정렬
        int[] array6 = {2, 1, 4, 3, 5};
        sort.sortByHeapSort(array6);

        //퀵 정렬
        int[] array7 = {2, 1, 4, 3, 5};
        sort.sortByQuickSort(array7);

        //그냥 sort
        int[] array8 = {2, 1, 4, 3, 7};
        Arrays.sort(array8);
        System.out.println(Arrays.toString(array8));

    }
}
