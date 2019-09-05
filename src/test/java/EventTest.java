import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EventTest {
    @Test
    public void dummyTest() {
        Event test = new Event("Project meeting", "12/12/2019 1200");
        assertEquals("[E][" + "0" + "] Project meeting (at: 12/12/2019 1200)", test.toString());
        assertEquals("E | " + "0" + " | Project meeting | 12/12/2019 1200", test.stringForAppend());
    }
}