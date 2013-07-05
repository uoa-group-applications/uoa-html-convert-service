package nz.ac.auckland.htmlconvert.bus

import nz.ac.auckland.htmlconvert.model.Conversion
import nz.ac.auckland.htmlconvert.service.HtmlConversionService
import nz.ac.auckland.syllabus.events.Event
import nz.ac.auckland.syllabus.events.EventHandler

import javax.inject.Inject

import static nz.ac.auckland.htmlconvert.core.AppConstants.*

/**
 * Author: Marnix
 *
 * The html to markdown event handler
 */
@Event(namespace = NS_UOA, name = "html-to-markdown")
class HtmlToMarkdownEvent implements EventHandler<HtmlToMarkdownRequest, HtmlToMarkdownResponse> {

    /**
     * Conversion service injected
     */
    @Inject HtmlConversionService conversionService;

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

        if (!payload) {
            throw new IllegalArgumentException("Expected valid payload");
        }

        Conversion conversion = this.convertHtml(payload.html);

        return new HtmlToMarkdownResponse(
                uuid: conversion.uuid,
                markdown: conversion.markdown,
                report: conversion.report
        );
    }

    /**
     * Retrieve the markdown input for some HTML
     *
     * @param htmlInput the HTML to process
     * @return Conversion instance that contains the converted markdown and its report
     */
    protected Conversion convertHtml(String htmlInput) {
        Conversion conversion = new Conversion(htmlInput);
        conversionService.process(conversion);
        return conversion;
    }

}
