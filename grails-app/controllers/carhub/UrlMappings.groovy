package carhub

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/api/cars" ( resources: 'carV1' )
        "/api/cars/v1"( resources: "carV1" )
        '/api/cars/v2'( resources: "carV2" ) {
            collection {
                '/turbocharged'(controller: 'carV2', action: 'turbocharged')
            }
            collection {
                "/search"( controller: 'carV2', action: 'search' )
            }
        }
        "/api/cars/v3"( resources: "carV3" )

        "/apidocs" (controller: "api")

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
