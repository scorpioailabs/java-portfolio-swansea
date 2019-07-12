
/*package InterviewQs;

/**
 * LatestDate
 */
import java.util.*;

public class LatestDate {
    public static int partitionK(String[] dates, int l, int r, int pivot) {
        int pivotVal = Integer.valueOf(dates[pivot]);
        int lesserTail = l;
        swap(dates, pivot, r);
        for (int i = l; i < r; i++) {
            if (Integer.valueOf(dates[i]) < pivotVal) {
                swap(dates, i, lesserTail);
                lesserTail++;
            }
        }
        swap(dates, r, lesserTail);
        return lesserTail;
    }

    public static String ThirdLatest(String[] dates) {
        HashSet<String> set = new HashSet<String>();
        int k = 3;
        int n = dates.length;
        for (int i = 0; i < n; i++) {
            set.add(dates[i]);
        }
        int i = 0;
        String[] newDates = new String[set.size()];
        for (String d : set)
            newDates[i++] = d;
        Random rdm = new Random(0);
        n = newDates.length;
        int l = 0;
        int r = n - 1;
        while (l <= r) {
            // choose random pivot
            int pivot = rdm.nextInt(r - l + 1) + l;
            int finalP = partitionK(newDates, l, r, pivot);
            if (finalP == n - k) {
                return newDates[finalP];
            } else if (finalP > n - k) {
                r = finalP - 1;
            } else {
                l = finalP + 1;
            }
        }
        return null;
    }

    private static void swap(String[] dates, int a, int b) {
        String temp = dates[a];
        dates[a] = dates[b];
        dates[b] = temp;
    }

    public static void main(String[] args) {
        String[] dates = { "25", "24", "23", "22", "21", "20"};
        // int tester = (Integer.valueOf(dates[0].toString().replaceAll("\\-", "")));
        String res = ThirdLatest(dates);
        System.out.println(res);
    }
}