package nz.ac.auckland.htmlconvert.bus

import nz.ac.auckland.syllabus.events.Event
import nz.ac.auckland.syllabus.events.EventHandler

/**
 * Author: Marnix
 *
 * The html to markdown event handler
 */
@Event(namespace = "uoa", name = "html-to-markdown")
class HtmlToMarkdownEvent implements EventHandler<HtmlToMarkdownRequest, HtmlToMarkdownResponse> {

    /**
     * Implement methods
     *
     * @param payload is the payload to process
     * @return the resulting markdown
     *
     * @throws Exception
     */
    @Override
    public HtmlToMarkdownResponse handleEvent(HtmlToMarkdownRequest payload) throws Exception {
        return new HtmlToMarkdownResponse();
    }
}
