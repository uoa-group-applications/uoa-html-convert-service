package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  Matches the <a />-tag
 */
@UniversityComponent
class AnchorPattern implements ConversionPattern {

    /**
     * Determine whether this is a valid anchor tag to parse
     *
     * @param element is the element we are trying to parse
     * @return true if the element is parseable as an anchor tag
     */
    @Override
    public boolean matches(Element element) {
        return element.tagName().toLowerCase() == "a" &&                    // is an anchor tag
               element.text()?.trim()?.length() > 0 &&                      // has a text
               element.attr("href") && element.attr("href")[0] != "#"       // has href and is not anchor
        ;
    }

    /**
     * Convert from anchor tag to markdown link notation
     *
     * @param element
     * @param conversion
     * @return
     */
    @Override
    public String convert(Element element, Conversion conversion = null) {

        String  label = element.text().trim(),
                title = element.attr("title").trim(),
                href = element.attr("href").trim();

        return "[${label}${title ? " \"$title\"" : ""}]($href)"
    }
}
