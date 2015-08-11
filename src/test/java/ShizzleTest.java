import org.junit.*;
import static org.junit.Assert.*;

public class ShizzleTest {

    @Test
    public void shizzle_ReturnsAStringUnchanged_String() {
        String test = "Hi";
        assertEquals(test, Shizzle.getShizzle("Hi"));
    }

    @Test
    public void shizzle_ReplacesAllLettersSWithZ_String() {
        String test = "suzan";
        assertEquals(test, Shizzle.getShizzle("susan"));

    }


    @Test
    public void shizzle_DoesntReplaceCapitalS_String() {
        String test = "Suzan";
        assertEquals(test, Shizzle.getShizzle("Susan"));

    }

    @Test
    public void shizzle_DoesntReplaceFirstLetterInAWord_String() {
        String test = "Dogz of Suzan";
        assertEquals(test, Shizzle.getShizzle("Dogs of Susan"));
    }

}
