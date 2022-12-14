package app.sanavaulth.controller

import app.sanavaulth.model.Message
import app.sanavaulth.service.MessageService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.graphql.data.method.annotation.Argument
import org.springframework.graphql.data.method.annotation.MutationMapping
import org.springframework.graphql.data.method.annotation.QueryMapping
import org.springframework.stereotype.Controller

@Controller
class MessageController {

    @Autowired
    private lateinit var messageService: MessageService

    @QueryMapping
    fun messages() = messageService.findAll()

    @QueryMapping
    fun message(@Argument id: Long) = messageService.findById(id)

    @MutationMapping
    fun createMessage(@Argument message: Message, @Argument captcha: String)
        = messageService.create(message, captcha)

    @MutationMapping
    fun deleteMessage(@Argument id: Long) = messageService.delete(id)


}