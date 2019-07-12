/*
 * Complete the function below.
 */
    public static int partitionK(Date[] dates, int l, int r, int pivot)
    {
        int i = l+1;
        int j = r;
        int pivotVal = Integer.valueOf(Integer.toString(dates[l].Year*365
         + dates[l].Month + dates[l].Day));
        while (true) {
            while(Integer.valueOf(Integer.toString(dates[i].Year*365
            + dates[i].Month+ dates[i].Day)) < pivotVal) {
                ++i;
                if(i==r){
                    break;                    
                }
            }
            while(Integer.valueOf(Integer.toString(dates[j].Year*365
            + dates[j].Month+ dates[j].Day)) > pivotVal) {
                --j;
                if(j==r){
                    break;                    
                }
            }
            if(i>=j)
                break;
            swap(dates, i, j);
        }
        swap(dates, l, j);
        return j;
    }

    public static Date ThirdLatest(Date[] dates) {
        int k = 3;
        int n = dates.length;
        int l = 0;
        int r = n-1;
        Random rdm = new Random(0);
        while (l<= r) {
            //choose random pivot
            int pivot = rdm.nextInt(r -l +1)+ l; 
            int finalP = partitionK(dates, l, r, pivot);
            if(finalP == n-k){
                return dates[finalP];
            }
            else if(finalP > n -k){
                r = finalP -1;
            }
            else{
                l = finalP +1;
            }
        }
        return null;
    }

    private static void swap(Date[] dates, int a, int b) {
        Date temp = dates[a];
        dates[a] = dates[b];
        dates[b] = temp;
    }
