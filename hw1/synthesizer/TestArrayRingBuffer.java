package synthesizer;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Iterator;
/** Tests the ArrayRingBuffer class.
 *  @author Josh Hug
 */

public class TestArrayRingBuffer {
    @Test
    public void someTest() {
        ArrayRingBuffer<Double> array = new ArrayRingBuffer<>(5);
        array.enqueue(1.0);
        array.enqueue(2.0);
        array.enqueue(3.0);
        array.enqueue(4.0);
        array.enqueue(5.0);
        double i = 1.0;
        for (double x : array) {
            assertEquals(i, x, 0);
            i = i + 1.0;
        }
    }
}
