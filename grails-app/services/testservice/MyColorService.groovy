package testservice

class MyColorService {

    List<Color> colorsByShade(String shade) {
        def shadeId = Shade.findByName(shade)
        def colors = ColorShade.findAllByShade(shadeId)
        return colors
    }

}
