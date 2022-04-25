package api.foodstacks.controller

import api.foodstacks.model.Shop
import api.foodstacks.model.BaseShop
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus

class ShopControllerTest {
    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @InjectMocks
    lateinit var shopController: ShopController

    private fun buildShopModel(): BaseShop {
        return Shop(
            id = "6262ca785d159152567841c3",
            userId = "6262ca785d159152567841c3"
        )
    }

    @Test
    fun `test if we can retrieve a shop given an id`() {
        val shopMock = buildShopModel()
        val response = shopController.getShop(shopMock.id)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body is BaseShop)
    }

    @Test
    fun `test if we can create a shop`() {
        val shopMock = buildShopModel()
        val response = shopController.create(shopMock)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body is BaseShop)
    }

    @Test
    fun `test if we can can get a list of shops`() {
        val response = shopController.getAll()
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body is List<*>)
    }
}