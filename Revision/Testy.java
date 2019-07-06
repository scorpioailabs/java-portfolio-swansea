import java.util.HashMap;
import java.util.Map;
public class Testy {
  public static void something (int[] arr) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i =0; i < arr.length; i ++) {
      if (map.containsKey(arr[i])) {
        System.out.println(arr[i]);
      }
      map.put(arr[i], i);
    }
  }
  public static void main(String[] args) {
    int arr[] = { 3, 5, 6, 3, 7, 4, 8};
    Testy t = new Testy();
    System.out.println("duplicate found : ");
    t.something(arr);
  }
}
