import java.util.List;


public class Sorting {
    public static void bubbleSort(List<Integer> data) {
        int n = data.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (data.get(j) > data.get(j + 1)) {
                    int temp = data.get(j);
                    data.set(j, data.get(j + 1));
                    data.set(j + 1, temp);
                }
            }
        }
    }

    public static void insertSort(List<Integer> data) {
        int n = data.size();
        for (int i = 1; i < n; ++i) {
            int key = data.get(i);
            int j = i - 1;
            while (j >= 0 && data.get(j) > key) {
                data.set(j + 1, data.get(j));
                j = j - 1;
            }
            data.set(j + 1, key);

        }
    }

    public static void quickSort(List<Integer> data, int low, int high) {
        if (low < high) {
            int pi = partition(data, low, high);
            quickSort(data, low, pi - 1);
            quickSort(data, pi + 1, high);
        }
    }

    private static int partition(List<Integer> data, int low, int high) {
        int pivot = data.get(high);
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (data.get(j) <= pivot) {
                i++;
                int temp = data.get(i);
                data.set(i, data.get(j));
                data.set(j, temp);
            }
        }
        int temp = data.get(i + 1);
        data.set(i + 1, data.get(high));
        data.set(high, temp);
        return i + 1;
    }



}


