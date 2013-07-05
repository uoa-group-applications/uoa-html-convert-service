package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import org.junit.Test
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**

 * author: Richard Vowles - http://gplus.to/RichardVowles
 */
class BrutalIntegrationTest extends MarkdownIntegrationTest {
	private Logger log = LoggerFactory.getLogger(getClass())
	List<String> resources = ["sample1.html"]

	@Test
	public void tickleMe() {
		resources.each { String resource ->
			String conv = html2markdown(getClass().getResourceAsStream("/samples/" + resource).text)
			log.debug("{}", conv)
			assert conv
		}
	}
}
