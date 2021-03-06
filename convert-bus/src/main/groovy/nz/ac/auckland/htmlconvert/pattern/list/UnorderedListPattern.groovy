package nz.ac.auckland.htmlconvert.pattern.list

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 */
@UniversityComponent
class UnorderedListPattern implements ConversionPattern {

    private static final String LIST_END = "\n"

    @Override
    boolean matches(Element element) {
        return element?.tagName()?.toLowerCase() == "ul";
    }

    /**
     * Convert an ordered list's content into an ordered markdown list
     *
     * @param element
     * @param conversion
     * @return
     */
    @Override
    String convert(Element element, Conversion conversion) {
        String content = "";

        // children should be li's
        element.childNodes()?.each { org.jsoup.nodes.Node node ->

            // get the mapping of the list item (should always have been converted).
            String listItemContent

            if (node instanceof Element) {
                listItemContent = conversion.mapping.conversionOf(node as Element)
            }
            else {
                listItemContent = node.toString()?.trim();
            }

            if (listItemContent.empty) {
                return;
            }

            // make them indent nicely
            listItemContent = listItemContent?.replace("\n", "\n\t");

            content += "*\t${listItemContent}\n";

        }

        return content + LIST_END;
    }
}
