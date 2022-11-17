package app.sanavaulth.config

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConfigurationProperties(prefix = "captcha")
@ConstructorBinding
data class CaptchaConfig(
    val url: String,
    val secret: String
)