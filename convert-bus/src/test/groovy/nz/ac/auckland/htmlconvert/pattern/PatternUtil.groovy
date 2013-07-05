package nz.ac.auckland.htmlconvert.pattern

import org.jsoup.Jsoup
import org.jsoup.nodes.Element

/**
 *  Author: Marnix
 *
 */
class PatternUtil {

    public static Element forHtml(String html) {
        return Jsoup.parse(html).select("body > *:eq(0)").get(0);
    }



}
