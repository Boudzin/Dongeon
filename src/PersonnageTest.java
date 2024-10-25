import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class PersonnageTest {

    @Test
    public void testCreationGuerrier() {
        Personnage guerrier = new Personnage("Testeur", "Guerrier", 10, 8, 100, 5);
        assertEquals("Guerrier", guerrier.getClasse());
        assertEquals(10, guerrier.getForce());
        assertEquals(8, guerrier.getDefense());
        assertEquals(100, guerrier.getSante());
        assertEquals(5, guerrier.getMana());
    }
}
