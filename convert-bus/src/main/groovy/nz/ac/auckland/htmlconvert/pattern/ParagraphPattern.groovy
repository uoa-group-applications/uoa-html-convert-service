package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

/**
 *  Author: Marnix
 *
 *  Paragraph pattern
 */
@UniversityComponent
class ParagraphPattern implements ConversionPattern {

    /**
     * A paragraph ends by adding two line breaks
     */
    private static final String PAR_END = "\n\n"

    @Override
    public boolean matches(Element element) {
        return element.tagName()?.toLowerCase() == "p";
    }

    @Override
    public String convert(Element element, Conversion conversion) {
        return conversion.interpolate(element) + PAR_END;
    }
}
