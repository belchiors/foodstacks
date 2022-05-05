package api.foodstacks.controller

import api.foodstacks.model.Shop
import api.foodstacks.service.ShopService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/shops")
class ShopController(private val shopService: ShopService) {
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
}