package task14;

import static org.junit.Assert.*;

import org.junit.Test;
import task14.FilterUtil;

public class FilterTest {
    @Test
    public void testFilter(){
        String[] input = {"cat","dog","crocodile","meow","snack"};
        String[] output = FilterUtil.filter(input, FilterUtil.catFilter);
        assertArrayEquals(new String[]{"cat","dog"}, output);
    }
}
