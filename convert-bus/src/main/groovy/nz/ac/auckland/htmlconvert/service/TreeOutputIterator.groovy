package nz.ac.auckland.htmlconvert.service

import groovy.transform.CompileStatic
import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 *  Author: Marnix
 *
 *  Output the Markdown version of the HTML tree.
 */
@CompileStatic
@UniversityComponent
class TreeOutputIterator {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(TreeOutputIterator);

    /**
     * Output the markdown tree by traversing through the jsoup document's root elements
     * and outputting any of those root elements that have an associated conversion.
     *
     * @param conversion is the conversion information to use for output
     * @return is a markdown string
     */
    public String outputTree(Conversion conversion) {

        StringBuilder builder = new StringBuilder();

        // iterate through root nodes and create output
        conversion.doc.select("body > *")?.each { Element domElement ->
            LOG.info("domElement: " + domElement.toString());
            String result = conversion.mapping.conversionOf(domElement);
            if (result) {
                builder.append(result);
            }
        }

        return builder.toString();
    }

}
