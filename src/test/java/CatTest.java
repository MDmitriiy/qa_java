import com.example.Cat;
import com.example.Feline;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
    public class CatTest {
        @Mock
        private Feline predatorMock;
        @InjectMocks
        private Cat cat;
        @BeforeEach
        void setUp() {
            MockitoAnnotations.openMocks(this);
            cat = new Cat(predatorMock);
        }
    @Test
    void testGetSound() {
        String expectedSound = "Мяу";
        String actualSound = cat.getSound();
        assertEquals(expectedSound, actualSound);
    }
    @Test
    void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        doReturn(expectedFood).when(predatorMock).eatMeat();
        List<String> actualFood = cat.getFood();
        assertEquals(expectedFood, actualFood);
    }
}
 