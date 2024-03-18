package spa.exercise.spring;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SimpleSpringBootAppIntegrationTest {

	@Test
	void appContextShouldStart() {
		assertThat(true).isTrue();
	}
}
