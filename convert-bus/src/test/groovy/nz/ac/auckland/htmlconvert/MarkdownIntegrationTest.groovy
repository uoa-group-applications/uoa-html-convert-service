package nz.ac.auckland.htmlconvert

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
abstract class MarkdownIntegrationTest {

    /**
     * Conversion stack
     */
    @Inject HtmlConversionService conversionService;


    protected String html2markdown(String html) {
        def conv = new Conversion(html);
        conversionService.process(conv);
        return conv.markdown;
    }

}
