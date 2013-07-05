package nz.ac.auckland.htmlconvert.pattern.list

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import org.junit.Test

/**
 *  Author: Marnix
 *
 */
class OrderedListPatternTest extends MarkdownIntegrationTest {

    @Test
    public void shouldConvertToOrderedList() {
        def html = "<ol><li>first item</li><li>second item</li></ol>";
        def markdown =
            "1.\tfirst item\n" +
            "2.\tsecond item\n\n"

        assert html2markdown(html) == markdown
    }


    @Test
    public void shouldIndentParagraphsNicely() {
        def html =
                    "<ol>" +
                        "<li>" +
                            "<p>first paragraph</p>" +
                            "<p>second paragraph</p>" +
                        "</li>" +
                        "<li>second item</li>" +
                    "</ol>";
        def markdown =
            "1.\tfirst paragraph\n" +
            "\t\n" +
            "\tsecond paragraph\n" +
            "\t\n" +
            "\t\n" +
            "2.\tsecond item\n\n"

        assert html2markdown(html) == markdown
    }
}
