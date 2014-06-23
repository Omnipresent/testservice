package testservice

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.domain.DomainClassUnitTestMixin
import grails.test.mixin.hibernate.HibernateTestMixin
import spock.lang.Specification

//import spock.lang.Specification
/**
 * User: bhaarat
 */
@TestFor(MyColorService)
@TestMixin(HibernateTestMixin)
@Mock([Color, Shade, ColorShade])
class MyColorServiceSpec extends Specification {

    def color
    def shade

    def setup() {
        color = new Color(name: "red")
        shade = new Shade(name: "dark")
        color.save(flush: true)
        shade.save(flush: true)
        ColorShade.create(color, shade, false)
    }

    def cleanup() {

    }

    def "test colors by shade" () {
        expect:
            1 == service.colorsByShade("dark")
            0 == service.colorsByShade("light")
    }


}
