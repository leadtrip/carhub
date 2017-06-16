package carhub

import grails.rest.Resource

//@Resource( uri='/cars', formats=['json', 'xml'] )
class Car {

    String model
    String manufacturer
    String aspiration
    Integer weight
    Integer valves
    Integer cylinders
    Integer bhp
    Integer displacement
    String zeroToSixty
    Integer topSpeed

    static hasMany = [images: Image]

    static constraints = {
        model nullable: false
        aspiration nullable: false
        weight nullable: false
        valves nullable: false
        cylinders nullable: false
        bhp nullable: false
        displacement nullable: false
        zeroToSixty nullable: false
        topSpeed nullable: false
    }
}
