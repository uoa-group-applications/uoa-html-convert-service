package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**

 * author: Richard Vowles - http://gplus.to/RichardVowles
 */
@UniversityComponent
class DivPattern implements ConversionPattern {

	@Override
	boolean matches(Element element) {
		return element?.tagName()?.toLowerCase() == "div";
	}

	@Override
	String convert(Element element, Conversion conversion) {
		return conversion.interpolate(element).trim()
	}
}
