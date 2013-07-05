package nz.ac.auckland.htmlconvert.model

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.nodes.TextNode

import java.awt.TrayIcon.MessageType

import static java.awt.TrayIcon.MessageType.INFO

/**
 *  Author: Marnix
 *
 *  This class functions as a baton that gets passed around the conversion process and is enriched
 *  with useful information.
 */
class Conversion {

    /**
     * Unique identifier for this translation
     */
    String uuid;

    /**
     * Html to process
     */
    String html;

    /**
     * Jsoup version of HTML document
     */
    Document doc;

    /**
     * Conversion map
     */
    ConversionMap mapping;


    /**
     * Markdown that is being built
     */
    String markdown;


    /**
     * Initialize data-members properly
     *
     * @param html is the HTML to convert
     */
    public Conversion(String html) {
        this.html = html;
        this.uuid = UUID.randomUUID();
        this.mapping = new ConversionMap();
    }

    /**
     * Interpolate the contents of an element by looking up substitutable values
     *
     * @param element is the element to interpolate
     * @return is the interpolated string value
     */
    public String interpolate(Element element) {

        StringBuilder strBuilder = new StringBuilder();

        element.childNodes()?.each { org.jsoup.nodes.Node child ->

            if (child instanceof TextNode) {
                strBuilder.append(child.text());
            }
            else if (child instanceof Element) {
                String childConversion = this.mapping.conversionOf(child as Element);
                if (childConversion) {
                    strBuilder.append(childConversion);
                }
                else {
                    strBuilder.append(child.text());
                }
            }
        }

        return strBuilder.toString();
    }
}
