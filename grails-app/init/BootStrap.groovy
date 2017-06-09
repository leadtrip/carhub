import carhub.Authority
import carhub.Car
import carhub.User
import carhub.UserAuthority

class BootStrap {

    def init = { servletContext ->

        if( !User.findByUsername( 'mikew' ) ) {
            def role1 = new Authority(authority: "ROLE_USER").save flush: true
            def user1 = new User(username: "mikew", password: "password1").save flush: true
            UserAuthority.create(user1, role1)
        }

        new Car( model: 'S63', manufacturer: 'Mercedes', aspiration: 'Turbocharged', weight: 2070, valves: 32, cylinders: 8, bhp: 518, displacement: 6208, zeroToSixty: '4.5', topSpeed: 155 ).save( failOnError: true )
        new Car( model: 'F1', manufacturer: 'McLaren', aspiration: 'Natural', weight: 1140, valves: 48, cylinders: 12, bhp: 627, displacement: 6064, zeroToSixty: '3.2', topSpeed: 240 ).save( failOnError: true )
        new Car( model: 'Evora', manufacturer: 'Lotus', aspiration: 'Natural', weight: 1350, valves: 24, cylinders: 6, bhp: 276, displacement: 3456, zeroToSixty: '4.9', topSpeed: 160 ).save( failOnError: true )
        new Car( model: 'GT-R Spec V', manufacturer: 'Nissan', aspiration: 'Turbocharged', weight: 1680, valves: 24, cylinders: 6, bhp: 478, displacement: 3799, zeroToSixty: '3.4', topSpeed: 193 ).save( failOnError: true )
        new Car( model: 'Impreza STI Type RA Spec C', manufacturer: 'Subaru', aspiration: 'Turbocharged', weight: 1380, valves: 16, cylinders: 4, bhp: 335, displacement: 1994, zeroToSixty: '4.3', topSpeed: 160 ).save( failOnError: true )
    }

    def destroy = {
    }
}
