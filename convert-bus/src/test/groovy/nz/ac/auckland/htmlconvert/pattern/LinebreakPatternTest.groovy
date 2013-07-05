package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import nz.ac.auckland.htmlconvert.model.Conversion
import nz.ac.auckland.htmlconvert.service.HtmlConversionService
import org.junit.Test

import javax.inject.Inject

/**
 *  Author: Marnix
 *
 */
class LinebreakPatternTest extends MarkdownIntegrationTest {

    @Test
    public void shouldConvertLineBreaks() {
        assert html2markdown("<p>my line<br/>break</p>") == "my line  \nbreak\n\n";
        assert html2markdown("<p>my line<br>break</p>") == "my line  \nbreak\n\n";
    }
}
