package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.testrunner.GroupAppsSpringTestRunner
import nz.ac.auckland.htmlconvert.model.Conversion
import nz.ac.auckland.htmlconvert.service.HtmlConversionService
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.test.context.ContextConfiguration

import javax.inject.Inject

/**
 *  Author: Marnix
 *
 */
@RunWith(GroupAppsSpringTestRunner)
@ContextConfiguration("classpath:spring-markdown-test.xml")
class ParagraphPatternTest {

    /**
     * Conversion stack
     */
    @Inject HtmlConversionService conversionService;


    @Test
    public void shouldConvertInternals() {

        def html =
                '<p>my <a href="http://google.com">Link</a> is awesome</p>' +
                '<p>second <a href="http://google.com">Link</a> is awesome</p>';

        def conv = new Conversion(html);

        conversionService.process(conv);

        assert conv.markdown ==
                "my [Link](http://google.com) is awesome\n\n" +
                "second [Link](http://google.com) is awesome\n\n";
    }

}
