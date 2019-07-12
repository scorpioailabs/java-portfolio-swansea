/*
 * Complete the function below.
 */
public static int leftChild(int i) {
    return 2 * i + 1;
}

public static int rightChild(int i) {
    return 2 * i + 2;
}

public static Date ThirdLatest(Date[] s) {
    int k = 3;
    //convert to set
    Set<String> set = new HashSet<>();
    //conv back
    String[] s = new String[set.size()];
    for (int i =0; i< s.length; i++) {
        set.add(Integer.valueOf(Integer.toString(s[i].Year + s[i].Month + s[i].Day).toString());
    }
    set.toArray(s);
    
    // build up min heap of size k
    for (int i = k - 1; i >= 0; i--) {
        if (Integer.valueOf(Integer.toString(s[0].Year + s[0].Month + s[0].Day))
           != Integer.valueOf(Integer.toString(s[i].Year + s[i].Month + s[i].Day)))
             heapify(s, i, s.length);
    }
    for (int i = k; i < s.length; i++) {
        if (Integer.valueOf(Integer.toString(s[0].Year + s[0].Month + s[0].Day))
           != Integer.valueOf(Integer.toString(s[i].Year + s[i].Month + s[i].Day))) {
            
            if (Integer.valueOf(Integer.toString(s[0].Year + s[0].Month + s[0].Day))
                <Integer.valueOf(Integer.toString(s[i].Year + s[i].Month + s[i].Day))){
                Date temp;
                temp = s[0];
                s[0] = s[i];
                s[i] = temp;
                heapify(s, 0, k);
            }          
        }
            
    }
    return s[0];    
}
private static void heapify(Date[] s, int i, int size) {
        int minIndex = i;
        int l = leftChild(i);
        int r = rightChild(i);
        if (l < size && Integer.valueOf(Integer.toString(s[l].Year + s[l].Month + s[l].Day)) 
            < Integer.valueOf(Integer.toString(s[minIndex].Year + s[minIndex].Month + s[minIndex].Day)))
        {
            minIndex = l;
        }
        if (r < size && Integer.valueOf(Integer.toString(s[r].Year + s[r].Month + s[r].Day)) 
            < Integer.valueOf(Integer.toString(s[minIndex].Year + s[minIndex].Month + s[minIndex].Day)))
        {
            minIndex = r;
        }
        if (minIndex != i) {
            // SWAP
            Date temp = s[i];
            s[i] = s[minIndex];
            s[minIndex] = temp;
            // Recursively heapify
            heapify(s, minIndex, size);
        }
    }

