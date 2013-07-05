package nz.ac.auckland.htmlconvert.pattern.list

import nz.ac.auckland.htmlconvert.MarkdownIntegrationTest
import org.junit.Test

/**
 *  Author: Marnix
 *
 */
class UnorderedListPatternTest extends MarkdownIntegrationTest {

    @Test
    public void shouldConvertToUnorderedList() {
        def html = '<ul><li>first item</li><li>second item</li></ul>';
        def markdown =
            "*\tfirst item\n" +
            "*\tsecond item\n\n"

        assert html2markdown(html) == markdown
    }
    
    @Test
    public void listOfLinks() {
        def html = 
            '<ul>' +
                '<li><a href="http://google.com">Google</a> can be found here</li>' +
                '<li><a href="http://yahoo.com">Yahoo</a> can be found here</li>' +
            '</ul>';

        def markdown =
            "*\t[Google](http://google.com) can be found here\n" +
            "*\t[Yahoo](http://yahoo.com) can be found here\n\n";

        assert html2markdown(html) == markdown;
    }

}
