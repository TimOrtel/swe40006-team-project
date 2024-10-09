package au.edu.swin.backend

import org.springframework.stereotype.Service


@Service
class MessageService {

    private val messages: MutableList<Message> = mutableListOf()

    fun createMessage(message: Message) {
        synchronized(messages) {
            if (messages.size == 10) {
                messages.removeAt(0)
            }

            messages += message
        }
    }

    fun getMessages(): List<Message> {
        return synchronized(messages) {
            messages.toList()
        }
    }

    fun clearMessages() {
        synchronized(messages) {
            messages.clear()
        }
    }
}
