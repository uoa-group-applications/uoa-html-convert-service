package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 */
@UniversityComponent
class LinebreakPattern implements ConversionPattern {

    /**
     * @return true if it's a br
     */
    @Override
    boolean matches(Element element) {
        return element?.tagName()?.toLowerCase() == "br";
    }

    @Override
    String convert(Element element, Conversion conversion) {
        return "  \n";
    }
}
