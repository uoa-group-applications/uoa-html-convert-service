package nz.ac.auckland.htmlconvert.service

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  Output the Markdown version of the HTML tree.
 */
@UniversityComponent
class TreeOutputIterator {

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
        conversion.doc.childNodes().each { Element domElement ->
            String result = conversion.conversions.conversionOf(domElement);
            builder.append(result);
        }

        return builder.toString();
    }

}
