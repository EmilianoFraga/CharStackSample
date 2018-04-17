import java.io.InputStream;
import org.junit.Test;

public class TestSolution {
    @Test
    public void testCase0() throws Exception {
    	try (InputStream is = TestSolution.class.getResourceAsStream("test0")) {    	
	    	Solution.setInputStream(is);
	    	
	    	Solution.main(null);
    	} finally {
    		// empty block
    	}
    }

    @Test
    public void testCase1() throws Exception {
    	try (InputStream is = TestSolution.class.getResourceAsStream("test1")) {    	
	    	Solution.setInputStream(is);
	    	
	    	Solution.main(null);
    	} finally {
    		// empty block
    	}
    }

    @Test
    public void testCase2() throws Exception {
    	try (InputStream is = TestSolution.class.getResourceAsStream("test2")) {    	
	    	Solution.setInputStream(is);
	    	
	    	Solution.main(null);
    	} finally {
    		// empty block
    	}
    }

    @Test (expected = IllegalStateException.class)
    public void testCase3() throws Exception {
    	try (InputStream is = TestSolution.class.getResourceAsStream("test3")) {    	
	    	Solution.setInputStream(is);
	    	
	    	Solution.main(null);
    	} finally {
    		// empty block
    	}
    }
}
