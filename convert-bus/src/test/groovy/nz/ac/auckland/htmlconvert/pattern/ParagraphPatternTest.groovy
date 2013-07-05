package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.testrunner.GroupAppsSpringTestRunner
import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import nz.ac.auckland.htmlconvert.model.Conversion
import nz.ac.auckland.htmlconvert.service.HtmlConversionService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration

import javax.inject.Inject

/**
 *  Author: Marnix
 */
class ParagraphPatternTest extends MarkdownIntegrationTest {

    @Test
    public void shouldConvertInternals() {

        assert html2markdown(
                    '<p>my <a href="http://google.com">Link</a> is awesome</p>' +
                    '<p>second <a href="http://google.com">Link</a> is awesome</p>'
                ) ==
                    "my [Link](http://google.com) is awesome\n\n" +
                    "second [Link](http://google.com) is awesome\n\n";

    }

}
