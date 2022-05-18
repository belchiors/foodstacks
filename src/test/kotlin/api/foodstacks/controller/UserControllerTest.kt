package api.foodstacks.controller

import api.foodstacks.model.User
import api.foodstacks.service.UserService
import com.nhaarman.mockito_kotlin.*
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import java.time.LocalDateTime
import java.util.*

class UserControllerTest {

    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @InjectMocks
    lateinit var usersController: UsersController

    @Mock
    lateinit var userService: UserService

    @Test
    fun `create an user with success`() {
        val userMock = buildUser()

        whenever(userService.create(any<User>())) doReturn userMock
        val response = usersController.createUser(userMock)

        verify(userService, times(1)).create(any<User>())
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }

    @Test
    fun `get an user with success`() {
        val userMock = buildUser()

        whenever(userService.getById(userMock.id)).thenReturn(Optional.of(userMock))
        val response = usersController.findUserById(userMock.id)

        verify(userService, times(1)).getById(userMock.id)
        assertEquals(userMock.id, response.body?.id)
    }

    private fun buildUser() : User {
        return User(
            id = "1",
            name = "Rafaela Monteiro",
            email = "montsrafa@cin.ufpe.br",
            password = "123senha",
            cpf = "14577898909",
            birthday = "2000-09-02",
            createdAt = LocalDateTime.of(2021, 1, 8, 20, 41, 35),
            updatedAt = LocalDateTime.of(2021, 1, 8, 20, 41, 35)
        )
    }
}