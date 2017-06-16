import carhub.Authority
import carhub.Car
import carhub.Image
import carhub.User
import carhub.UserAuthority
import grails.converters.JSON

class BootStrap {

    def carMarshaller() {
        JSON.registerObjectMarshaller(Car) { car ->
            [
                    manufacturer: car.manufacturer,
                    model       : car.model,
                    aspiration  : car.aspiration,
                    weight      : car.weight,
                    valves      : car.valves,
                    cylinders   : car.cylinders,
                    bhp         : car.bhp,
                    displacement: car.displacement,
                    zeroToSixty : car.zeroToSixty,
                    topSpeed    : car.topSpeed,
                    images      : car.images.collect { image ->
                        [
                                id : image.id,
                                uri: image.uri
                        ]
                    }
            ]
        }
    }
    def init = { servletContext ->

        carMarshaller()

        if( !User.findByUsername( 'mikew' ) ) {
            def role1 = new Authority(authority: "ROLE_USER").save flush: true
            def user1 = new User(username: "mikew", password: "password1").save flush: true
            UserAuthority.create(user1, role1)
        }

        def mercS63 = new Car( model: 'S63', manufacturer: 'Mercedes', aspiration: 'Turbocharged', weight: 2070, valves: 32, cylinders: 8, bhp: 518, displacement: 6208, zeroToSixty: '4.5', topSpeed: 155 ).save( failOnError: true )
        def mercGts = new Car( model: 'GTS', manufacturer: 'Mercedes', aspiration: 'Turbocharged', weight: 1645, valves: 32, cylinders: 8, bhp: 502, displacement: 3982, zeroToSixty: 3.7, topSpeed: 193 ).save( failOnError: true )
        def mclarenF1 = new Car( model: 'F1', manufacturer: 'McLaren', aspiration: 'Natural', weight: 1140, valves: 48, cylinders: 12, bhp: 627, displacement: 6064, zeroToSixty: '3.2', topSpeed: 240 ).save( failOnError: true )
        def lotusEvora = new Car( model: 'Evora', manufacturer: 'Lotus', aspiration: 'Natural', weight: 1350, valves: 24, cylinders: 6, bhp: 276, displacement: 3456, zeroToSixty: '4.9', topSpeed: 160 ).save( failOnError: true )
        def nissanGtr = new Car( model: 'GT-R Spec V', manufacturer: 'Nissan', aspiration: 'Turbocharged', weight: 1680, valves: 24, cylinders: 6, bhp: 478, displacement: 3799, zeroToSixty: '3.4', topSpeed: 193 ).save( failOnError: true )
        def subaruImpreza = new Car( model: 'Impreza STI Type RA Spec C', manufacturer: 'Subaru', aspiration: 'Turbocharged', weight: 1380, valves: 16, cylinders: 4, bhp: 335, displacement: 1994, zeroToSixty: '4.3', topSpeed: 160 ).save( failOnError: true )

        new Image( car: mercS63, uri: 'http://gtspirit.com/wp-content/uploads/2015/08/vossen-merc-s63amg-matte-11.jpg' ).save( failOnError: true )
        new Image( car: mercGts, uri: 'http://www.mercedes-amg.com/img/vehicles/gts/media/gallery1/standard/06.jpg' ).save( failOnError: true )
        new Image( car: mclarenF1, uri: 'https://www.supercars.net/blog/wp-content/uploads/2016/03/Screenshot-2016-03-24-12.48.38.png' ).save( failOnError: true )
        new Image( car: lotusEvora, uri: 'http://www.lotuscars.com/sites/default/files/image_store/24871_e400-black-pack-2_800x474.jpg' ).save( failOnError: true )
        new Image( car: nissanGtr, uri: 'https://www.nissan-cdn.net/content/dam/Nissan/global/vehicles/gt-r/r35/2_minor_change/overview/17TDIeulhd_GTRHelios026.jpg.ximg.l_full_m.smart.jpg' ).save( failOnError: true )
        new Image( car: nissanGtr, uri: 'http://o.aolcdn.com/commerce/autodata/images/CAC70NIC131A021001.jpg' ).save( failOnError: true )
        new Image( car: subaruImpreza, uri: 'https://images.cdn.autocar.co.uk/sites/autocar.co.uk/files/styles/gallery_slide/public/subaru-impreza-wrx-sti-rt-016.JPG?itok=HW3R_zUh' ).save( failOnError: true )

    }

    def destroy = {
    }
}
