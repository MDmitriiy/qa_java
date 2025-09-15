import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.example.Lion;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class LionParametrizedTest {
    @ParameterizedTest
    @MethodSource("provideLionData")
    void testDoesHaveMane(String sex, boolean expectedMane) throws Exception {
        Lion lion = new Lion(sex);
        boolean actualMane = lion.doesHaveMane();
        assertEquals(expectedMane, actualMane, "Ожидалось " + expectedMane + ", но получено " + actualMane);
    }

    private static Stream<Arguments> provideLionData() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }
}