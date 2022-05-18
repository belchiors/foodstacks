package api.foodstacks.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("shops")
@JsonIgnoreProperties(ignoreUnknown = true)
data class Shop(
    @Id val id: String = UUID.randomUUID().toString(),
    val userId: String,
    val name: String,
    val description: String,
    val number: String,
    val walink: String? = null,
    val active: Boolean = true,
    val status: Boolean = false,
    val locations: List<Location>? = null,
    val categories: List<Category>? = null
) {}