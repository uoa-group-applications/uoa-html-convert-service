package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  A transformation from blockquote to the markdown variation
 */
@UniversityComponent
class BlockquotePattern implements ConversionPattern {

    private static final String BLOCKQUOTE_START = "> "
    private static final String BLOCKQUOTE_END = "\n\n"

    @Override
    public boolean matches(Element element) {
        return element?.tagName()?.toLowerCase() == "blockquote";
    }

    @Override
    public String convert(Element element, Conversion conversion) {
        String contents = conversion.interpolate(element).trim();
        contents = BLOCKQUOTE_START + contents.replace("\n", "\n" + BLOCKQUOTE_START);
        return contents + BLOCKQUOTE_END;
    }
}
