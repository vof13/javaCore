import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MainTest {

    @Test
    void fuzzySearchForCar() {
        Assertions.assertTrue(Main.fuzzySearch("car", "ca6$$#_rtwheel"));

    }

    @Test
    void fuzzySearchForCwhl() {
        Assertions.assertTrue(Main.fuzzySearch("cwhl", "cartwheel"));
    }

    @Test
    void fuzzySearchForCwhee() {
        Assertions.assertTrue(Main.fuzzySearch("cwhee", "cartwheel"));
    }

    @Test
    void fuzzySearchForCartwheel() {
        Assertions.assertTrue(Main.fuzzySearch("cartwheel", "cartwheel"));
    }

    @Test
    void fuzzySearchForCwheeelFalse() {
        Assertions.assertFalse(Main.fuzzySearch("cwheeel", "cartwheel"));
    }

    @Test
    void fuzzySearchForLwFalse() {
        Assertions.assertFalse(Main.fuzzySearch("lw", "cartwheel"));
    }
}