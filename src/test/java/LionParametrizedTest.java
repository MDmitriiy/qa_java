import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import com.example.Lion;
import java.util.stream.Stream;

public class LionParametrizedTest {
    @ParameterizedTest
    @MethodSource("provideLionData")
    void testDoesHaveMane(String sex, boolean expectedMane) throws Exception {
        Lion lion = new Lion(sex);
        boolean actualMane = lion.doesHaveMane();
        assert actualMane == expectedMane : "Ожидалось " + expectedMane + ", но получено " + actualMane;
    }

    private static Stream<Arguments> provideLionData() {
        return Stream.of(
                Arguments.of("Самец", true),
                Arguments.of("Самка", false)
        );
    }
}