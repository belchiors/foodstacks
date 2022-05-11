package api.foodstacks.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.CorsRegistry
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
@EnableWebMvc
class CorsConfig : WebMvcConfigurer {
    public override fun addCorsMappings(registry: CorsRegistry) {
        registry.addMapping("/**").allowedOrigins("*")
    }
}