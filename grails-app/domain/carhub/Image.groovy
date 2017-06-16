package carhub

class Image {

    String uri

    static belongsTo = [car: Car]

    static constraints = {
    }
}
