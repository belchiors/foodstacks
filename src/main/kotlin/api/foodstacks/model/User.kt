package api.foodstacks.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDateTime
import java.util.*

@Document("users")
data class User (
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val email: String,
    val password: String,
    val cpf: String,
    val birthday: String,
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val createdAt: LocalDateTime = LocalDateTime.now(),
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val updatedAt: LocalDateTime = LocalDateTime.now(),
)