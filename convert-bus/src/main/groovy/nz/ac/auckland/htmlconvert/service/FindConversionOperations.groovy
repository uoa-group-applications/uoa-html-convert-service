package nz.ac.auckland.htmlconvert.service

import groovy.transform.CompileStatic
import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.model.Conversion
import nz.ac.auckland.htmlconvert.model.ConversionCommand
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import org.jsoup.nodes.Document
import org.jsoup.nodes.Element
import org.jsoup.parser.Tag
import org.jsoup.select.Elements
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.inject.Inject

/**
 *  Author: Marnix
 *
 *  This class is able to step through a tree of jsoup nodes and find conversion patterns
 *  and store them in the order that they need to be processed.
 */
@CompileStatic
@UniversityComponent
class FindConversionOperations {

    /**
     * Patterns to rifle through
     */
    @Inject List<ConversionPattern> patterns;

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(FindConversionOperations);

    /**
     * Get a list of commands that should be executed by recursively stepping through
     * the tree and finding things that could be matching.
     *
     * @param conversion
     * @return
     */
    public List<ConversionCommand> getConversionCommands(Conversion conversion) {
        // postfix recursion through tree to setup operations
        List<ConversionCommand> operations = [];

        // visit and find operations
        postfixVisit(conversion.doc) { Element domElement ->

            // find a pattern for this node
            ConversionPattern pattern = patterns.find { ConversionPattern pattern ->
                pattern.matches(domElement);
            }

            // this is translatable?
            if (pattern) {
                ConversionCommand operation = new ConversionCommand(
                        element: domElement,
                        pattern: pattern
                );

                operations << operation;

                LOG.debug("Going to process: ${domElement.tagName()}");
            }
            else {
                LOG.info("No pattern found for: ${domElement.tagName()}");
            }
        }

        return operations;
    }

    /**
     * Determine whether the document has a child tag, and if not, if it still has text
     *
     * @param document is the document to inspect
     * @return true if no tag, but text was found
     */
    protected boolean hasNoTagsJustText(Document document) {
        return document.select("body > *").size() == 0 && !document.select("body")?.text()?.trim().empty;
    }

    /**
     * Move the body text into a paragraph tag for conversion
     * @param document is the document to change the body node of
     */
    protected void wrapBodyTextInParagraph(Document document) {
        Element pTag = new Element(Tag.valueOf("p"), "");
        Elements bodyTagContents = document.select("body");

        pTag.text(bodyTagContents.text());
        bodyTagContents.html(pTag.toString());
    }

    /**
     * Recursively step through the tree in a postfix fashion and execute the closure.
     *
     * @param doc is the document tree to iterate through
     * @param operation is the operation to perform at every node
     */
    protected void postfixVisit(Document doc, Closure operation) {

        Closure postfixNode = null;

        // postfix node visitor
        postfixNode = { Element element ->

            // first dig to the leaf
            element.childNodes()?.each { org.jsoup.nodes.Node child ->

                // no textnode recursion
                if (child instanceof Element) {
                    postfixNode.call(child as Element)
                }

            }

            // execute when done calling children
            operation.call(element);
        }

        if (hasNoTagsJustText(doc)) {
            wrapBodyTextInParagraph(doc);
        }

        // set off the recursion
        doc.select("body > *")?.each { org.jsoup.nodes.Node rootTag ->
            postfixNode.call(rootTag as Element);
        }
    }

}
