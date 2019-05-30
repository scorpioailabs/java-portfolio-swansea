//Teststock client
public class TestStock {
	// test client
	public static void main(String[] args) {
		StockAnalysisTwo d = new StockAnalysisTwo();
		SortingClient print = new SortingClient();
		int [] P = { 2, 4, 4, 3, 8, 9, 2, 3, 11, 5};
		int[] span = d.computeSpan(P);
		print.printArray(span);
	}
}