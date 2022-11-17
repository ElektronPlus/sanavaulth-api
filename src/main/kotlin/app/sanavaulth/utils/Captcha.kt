package app.sanavaulth.utils

import app.sanavaulth.config.CaptchaConfig
import app.sanavaulth.model.CaptchaResponse
import org.springframework.http.HttpEntity
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.util.LinkedMultiValueMap
import org.springframework.util.MultiValueMap
import org.springframework.web.client.RestTemplate

class Captcha {
    companion object {
        fun verify(token: String, config: CaptchaConfig): Boolean {
            val restTemplate = RestTemplate()

            val headers = org.springframework.http.HttpHeaders()
            headers.contentType = MediaType.APPLICATION_FORM_URLENCODED

            val map: MultiValueMap<String, String> = LinkedMultiValueMap()
            map.add("secret", config.secret)
            map.add("response", token)

            val request: HttpEntity<MultiValueMap<String, String>>
                    = HttpEntity<MultiValueMap<String, String>>(map, headers)

            val response: ResponseEntity<CaptchaResponse> =
                restTemplate.postForEntity(config.url, request, CaptchaResponse::class.java)

            return response.body?.success == true
        }
    }
}