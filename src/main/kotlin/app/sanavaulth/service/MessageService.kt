package app.sanavaulth.service

import app.sanavaulth.model.Message
import app.sanavaulth.repository.MessageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService {

    @Autowired
    private lateinit var messageRepository: MessageRepository

    fun findAll(): List<Message> {
        return messageRepository.findAll()
    }

    fun findById(id: Long): Message {
        return messageRepository.findById(id).get()
    }

    fun save(message: Message): Message {
        println(message.toString())
        return messageRepository.save(message)
    }

    fun delete(id: Long) {
        messageRepository.deleteById(id)
    }
}