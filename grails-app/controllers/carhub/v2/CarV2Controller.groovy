package carhub.v2

import carhub.Car
import grails.rest.RestfulController

class CarV2Controller extends RestfulController<Car> {

    static responseFormats = ['json', 'xml']

    CarV2Controller() {
        super( Car )
    }

    @Override
    def index( Integer max ){
        respond Car.all
    }

    def turbocharged() {
        respond Car.findAllByAspiration( 'Turbocharged' )
    }

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
}
