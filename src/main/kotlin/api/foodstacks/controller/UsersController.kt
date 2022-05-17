package api.foodstacks.controller

import api.foodstacks.model.SignInDto
import api.foodstacks.model.User
import api.foodstacks.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class UsersController (
    private val userService: UserService
){
    private val logger = LoggerFactory.getLogger(javaClass)

    @PostMapping("/users")
    fun createUser(@RequestBody user: User) : ResponseEntity<User> {
        logger.info("action=creatingUser, user=$user")
        val userCreated = userService.create(user)

        return ResponseEntity.ok(userCreated)
    }

    @GetMapping("/users/{userId}")
    fun findUserById(@PathVariable userId: String) : ResponseEntity<User> {
        logger.info("action=gettingUser, userId=$userId")

        return userService.getById(userId).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
    }

    @PostMapping("/users/login")
    fun login(@RequestBody params: SignInDto) : ResponseEntity<Any> {
        val user = userService.getByEmail(params.email)
        if (!user.isPresent) {
            return ResponseEntity("Usuário não encontrado", HttpStatus.NOT_FOUND)
        }

        if (!userService.validatePassword(params.email, params.password)) {
            return ResponseEntity("Email ou senha inválidos", HttpStatus.FORBIDDEN)
        }

        return ResponseEntity(mapOf("userId" to user.get().id), HttpStatus.OK)
    }
}
