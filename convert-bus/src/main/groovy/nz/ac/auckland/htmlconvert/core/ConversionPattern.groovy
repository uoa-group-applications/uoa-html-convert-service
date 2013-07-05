package nz.ac.auckland.htmlconvert.core

import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  A conversion pattern is a Jsoup element that can be translated to its equivalent in Markdown
 */
interface ConversionPattern {

    /**
     * Does this pattern apply to anything?
     *
     * @param el is the element to check a match on
     * @return true if the match has happened
     */
    boolean matches(Element element);

    /**
     * Convert from an HTML element to something we can use
     *
     * @param el is the element to convert
     * @return a markdown string
     */
    String convert(Element element, Conversion conversion);

}
