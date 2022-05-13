package api.foodstacks.service

import api.foodstacks.model.User
import api.foodstacks.repository.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class UserService(
    private val userRepository: UserRepository
) {
    private val logger = LoggerFactory.getLogger(javaClass)

    fun create(user: User) : User {
        logger.info("action=buildingUser, user=$user")
        return userRepository.save(user)
    }

    fun getById(userId: String) : Optional<User> {
        logger.info("action=searchingUser, userId=$userId")
        return userRepository.findById(userId)
    }
}
