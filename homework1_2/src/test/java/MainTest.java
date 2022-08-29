import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void bubbleSort() {
        int[] arrayTest = {11, 5, 99, 99, 99, 1, 1, 5};
        int[] expected = {1, 1, 5, 5, 11, 99, 99, 99};
        int[] actual = Main.bubbleSort(arrayTest);
        assertArrayEquals(expected, actual);

    }
}