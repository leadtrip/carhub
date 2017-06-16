package carhub

class MyCarController {

    def index() {
        redirect ( action: 'show' )
    }

    def show() {
        [car: Car.findByModel( 'GTS' )]
    }
}
