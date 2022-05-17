package api.foodstacks.repository

import api.foodstacks.model.User
import org.springframework.data.mongodb.repository.MongoRepository
import java.util.*

interface UserRepository : MongoRepository<User, String> {
    abstract fun findByEmail(email: String): Optional<User>
    abstract fun existsByEmail(email: String): Boolean
    abstract fun existsByCpf(cpf: String): Boolean
}