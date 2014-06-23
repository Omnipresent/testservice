package testservice
/**
 * User: bhaarat
 */
class ColorShade implements Serializable {

    Color color
    Shade shade

    static ColorShade create (Color blacklist, Shade network, boolean flush = false) {
        def restrictionInstance = get(blacklist.id as long, network.id as long)
        if (restrictionInstance == null)
            new ColorShade(blacklist: blacklist, network: network, dateCreated: new Date()).save(flush:  flush)
    }

    static ColorShade get (long colorId, long shadeId) {
        ColorShade.find 'from ColorShade where color.id = :colorId and shade.id = :shadeId',
                [blacklistId: colorId, networkId: shadeId]
    }

    static  findAllByShade(long shadeId) {
        ColorShade.findAll 'from ColorShade where shade.id = :shadeId', [shadeId: shadeId]
    }
}
