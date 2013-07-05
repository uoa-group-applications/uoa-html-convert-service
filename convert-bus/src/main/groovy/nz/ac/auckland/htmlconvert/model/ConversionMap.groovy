package nz.ac.auckland.htmlconvert.model

import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 */
class ConversionMap {

    private HashMap<Element, String> conversions = [:];

    /**
     * Something has been converted, store it
     *
     * @param from element that was converted
     * @param to the resulting string
     */
    public void converted(Element from, String to) {
        this.conversions.put(from, to);
    }

    /**
     * Get the converted text for a specific element
     *
     * @param from
     * @return
     */
    public String conversionOf(Element from) {
        return this.conversions.get(from);
    }

}
