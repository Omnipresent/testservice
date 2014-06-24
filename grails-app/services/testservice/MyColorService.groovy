package testservice

class MyColorService {

    List<String> colorsByShade(String shade) {
        def shadeId = Shade.findByName(shade)
//        def colors = ColorShade.findAllByShade(shadeId)
//        return ["three","four"]
        return ColorShade.findAllByShade(1)
    }

}
