package app.sanavaulth

import app.sanavaulth.config.CaptchaConfig
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties(CaptchaConfig::class)
class SanavaulthApplication

fun main(args: Array<String>) {
    runApplication<SanavaulthApplication>(*args)
}
