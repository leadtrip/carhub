package carhub.v1

import carhub.Car
import com.github.rahulsom.swaggydoc.SwaggyList
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiOperation
import grails.rest.RestfulController
import org.hibernate.criterion.CriteriaSpecification

@Api( value = 'car', description = "Car v1 management API" )
class CarV1Controller extends RestfulController<Car> {

    static responseFormats = ['json', 'xml', 'hal']

    CarV1Controller() {
        super( Car, true )
    }

    @Override
    protected List<Car> listAllResources(Map params) {
        Car.withCriteria( params ) {
            resultTransformer( CriteriaSpecification.ALIAS_TO_ENTITY_MAP )
            projections{
                property( 'id', 'id' )
                property( 'manufacturer', 'manufacturer' )
                property( 'model', 'model' )
                property( 'bhp', 'bhp' )
            }
        }
    }

}
