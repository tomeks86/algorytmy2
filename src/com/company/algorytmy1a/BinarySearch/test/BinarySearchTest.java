import com.company.algorytmy1a.BinarySearch.src.BinarySearch;
import org.junit.Assert;
import org.junit.Test;

public class BinarySearchTest {
    private int [] testTab = {11,22,33,44,55};
    private BinarySearch binarySearch = new BinarySearch();

    @Test
    public void shouldReturnTrueIfNumberIsPresentInATable() {
        boolean result = binarySearch.contains(testTab, 22);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnTrueIfTableHasOneElement() {
        int [] testTab = {66};
        boolean result = binarySearch.contains(testTab, 66);
        Assert.assertTrue(result);
    }

    @Test
    public void shouldReturnFalseIfNumberIsNotPresentInATable() {
        boolean result = binarySearch.contains(testTab, 666);
        Assert.assertFalse(result);
    }

    @Test
    public void shouldReturnFalseIfTableIsEmpty() {
        int [] emptyTab = {};

        boolean result = binarySearch.contains(emptyTab, 2);
        Assert.assertFalse(result);



    }

}
