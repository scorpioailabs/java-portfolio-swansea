/*package InterviewQs;
An optimum version of the rotate array problem
/**
 * OptiRotate
 */
public class OptiRotate {
    public static void rotate(int[]nums, int k) {
        int n = nums.length;
        if(n==0 || n==1) return;
        if(k>n) {
            k=k%n;
        }
        rotRight(nums,0,n-k-1);
        rotRight(nums,n-k,n-1);
        rotRight(nums,0,n-1);
    }
    public static void rotRight(int[]nums, int s, int e) {
        for (int i = s; i < (s+e+1)/2; i++) {
            int temp = nums[i];
            nums[i] = nums[e+s-i];
            nums[e+s-i]= temp;
        }
    }    
    
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        int[] in = { 1, 3, 5, 4, 2 };
        rotate(in, k);
        for (int i = 0; i < in.length; i++) {
            System.out.println(in[i]);
        }
    }
}