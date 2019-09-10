import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeadlineTest {
    @Test
    void testToString() {
        Deadline newDeadline = new Deadline("I need to test the code", "20/11/2019 1800");
        assertEquals("[D]" + "[\u2718]" + " " + "I need to test the code (by: 2019-11-20T18:00)", newDeadline.toString());
    }

}