package au.edu.swin.backend

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController


@RestController
class MessageController @Autowired constructor(private val messageService: MessageService) {

    @RequestMapping(path = ["/api/messages/create"], method = [RequestMethod.POST])
    fun createMessage(@RequestBody message: String): ResponseEntity<Unit> {
        messageService.createMessage(Message(message))

        return ResponseEntity(Unit, HttpStatus.OK)
    }

    @RequestMapping(path = ["/api/messages"], method = [RequestMethod.GET])
    fun getMessages(): ResponseEntity<List<String>> {
        return ResponseEntity(messageService.getMessages().map { it.content }, HttpStatus.OK)
    }
}
