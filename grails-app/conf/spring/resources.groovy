import carhub.Car
import grails.rest.render.hal.*
beans = {
    halBookRenderer(HalJsonRenderer, Car)
    halBookCollectionRenderer(HalJsonCollectionRenderer, Car)
}
