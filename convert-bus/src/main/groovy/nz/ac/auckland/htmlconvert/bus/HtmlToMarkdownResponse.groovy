package nz.ac.auckland.htmlconvert.bus

import nz.ac.auckland.syllabus.payload.EventResponseBase

/**
 *  Author: Marnix
 *
 *  Output structure for html->markdown event
 */
class HtmlToMarkdownResponse extends EventResponseBase {

    /**
     * The resulting markdown
     */
    String markdown;

    /**
     * Unique identifier that describes this conversion (logging purposes)
     */
    String uuid;

}
