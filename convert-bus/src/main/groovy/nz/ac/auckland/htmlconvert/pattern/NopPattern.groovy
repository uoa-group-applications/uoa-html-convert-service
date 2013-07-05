package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import org.jsoup.nodes.Element
import sun.reflect.generics.reflectiveObjects.NotImplementedException

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
    public String convert(Element el) {
        throw new UnsupportedOperationException("Convert doesn't work for NOP class");
    }
}
