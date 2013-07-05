package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 *  Creates a conversion for image tags into a markdown syntax.
 */
@UniversityComponent
class ImagesPattern implements ConversionPattern {

    /**
     * @return true if the image tag was found
     */
    @Override
    public boolean matches(Element element) {
        return  element?.tagName()?.toLowerCase() == "img" &&
                element.attr("src")?.length() > 0;
    }

    /**
     * @return the image tag
     */
    @Override
    public String convert(Element element, Conversion conversion) {
        String url = element.attr("src");
        String alt = element.attr("alt") ?: "Image"

        return "![$alt]($url)";
    }
}
