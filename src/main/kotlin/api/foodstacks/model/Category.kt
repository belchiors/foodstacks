package api.foodstacks.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document("categories")
class Category(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String
)