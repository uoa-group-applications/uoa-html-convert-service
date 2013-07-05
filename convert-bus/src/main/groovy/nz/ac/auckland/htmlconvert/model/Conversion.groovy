package nz.ac.auckland.htmlconvert.model

import org.jsoup.nodes.Document
import org.jsoup.nodes.Element

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
    ConversionMap conversions;


    /**
     * Markdown that is being built
     */
    String markdown;

    /**
     * List of conversion messages
     */
    List<ConversionMessage> report = [];

    /**
     * Initialize data-members properly
     *
     * @param html is the HTML to convert
     */
    public Conversion(String html) {
        this.html = html;
        this.uuid = UUID.randomUUID();
    }


    public void log(Element el, String message, MessageType type = INFO) {
        report << new ConversionMessage(from: el.html(), message: message, type: type)
    }
}
