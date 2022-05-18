package api.foodstacks.controller

import api.foodstacks.model.Shop
import api.foodstacks.service.ShopService
import api.foodstacks.service.UserService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.whenever
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

    @Mock lateinit var userService: UserService

    private fun buildShopModel(): Shop {
        return Shop(
            id = UUID.randomUUID().toString(),
            userId = UUID.randomUUID().toString(),
            name = "Foodstacks",
            description = "Doces e salgados",
            status = false,
            number = "5581983029845",
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

    @Test
    fun `test if we can change a shop's status`() {
        val shopMock = buildShopModel()

        whenever(shopService.create(any<Shop>())) doReturn shopMock
        whenever(shopService.getShopById(any<String>())) doReturn shopMock

        shopController.createShop(shopMock)

        val response = shopController.setStatus(
            status = true,
            userId = shopMock.userId,
            shopId = shopMock.id
        )

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
    }
}