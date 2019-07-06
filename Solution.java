//HACKER RANK CODING CHALLENGE ROTATE ARRAY ELEMENTS LEFT BY D ELEMENTS
public class RotateLeft {

    // Complete the rotLeft function below.
    int[] rotLeft(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < d; i++) 
            leftRotatebyOne(arr, n);
        return arr;
    }

    int[] leftRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp= arr[0];
        for(i =0; i< n-1;i++)
        {
            arr[i] = arr[i+1];
        }
        arr[i] = temp;
        return arr;
    }
    public static void main(String[] args) {
        Solution s = new Solution();
        int []arr = {1, 2, 3, 4, 5};
        int d = Integer.parseInt(args[0]);
        arr = s.rotLeft(arr, d);
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}