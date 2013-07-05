package nz.ac.auckland.htmlconvert.pattern.list

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  This matches on <li/>-tags
 */
@UniversityComponent
class ListItemPattern implements ConversionPattern {

    /**
     * @return true if is is a good match
     */
    private static final String ITEM_END = "\n"

    @Override
    public boolean matches(Element element) {
        return element?.tagName()?.toLowerCase() == "li";
    }

    /**
     * The list element's content is just its content
     *
     * @param element
     * @param conversion
     * @return
     */
    @Override
    public String convert(Element element, Conversion conversion) {
        return conversion.interpolate(element);
    }
}
