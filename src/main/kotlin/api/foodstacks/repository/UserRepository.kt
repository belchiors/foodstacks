package api.foodstacks.repository

import api.foodstacks.model.User
import org.springframework.data.mongodb.repository.MongoRepository

interface UserRepository : MongoRepository<User, String>