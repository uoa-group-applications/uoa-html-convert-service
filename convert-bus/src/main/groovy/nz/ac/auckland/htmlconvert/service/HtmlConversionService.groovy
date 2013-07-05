package nz.ac.auckland.htmlconvert.service

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.Jsoup

import javax.inject.Inject

/**
 * Author: Marnix
 *
 * This service converts HTML to Markdown
 */
@UniversityComponent
class HtmlConversionService {

    /**
     * Convert HTML to markdown
     *
     * @param conversion is the conversion structure to process
     * @return is the markdown that results from it
     */
    public void process(Conversion conversion) {

        // nothing to convert?
        if (!conversion?.html) {
            return;
        }

        // setup Jsoup document
        conversion.doc = Jsoup.parse(conversion.html);


    }



}
