package urlapi



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class UrlEntryController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond UrlEntry.list(params), model:[urlEntryInstanceCount: UrlEntry.count()]
    }

    def show(UrlEntry urlEntryInstance) {
        respond urlEntryInstance
    }

    def create() {
        respond new UrlEntry(params)
    }

    @Transactional
    def save(UrlEntry urlEntryInstance) {
        if (urlEntryInstance == null) {
            notFound()
            return
        }

        if (urlEntryInstance.hasErrors()) {
            respond urlEntryInstance.errors, view:'create'
            return
        }

        urlEntryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'urlEntry.label', default: 'UrlEntry'), urlEntryInstance.id])
                redirect urlEntryInstance
            }
            '*' { respond urlEntryInstance, [status: CREATED] }
        }
    }

    def edit(UrlEntry urlEntryInstance) {
        respond urlEntryInstance
    }

    @Transactional
    def update(UrlEntry urlEntryInstance) {
        if (urlEntryInstance == null) {
            notFound()
            return
        }

        if (urlEntryInstance.hasErrors()) {
            respond urlEntryInstance.errors, view:'edit'
            return
        }

        urlEntryInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'UrlEntry.label', default: 'UrlEntry'), urlEntryInstance.id])
                redirect urlEntryInstance
            }
            '*'{ respond urlEntryInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(UrlEntry urlEntryInstance) {

        if (urlEntryInstance == null) {
            notFound()
            return
        }

        urlEntryInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'UrlEntry.label', default: 'UrlEntry'), urlEntryInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'urlEntry.label', default: 'UrlEntry'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
