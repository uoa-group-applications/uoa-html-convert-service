package nz.ac.auckland.htmlconvert.pattern

import org.jsoup.nodes.Element
import org.jsoup.parser.Tag
import org.junit.Test

import static nz.ac.auckland.htmlconvert.pattern.PatternUtil.forHtml

/**
 *  Author: Marnix
 *
 */
class HeadersPatternTest {

    @Test
    public void matchesHeaders() {
        HeadersPattern pattern = new HeadersPattern();
        Element el = null;

        el = new Element(Tag.valueOf("h1"), "/");
        assert pattern.matches(el);

        el = new Element(Tag.valueOf("h2"), "/");
        assert pattern.matches(el);

        el = new Element(Tag.valueOf("h3"), "/");
        assert pattern.matches(el);

        el = new Element(Tag.valueOf("h4"), "/");
        assert pattern.matches(el);

        el = new Element(Tag.valueOf("h5"), "/");
        assert pattern.matches(el);

        el = new Element(Tag.valueOf("h6"), "/");
        assert pattern.matches(el);

    }

    @Test
    public void doesntMatchOtherTwoSized() {
        HeadersPattern pattern = new HeadersPattern();
        Element el = null;
        el = new Element(Tag.valueOf("br"), "/");
        assert !pattern.matches(el);
    }

    @Test
    public void doesntMatchWeirdHeaders() {
        HeadersPattern pattern = new HeadersPattern();
        Element el = null;
        el = new Element(Tag.valueOf("h31a"), "/");
        assert !pattern.matches(el);
    }


    @Test
    public void convertToHtml() {
        HeadersPattern pattern = new HeadersPattern();
        assert pattern.convert(forHtml("<h1>This is my HTML</h1>")) == "# This is my HTML\n\n";
        assert pattern.convert(forHtml('<h1 class="attributes">This is my HTML</h1>')) == "# This is my HTML\n\n";
        assert pattern.convert(forHtml('<h2>This is my HTML</h2>')) == "## This is my HTML\n\n";
        assert pattern.convert(forHtml('<h3>This is my HTML</h2>')) == "### This is my HTML\n\n";
        assert pattern.convert(forHtml('<h4>This is my HTML</h2>')) == "#### This is my HTML\n\n";
        assert pattern.convert(forHtml('<h5>This is my HTML</h2>')) == "##### This is my HTML\n\n";
        assert pattern.convert(forHtml('<h6>This is my HTML</h2>')) == "###### This is my HTML\n\n";
    }

    @Test
    public void convertWithNested() {
        HeadersPattern pattern = new HeadersPattern();
        assert pattern.convert(forHtml("<h1><span>This is my HTML</span></h1>")) == "# This is my HTML\n\n";
    }




}
