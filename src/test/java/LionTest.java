import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import com.example.Lion;
import com.example.FelineInterface;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class LionTest {
    private Lion lion;
    private FelineInterface felineMock;

    @BeforeEach
    public void setUp() {
        felineMock = mock(FelineInterface.class);
        lion = new Lion(felineMock);
    }
    @Test
    public void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class, () -> new Lion("Некорректное значение"));
        assertEquals("Используйте допустимые значения пола животного - самец или самка", exception.getMessage());
    }
    @Test
    public void testGetKittens() {
        when(felineMock.getKittens()).thenReturn(1);
        assertEquals(1, lion.getKittens());
    }
    @Test
    public void testGetFood() throws Exception {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        when(felineMock.getFood("Хищник")).thenReturn(expectedFood);
        assertEquals(expectedFood, lion.getFood());
    }
    @Test
    public void testGetFoodWithValidType() {
        List<String> expectedFood = List.of("Животные", "Птицы", "Рыба");
        assertEquals(expectedFood, lion.getFood("Хищник"));
    }
}
