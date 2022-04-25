package api.foodstacks.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import org.springframework.data.mongodb.core.mapping.Document

@Document("shops")
@JsonIgnoreProperties(ignoreUnknown = true)
class Shop(id: String? = null, userId: String) : BaseShop(id, userId) {
}