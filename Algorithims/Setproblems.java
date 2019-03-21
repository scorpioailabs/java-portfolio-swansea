public class Setproblems {
   
   public static int[] join(int [] A, int [] B, int [] C) {
        int n = A.length;
        int m = B.length;
        int l = C.length;   
      int [] D = new int [n + m + l];
        int i = 0;
        int j =0;
        int k =0;
        int t =0;
       while(i < n && j < m && k < l) {
            if(C[k] == A[i]){
                // sum += C[k];
                D[t] = C[k];
                i++;
                k++;
                t++;
            }
            else if (C[k] == B[j]) {
                D[t] = C[k];
                j++;
                k++;
                t++;
            }
            else if(A[i]<=B[j] && A[i]<=C[k])
                i++;
            else if(B[j]<=A[i] && B[j]<=C[k])
                j++;
            else
                k++;
        }
        while(k < l && i < n) {
          if(C[k] == A[i]){
            // sum += C[k];
            D[t] = C[k];
            i++;
            k++;
            t++;
          }
         else if(C[k] < A[i])
            k++;          
          else {
            i++;
          }  
        }
        while(k < l && j < m) {
            if(C[k] == B[j]){
            // sum += C[k];
            D[t] = C[k];
            j++;
            k++;
            t++;
            }
            else if(C[k] < B[j])
              k++;             
            else {
              j++;
            }                         
        }
        return D ;
   }
   
   public static int[] intersect(int [] A, int [] B, int [] C) {
        int n = A.length;
        int m = B.length;
        int l = C.length;   
        int [] D = new int [n + m + l];
        int i = 0;
        int j =0;
        int k =0;
        int t =0;
        while(i < n && j < m && k < l) {
            if(A[i] == B[j] && B[j] == C[k]){
                // sum += C[k];
                D[t] = C[k];
                i++;
                j++;
                k++;
                t++;
            }
            else if (C[k] == B[j]) {
                D[t] = C[k];
                j++;
                k++;
                t++;
            }
            else if(A[i]<B[j])
                i++;
            else if(B[j]<=C[k])
                j++;
            else
                k++;
        }
        return D ;
   }
   
   public static int[] complement(int [] A, int [] B) {
      int n = A.length;
      int m = B.length;
      int [] C = new int [n+m];
      int i = 0; int j =0; int k = 0;
      while (i < n && j < m) {
      if(A[i] < B[j]) {
         C[k] = A[i];
                i++;
                k++; 
         }
         else if(A[i] > B[j]) {
                j++;
         }
         else if(A[i] == B[j]){
                i++;
                j++;
         }
      }
      if (i < n) {
         C[k] = A[i];
         k++;
      }
      return C;
   }
   

    public static void main(String[] args) {
        int [] A = {2, 10, 17, 34, 115};
        int [] B = {0, 2, 38, 39, 40, 118, 126};
        int [] C = {2,  23, 115, 118, 120, 122, 124, 126, 127};
        
        int n = A.length;
        int m = B.length;
        int l = C.length;
        int[] x = join(A,B,C);
        int q = x.length;
        // int[] y = intersect(A,B,C);
        // int[] z = complement(x,y);
       System.out.println("The common elements are " );
       for (int i =0; i<q; i++)
        System.out.println(x[i]);    
   }
}