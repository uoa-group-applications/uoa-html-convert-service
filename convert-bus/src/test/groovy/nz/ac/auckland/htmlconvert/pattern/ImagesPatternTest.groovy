package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import org.junit.Test

/**
 *  Author: Marnix
 *
 */
class ImagesPatternTest extends MarkdownIntegrationTest {

    @Test
    public void imageToMarkdownWithAlt() {

        def html = '<img src="http://google.com/favicon.ico" alt="My Text" />';
        def markdown = '![My Text](http://google.com/favicon.ico)';
        assert html2markdown(html) == markdown;

    }

    @Test
    public void imageToMarkdownWithoutAlt() {

        def html = '<img src="http://google.com/favicon.ico" />';
        def markdown = '![Image](http://google.com/favicon.ico)';
        assert html2markdown(html) == markdown;

    }
}
