package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  Matches the header information
 */
@UniversityComponent
class HeadersPattern implements ConversionPattern {

    /**
     * @return true if it matches a header
     */
    private static final String HEAD_END = "\n\n"

    @Override
    public boolean matches(Element element) {
        String tag = element.tagName();

        return  tag.length() == 2 &&
                tag[0].toLowerCase() == "h" &&
                tag[1].isNumber();

    }

    /**
     * Convert from jsoup element into a
     *
     * @param element is the element to convert
     * @return a markdown string
     */
    @Override
    public String convert(Element element, Conversion conversion = null) {
        String tag = element.tagName();
        int length = tag[1].toInteger();
        return repeatHashes(length) + " " + element.text() + HEAD_END
    }

    /**
     * @return a string of `length` number of hashes
     */
    protected String repeatHashes(int length) {
        String headerType = "";
        for (int idx = 0; idx < length; ++idx) {
            headerType += "#";
        }
        headerType
    }
}
