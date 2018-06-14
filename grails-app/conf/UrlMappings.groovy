class UrlMappings {

	static mappings = {
        "/$controller/$action?/$id?(.$format)?"{
            constraints {
                // apply constraints here
            }
        }

        "/"(controller:'front', action:'index')
        "/front/get/$zip"(controller:'front', action:'get')
        "500"(view:'/error')
	}
}
