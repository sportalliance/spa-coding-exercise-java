package spa.exercise.kotlin

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class AppIntegrationTest {

	@Test
	fun `app context should start`() {
		assertThat(true).isTrue()
	}
}
