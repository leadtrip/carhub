package carhub

class UrlMappings {

    static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/cars" ( resources: 'carV1' )
        "/cars/v1"( resources: "carV1" )
        '/cars/v2'( resources: "carV2" ) {
            collection {
                '/turbocharged'(controller: 'carV2', action: 'turbocharged')
            }
            collection {
                "/search"( controller: 'carV2', action: 'search' )
            }
        }

        "/"(view:"/index")
        "500"(view:'/error')
        "404"(view:'/notFound')
    }
}
