package api.foodstacks.controller

import api.foodstacks.model.User
import api.foodstacks.service.UserService
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock

class UserControllerTest {

    @InjectMocks
    lateinit var usersController: UsersController

    @Mock
    private lateinit var userService: UserService

    @Test
    fun `create an account with success`() {
        val userMock = buildUser()

        whenever(userService.create(any<User>())) doReturn userMock

        val response = usersController.createUser(userMock)

        verify(userService, times(1)).create(any<User>())
        assertEquals(userMock.id, response.body?.id)
    }

    @Test
    fun `create an account with invalid data`() {
        val userInvalidMock = buildUserInvalid()

        whenever(userService.create(any<User>())).thenThrow(Exception("error", 400))

        assertThrows<java.lang.Exception> {
            usersController.create(userInvalidMock)
        }
    }

    private fun buildUser() : User {
        return User(
            id = "1",
            name = "Rafaela Monteiro",
            email = "montsrafa@cin.ufpe.br",
            password = "123senha"
        )
    }

    private fun buildUserInvalid() : User {
        return User(
            id = "1",
            name = "",
            email = "montsrafa@cin.ufpe.br",
            password = "123senha"
        )
    }


}