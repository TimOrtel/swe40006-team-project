package au.edu.swin.backend

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import kotlin.test.assertEquals

@SpringBootTest
class MessageServiceTests @Autowired constructor(val messageService: MessageService) {

    @BeforeEach
    fun setup() {
        messageService.clearMessages()
    }

    @Test
    fun `test WHEN no messages have been sent THEN no messages are present`() {
        assertEquals(emptyList(), messageService.getMessages(), "Expected no messages")
    }

    @Test
    fun `test WHEN a message is sent THEN the message will be present`() {
        val text = "Hello World"

        messageService.createMessage(Message(text))

        assertEquals(listOf(Message(text)), messageService.getMessages(), "Expected exactly one message to be present")
    }

    @Test
    fun `test GIVEN already 10 messages present WHEN adding a new message THEN the oldest message is discarded and the new one added`() {
        repeat(10) {
            messageService.createMessage(Message("message $it"))
        }

        val newMessage = "new message"
        messageService.createMessage(Message(newMessage))

        val messages = messageService.getMessages()
        assertEquals(10, messages.size, "Expected exactly 10 messages")
        val expectedMessages = (1..9).map { Message("message $it") } + Message(newMessage)
        assertEquals(expectedMessages, messages)
    }
}
