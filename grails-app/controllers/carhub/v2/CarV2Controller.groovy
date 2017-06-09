package carhub.v2

import carhub.Car
import com.wordnik.swagger.annotations.Api
import com.wordnik.swagger.annotations.ApiImplicitParam
import com.wordnik.swagger.annotations.ApiImplicitParams
import com.wordnik.swagger.annotations.ApiOperation
import grails.rest.RestfulController
import org.hibernate.criterion.CriteriaSpecification

@Api( value = 'car', description = "Car v2 management API" )
class CarV2Controller extends RestfulController<Car> {

    static responseFormats = ['json', 'xml']

    CarV2Controller() {
        super( Car )
    }

    @ApiOperation( value = 'Retrieve all turbocharged cars' )
    def turbocharged() {
        respond Car.findAllByAspiration( 'Turbocharged' )
    }

    @ApiOperation( value = 'Search for cars' )
    @ApiImplicitParams([
            @ApiImplicitParam(name = 'manufacturer', paramType = 'query', required = false, dataType = 'String'),
            @ApiImplicitParam(name = 'model', paramType = 'query', required = false, dataType = 'String'),
            @ApiImplicitParam(name = 'aspiration', paramType = 'query', required = false, dataType = 'String')
    ])
    def search( params ) {
        respond Car.createCriteria().list {
            if ( params.manufacturer ) {
                ilike 'manufacturer', "%${params.manufacturer}%"
            }
            if ( params.aspiration ) {
                ilike 'aspiration', "%${params.aspiration}%"
            }
            if ( params.model ) {
                ilike 'model', "%${params.model}%"
            }
        }
    }

    @Override
    protected List<Car> listAllResources(Map params) {
        Car.withCriteria() {
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
