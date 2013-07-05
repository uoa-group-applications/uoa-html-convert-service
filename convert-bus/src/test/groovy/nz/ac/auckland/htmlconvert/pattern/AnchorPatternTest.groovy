package nz.ac.auckland.htmlconvert.pattern

import org.junit.Test

/**
 *  Author: Marnix
 *
 */
class AnchorPatternTest {

    AnchorPattern ptn = new AnchorPattern();

    @Test
    public void shouldConvertProperly() {
        assert ptn.convert(PatternUtil.forHtml('<a href="http://google.com">Google</a>')) ==
                "[Google](http://google.com)"
        ;

        assert ptn.convert(PatternUtil.forHtml('<a title="My title" href="http://google.com">Google</a>')) ==
                "[Google \"My title\"](http://google.com)"
        ;

        assert ptn.convert(PatternUtil.forHtml('<a href="http://google.com">  Google  </a>')) ==
                "[Google](http://google.com)";
        ;
    }

    @Test
    public void validAnchors() {
        assert ptn.matches(PatternUtil.forHtml('<a href="http://google.com">Google</a>'));
        assert ptn.matches(PatternUtil.forHtml('<a title="My title" href="http://google.com">Google</a>'));
        assert ptn.matches(PatternUtil.forHtml('<a href="http://google.com">  Google  </a>'));
    }

    @Test
    public void shouldNotAcceptWithoutText() {
        assert !ptn.matches(PatternUtil.forHtml('<a href="/"></a>'));
        assert !ptn.matches(PatternUtil.forHtml('<a href="/"> </a>'));
        assert !ptn.matches(PatternUtil.forHtml('<a href="/"><span></span></a>'));
        assert !ptn.matches(PatternUtil.forHtml('<a href="/"><span> </span></a>'));
    }

    @Test
    public void shouldNotAcceptAnchors() {
        assert !ptn.matches(PatternUtil.forHtml('<a name="">My anchor tag</a>'));
    }

}
