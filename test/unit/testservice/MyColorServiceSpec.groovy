package testservice

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import spock.lang.Specification

//import spock.lang.Specification
/**
 * User: bhaarat
 */
@TestFor(MyColorService)
@TestMixin(DomainClassUnitTestMixin)
@Mock([Color, Shade, ColorShade])
class MyColorServiceSpec extends Specification {
    def color

    def setup() {
        color = new Color(name: "red")
        color.save(flush: true)
    }

    def "test colors by shade" () {
        expect:
            1 == Color.count
            "red" == Color.all[0].name
            "red" == Color.getAll([1]).name
    }
}
