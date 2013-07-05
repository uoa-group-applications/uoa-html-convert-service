package nz.ac.auckland.htmlconvert.pattern

import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 */
interface ConversionPattern {

    boolean matches(Element el);

    String convert(Element el);

}
