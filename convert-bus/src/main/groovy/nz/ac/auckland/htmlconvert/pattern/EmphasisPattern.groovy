package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *
 *  Replaces <i> or <em> tag with _content_
 */
@UniversityComponent
class EmphasisPattern implements ConversionPattern {


    @Override
    boolean matches(Element element) {
        String tag = element?.tagName()?.toLowerCase();
        return tag == "em" || tag == "i";
    }

    @Override
    String convert(Element element, Conversion conversion) {
        return "_" + conversion.interpolate(element) + "_";
    }

}
