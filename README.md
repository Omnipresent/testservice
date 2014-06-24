
grails test-app unit: gives

java.lang.UnsupportedOperationException: String-based queries like [find] are currently not supported in this implementation of GORM. Use criteria instead.

adding 


dependencies {
    test "org.grails:grails-datastore-test-support:1.0-grails-2.4"
    }

gives error


java.lang.NoClassDefFoundError: grails/test/runtime/TestPluginRegistrar
    at org.apache.tools.ant.UnknownElement.execute(UnknownElement.java:291)

