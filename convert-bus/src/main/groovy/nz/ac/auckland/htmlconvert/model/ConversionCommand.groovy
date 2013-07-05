package nz.ac.auckland.htmlconvert.model

import nz.ac.auckland.htmlconvert.pattern.ConversionPattern
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  A simple container class that matches up and element and its conversion operation
 */
class ConversionCommand {

    /**
     * Is the element to operate on
     */
    Element element;

    /**
     * Is the pattern to execute.
     */
    ConversionPattern pattern;
}
