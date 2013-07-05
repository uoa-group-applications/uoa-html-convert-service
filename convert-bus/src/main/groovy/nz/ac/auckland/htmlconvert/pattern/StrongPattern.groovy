package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  Replaces Strong or bold tag with **<content>**
 */
@UniversityComponent
class StrongPattern implements ConversionPattern {

    @Override
    boolean matches(Element element) {
        String tag = element?.tagName()?.toLowerCase();
        return tag == "strong" || tag == "b";
    }

    @Override
    String convert(Element element, Conversion conversion) {
        return "**" + conversion.interpolate(element) + "**";
    }
}
