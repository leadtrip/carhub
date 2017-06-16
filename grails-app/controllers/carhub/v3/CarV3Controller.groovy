package carhub.v3

import carhub.Car
import carhub.v2.CarV2Controller
import com.wordnik.swagger.annotations.Api
import grails.rest.RestfulController
import org.hibernate.criterion.CriteriaSpecification

@Api( value = 'car', description = "Car v3 management API" )
class CarV3Controller extends CarV2Controller{

    @Override
    protected List<Car> listAllResources(Map params) {
        Car.withCriteria( params ) {}
    }
}
