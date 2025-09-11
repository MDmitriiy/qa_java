import com.example.Animal;
import com.example.Feline;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

@ExtendWith(MockitoExtension.class)
public class FelineTest {
    @Test
    public void testEatMeat() throws Exception {
        Animal animalMock = Mockito.mock(Animal.class);
        Mockito.when(animalMock.getFood("Хищник")).thenReturn(List.of("Животные", "Птицы", "Рыба"));

        Feline felineMock = new Feline() {
            @Override
            public List<String> getFood(String type) throws Exception {
                return animalMock.getFood(type);
            }
        };

        try {
            List<String> result = felineMock.eatMeat();
            assertEquals(List.of("Животные", "Птицы", "Рыба"), result);
        } catch (Exception e) {
            e.printStackTrace();
            fail("Unexpected exception occurred");
        }
    }

    @Test
    public void testGetFamily() {
        Feline feline = new Feline();
        String result = feline.getFamily();
        assertEquals("Кошачьи", result);
    }

    @Test
    public void testGetKittens() {
        Feline feline = new Feline();
        int resultDefault = feline.getKittens();
        assertEquals(1, resultDefault, "Тест для метода getKittens без параметров не прошел.");

        int resultWithParam = feline.getKittens(1);
        assertEquals(1, resultWithParam, "Тест для метода getKittens с параметром не прошел.");
    }
}