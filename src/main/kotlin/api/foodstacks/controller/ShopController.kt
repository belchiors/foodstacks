package api.foodstacks.controller

import api.foodstacks.model.Category
import api.foodstacks.model.Location
import api.foodstacks.model.Shop
import api.foodstacks.service.ShopService
import api.foodstacks.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shops")
class ShopController(
    private val shopService: ShopService,
    private val userService: UserService
    ) {
    @GetMapping
    fun getAllShops(): ResponseEntity<Iterable<Shop>> {
        return ResponseEntity(shopService.getAll(), HttpStatus.OK)
    }

    @PostMapping
    fun createShop(@RequestBody shop: Shop): ResponseEntity<Any> {
        return ResponseEntity(shopService.create(shop), HttpStatus.OK)
    }

    @GetMapping("/{shopId}")
    fun getShopById(@PathVariable shopId: String): ResponseEntity<Any> {
        val body = shopService.getShopById(shopId)
        if (body == null) {
            return ResponseEntity("Loja não encontrada", HttpStatus.OK)
        }
        return ResponseEntity(body, HttpStatus.OK)
    }

    @GetMapping("/status")
    fun setStatus(
        @RequestParam(value = "enable", required = true) status: Boolean,
        @RequestParam(value = "userId", required = true) userId: String,
        @RequestParam(value = "shopId", required = true) shopId: String,
    ): ResponseEntity<Any> {
        val obj = shopService.getShopById(shopId)
        if (obj == null) {
            return ResponseEntity("Loja não encontrada", HttpStatus.NOT_FOUND)
        }
        val updateShop = obj.copy(status = status)
        shopService.create(updateShop)
        return ResponseEntity.status(HttpStatus.OK).body(updateShop)
    }
}