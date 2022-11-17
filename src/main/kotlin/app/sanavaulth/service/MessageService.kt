package app.sanavaulth.service

import app.sanavaulth.config.CaptchaConfig
import app.sanavaulth.exception.ErrorType
import app.sanavaulth.model.Message
import app.sanavaulth.repository.MessageRepository
import app.sanavaulth.utils.Captcha
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class MessageService {

    @Autowired
    private lateinit var messageRepository: MessageRepository

    @Autowired
    private lateinit var captchaConfig: CaptchaConfig

    fun findAll(): List<Message> {
        return messageRepository.findAll()
    }

    fun findById(id: Long): Message {
        return messageRepository.findById(id)
            .orElseThrow { Exception(ErrorType.NOT_FOUND.name) }
    }

    fun create(message: Message, captcha: String): Message {
        if(!Captcha.verify(token = captcha, config = captchaConfig))
            throw Exception(ErrorType.INVALID_CAPTCHA.name)
        return messageRepository.save(message)
    }

    fun delete(id: Long) {
        messageRepository.deleteById(id)
    }
}