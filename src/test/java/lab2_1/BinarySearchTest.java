package lab2_1;

import org.junit.Test;

import edu.iis.mto.bsearch.BinarySearch;
import edu.iis.mto.bsearch.SearchResult;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class BinarySearchTest 
{
	@Test
	public void ElementIsInSequence()
	{
		int[] sequence =  new int[]{5};
		SearchResult res = BinarySearch.search(5,sequence);
		assertThat(res.isFound(),equalTo(true));
	}
	
	@Test
	public void ElementNotInSequenceOneElement()
	{
		int[] sequence =  new int[]{4};
		SearchResult res = BinarySearch.search(5,sequence);
		assertThat(res.isFound(),equalTo(false));
	}
	
	@Test
	public void ElementIsFirstElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(4,sequence);
		assertThat(res.isFound(),equalTo(true));
		assertThat(res.getPosition(),equalTo(1));
	}
	
	@Test 
	public void ElementIsLastElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(9,sequence);
		assertThat(res.isFound(),equalTo(true));
		assertThat(res.getPosition(),equalTo(sequence.length));
	}
	
	@Test
	public void ElementIsMiddleElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(7,sequence);
		assertThat(res.isFound(),equalTo(true));
		assertThat(res.getPosition(),equalTo((int) sequence.length / 2 + 1));
	}
	
	@Test
	public void ElementNotInSequenceMoreThanOneElement()
	{
		int[] sequence =  new int[]{4,5,7,8,9};
		SearchResult res = BinarySearch.search(3,sequence);
		assertThat(res.isFound(),equalTo(false));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void ThrowException()
	{
		int[] seq = new int[]{};
		
		BinarySearch.search(3, seq);
	}
}
