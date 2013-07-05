package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import org.junit.Test

/**
 *  Author: Marnix
 *
 */
class BlockquotePatternTest extends MarkdownIntegrationTest {

    @Test
    public void stylesInQuote() {
        def html =
                "<blockquote><p>This is a block-quote.</p></blockquote>",
            markdown =
                "> This is a block-quote.\n\n"

        assert html2markdown(html) == markdown;

    }

    @Test
    public void multipleStyles() {
        def html, markdown
        html = "<blockquote>" +
                "<h3>A header.</h3>" +
                "<p>This block-quote has a header in it.</p>" +
                "</blockquote>";

        markdown =
            "> ### A header.\n" +
            "> \n" +
            "> This block-quote has a header in it.\n\n"

        assert html2markdown(html) == markdown
    }


    @Test
    public void nestedQuote() {
        def html =
                "<blockquote>" +
                    "<h3>A header.</h3>" +
                        "<blockquote>" +
                            "<p>This block-quote is nested.</p>" +
                        "</blockquote>" +
                "</blockquote>";

        def markdown =
            "> ### A header.\n" +
            "> \n" +
            "> > This block-quote is nested.\n\n"

        assert html2markdown(html) == markdown;

    }

}
