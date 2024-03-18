package spa.exercise.restjpa;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RestJpaAppIntegrationTest {

	@Test
	void appContextShouldStart() {
		assertThat(true).isTrue();
	}
}
