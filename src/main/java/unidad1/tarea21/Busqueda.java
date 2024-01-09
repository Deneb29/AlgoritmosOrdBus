package unidad1.tarea21;

public class Busqueda {
    public static void indexedSequentialSearch(int arr[], int n,
                                        int k)
    {
        int elements[] = new int[20];
        int indices[] = new int[20];
        int temp, i;
        int j = 0, ind = 0, start = 0, end = 0, set = 0;
        for (i = 0; i < n; i += 3) {

            // Storing element
            elements[ind] = arr[i];

            // Storing the index
            indices[ind] = i;
            ind++;
        }
        if (k < elements[0]) {
            System.out.println("Not found");
            return;
        }
        else {
            for (i = 1; i <= ind; i++)
                if (k <= elements[i]) {
                    start = indices[i - 1];
                    set = 1;
                    end = indices[i];
                    break;
                }
        }
        if (set == 0) {
            start = indices[i - 1];
            end = n;
        }
        for (i = start; i <= end; i++) {
            if (k == arr[i]) {
                j = 1;
                break;
            }
        }
        if (j == 1)
            System.out.println("Found at index " + i);
        else
            System.out.println("Not found");
    }

    // Driver code

    public static void main(String[] args)
    {
        int[]arr= {12,23,34,45,56,67,78,89,99,102,784,843,932};
        int n = arr.length;

        // Element to search
        int k = 34;
        indexedSequentialSearch(arr, n, k);
    }
}
