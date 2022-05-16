package api.foodstacks.controller

import api.foodstacks.model.Shop
import api.foodstacks.service.ShopService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import org.springframework.http.HttpStatus
import java.util.*

class ShopControllerTest {
    @BeforeEach
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @InjectMocks
    lateinit var shopController: ShopController

    @Mock
    lateinit var shopService: ShopService

    private fun buildShopModel(): Shop {
        return Shop(
            id = UUID.randomUUID().toString(),
            userId = UUID.randomUUID().toString(),
            name = "Foodstacks",
            number = "5581983029845",
            description = "Doces e salgados"
        )
    }

    @Test
    fun `test if we can retrieve a shop given an id`() {
        val shopMock = buildShopModel()
        val response = shopController.getShopById(shopMock.id)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body is Shop)
    }

    @Test
    fun `test if we can create a shop`() {
        val shopMock = buildShopModel()
        val response = shopController.createShop(shopMock)
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body is Shop)
    }

    @Test
    fun `test if we can can get a list of shops`() {
        val response = shopController.getAllShops()
        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.body is List<Shop>)
    }
}