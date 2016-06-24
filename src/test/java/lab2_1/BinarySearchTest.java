package lab2_1;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class BinarySearchTest 
{
	@Test
	public void Test_ElementIsInSequence_ForOneElement()
	{
		int[] sequence =  new int[]{5};
		SearchResult res = BinarySearch.search(5,sequence);
		assertThat(res.isFound(),equalTo(true));
	}
	
	@Test
	public void Test_ElementIsNotInSequence_ForOneElement()
	{
		int[] sequence =  new int[]{4};
		SearchResult res = BinarySearch.search(5,sequence);
		assertThat(res.isFound(),equalTo(false));
	}
	
	@Test
	public void Test_ElementIsFirstElement_ForMoreThanOneElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(4,sequence);
		assertThat(res.isFound(),equalTo(true));
		assertThat(res.getPosition(),equalTo(1));
	}
	
	@Test 
	public void Test_ElementIsLastElement_ForMoreThanOneElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(9,sequence);
		assertThat(res.isFound(),equalTo(true));
		assertThat(res.getPosition(),equalTo(sequence.length));
	}
	
	@Test
	public void Test_ElementIsMiddleElement_ForMoreThanOneElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(7,sequence);
		assertThat(res.isFound(),equalTo(true));
		assertThat(res.getPosition(),equalTo((int) sequence.length / 2 + 1));
	}
	
	@Test
	public void Test_ElementNotInSequence_ForMoreThanOneElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(3,sequence);
		assertThat(res.isFound(),equalTo(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void Test_IfBinarySearchThrowsException()
	{
		int[] seq = new int[]{};
		
		BinarySearch.search(3, seq);
	}
}
