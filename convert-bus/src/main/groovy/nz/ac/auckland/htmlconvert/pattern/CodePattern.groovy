package nz.ac.auckland.htmlconvert.pattern

import nz.ac.auckland.common.stereotypes.UniversityComponent
import nz.ac.auckland.htmlconvert.core.ConversionPattern
import nz.ac.auckland.htmlconvert.model.Conversion
import org.jsoup.nodes.Element

/**

 * author: Richard Vowles - http://gplus.to/RichardVowles
 */
@UniversityComponent
class CodePattern implements ConversionPattern {

	private static final String CODE_START = "    "
	private static final String CODE_END = "\n\n"

	@Override
	public boolean matches(Element element) {
		return element?.tagName()?.toLowerCase() == "code";
	}

	@Override
	public String convert(Element element, Conversion conversion) {
		String contents = conversion.interpolate(element).trim();
		contents = "\n\n" + CODE_START + contents.replace("\n", "\n" + CODE_START);
		return contents + CODE_END;
	}
}
