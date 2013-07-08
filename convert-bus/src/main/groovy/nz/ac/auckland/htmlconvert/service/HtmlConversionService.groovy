package nz.ac.auckland.htmlconvert.service

import groovy.transform.CompileStatic
import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.model.Conversion
import nz.ac.auckland.htmlconvert.model.ConversionCommand
import org.jsoup.Jsoup
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject

/**
 * Author: Marnix
 *
 * This service converts HTML to Markdown
 */
@CompileStatic
@UniversityComponent
class HtmlConversionService {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(HtmlConversionService);

    /**
     * Conversion operations detector
     */
    @Inject FindConversionOperations findOperations;

    /**
     * Able to output a tree
     */
    @Inject TreeOutputIterator outputIterator;

    /**
     * Convert HTML to markdown
     *
     * @param conversion is the conversion structure to process
     * @return is the markdown that results from it
     */
    public void process(Conversion conversion) {

        // nothing to convert?
        if (!conversion?.html) {
            return;
        }

        LOG.info("UUID: ${conversion.uuid}, converting: ${conversion.html}");

        // setup Jsoup document
        conversion.doc = Jsoup.parse(conversion.html);

        // postfix recursion through tree to setup operations
        List<ConversionCommand> operations = findOperations.getConversionCommands(conversion);

        // perform the conversion (in the correct order)
        operations?.each { ConversionCommand operation ->
            String result = operation.pattern.convert(operation.element, conversion);
            conversion.mapping.converted(operation.element, result);
        }

        // output the result
        conversion.markdown = outputIterator.outputTree(conversion);
    }

}
