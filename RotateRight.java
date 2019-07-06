//HACKER RANK CODING CHALLENGE ROTATE ARRAY ELEMENTS RIGHT BY D ELEMENTS
public class RotateRight {

    // Complete the rotLeft function below.
    int[] rotRight(int[] arr, int d) {
        int n = arr.length;
        for (int i = 0; i < d; i++) 
            rightRotatebyOne(arr, n);
        return arr;
    }

    int[] rightRotatebyOne(int arr[], int n)
    {
        int i, temp;
        temp= arr[n-1];
        for(i =n-1; i>0;i--)
        {
            arr[i] = arr[i-1];
        }
        arr[i] = temp;
        return arr;
    }
    public static void main(String[] args) {
        RotateRight s = new RotateRight();
        int []arr = {1, 2, 3, 4, 5};
        int d = Integer.parseInt(args[0]);
        arr = s.rotRight(arr, d);
        for (int i=0;i<arr.length;i++) {
            System.out.println(arr[i]);
        }
    }
}