package api.foodstacks.repository

import api.foodstacks.model.Shop
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface ShopRepository : MongoRepository<Shop, String> {}