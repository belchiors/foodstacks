package api.foodstacks.controller

import api.foodstacks.model.User
import api.foodstacks.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class UsersController (
    private val userService: UserService
){
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/users")
    fun createUser(user: User) : ResponseEntity<User> {
        logger.info("action=creatingUser, user=$user")
        val userCreated = userService.create(user)

        return ResponseEntity.ok(userCreated)
    }
}
