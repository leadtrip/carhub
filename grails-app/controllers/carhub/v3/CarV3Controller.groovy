package carhub.v3

import carhub.Car
import com.wordnik.swagger.annotations.Api
import grails.rest.RestfulController

@Api( value = 'car', description = "Car v3 management API" )
class CarV3Controller extends RestfulController<Car> {

    static responseFormats = ['json', 'xml']

    CarV3Controller() {
        super( Car )
    }

}
