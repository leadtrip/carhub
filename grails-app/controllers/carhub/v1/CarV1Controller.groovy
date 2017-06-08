package carhub.v1

import carhub.Car
import com.github.rahulsom.swaggydoc.SwaggyList
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import grails.rest.RestfulController

@Api( value = 'car', description = "Car v1 management API" )
class CarV1Controller extends RestfulController<Car> {

    static responseFormats = ['json', 'xml']

    CarV1Controller() {
        super( Car )
    }

    @SwaggyList
    def index(Integer max) {
        super.index(max)
    }

    @ApiOperation( value = 'Create car from HTML interface only', hidden = true )
    def create() {
        super.create()
    }

    @ApiOperation( value = 'Create a new car' )
    def save() {
        super.save()
    }
}
