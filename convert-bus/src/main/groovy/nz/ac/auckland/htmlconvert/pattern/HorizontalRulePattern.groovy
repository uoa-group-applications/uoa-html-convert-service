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
class HorizontalRulePattern implements ConversionPattern {

    @Override
    boolean matches(Element element) {
        return element?.tagName()?.toLowerCase() == "hr";
    }

    @Override
    String convert(Element element, Conversion conversion) {
        return "---\n\n";
    }
}
