package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import org.junit.Test

/**
 *  Author: Marnix
 *
 */
class ComplexPatternsTest extends MarkdownIntegrationTest {

    @Test
    public void layoutTags() {
        def html = '<p>this is my <em>text</em> <strong>it seems to be working</strong> <b>quite <i>well</i></b></p>';
        def markdown = "this is my _text_ **it seems to be working** **quite _well_**\n\n";
        assert html2markdown(html) == markdown
    }

}
