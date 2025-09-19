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
    public void setUp() throws Exception {
        felineMock = mock(FelineInterface.class);
        lion = new Lion("Самец", felineMock);
    }
    @Test
    public void testDoesHaveManeForMale() throws Exception {
        lion = new Lion("Самец", felineMock);
        assertTrue(lion.doesHaveMane());
    }

    @Test
    public void testDoesHaveManeForFemale() throws Exception {
        lion = new Lion("Самка", felineMock);
        assertFalse(lion.doesHaveMane());
    }
    @Test
    public void testInvalidSexThrowsException() {
        Exception exception = assertThrows(Exception.class,
                () -> new Lion("Некорректное значение", felineMock));
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
}