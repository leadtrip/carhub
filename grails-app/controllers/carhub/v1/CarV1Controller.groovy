package carhub.v1

import carhub.Car
import grails.rest.RestfulController

class CarV1Controller extends RestfulController<Car> {

    static responseFormats = ['json', 'xml']

    CarV1Controller() {
        super( Car )
    }
}
