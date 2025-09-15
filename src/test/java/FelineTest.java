import com.example.Feline;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class FelineTest {
    @Test
    public void testEatMeat() throws Exception {
        Feline feline = new Feline(); {
           try
            {
                List<String> result = feline.eatMeat();
                assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
            } catch(
            Exception e)

            {
                e.printStackTrace();
                fail("Unexpected exception occurred");
            }
        }
    }

    @Test
        public void testGetFamily() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void testGetKittensWithParam() {
        Feline feline = new Feline();
        int resultDefault = feline.getKittens();
        assertEquals(1, resultDefault, "Тест для метода getKittens без параметров не прошел.");
    }
    @Test
        public void testGetKittenWithoutParam(){
        Feline feline = new Feline();
        int resultWithParam = feline.getKittens(1);
        assertEquals(1, resultWithParam, "Тест для метода getKittens с параметром не прошел.");
    }
}