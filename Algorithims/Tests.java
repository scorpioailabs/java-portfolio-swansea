import org.junit.*;
import static org.junit.Assert.*;

public class Tests
{
	
	@Test
	public void Test1()
	{
		Solution solution = new Solution();

		assertEquals(solution.ReverseWords("the quick brown fox"), "fox brown quick the");
	}
}