package nz.ac.auckland.htmlconvert.core

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  This is the NOP conversion pattern that makes sure the spring stuff works.
 */
@UniversityComponent
class NopPattern implements ConversionPattern {

    /**
     * @return always false, should never match.
     */
    @Override
    public boolean matches(Element el) {
        return false;
    }

    @Override
    public String convert(Element el, Conversion conversion) {
        throw new UnsupportedOperationException("Convert doesn't work for NOP class");
    }
}
