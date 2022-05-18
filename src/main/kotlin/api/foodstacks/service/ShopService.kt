package api.foodstacks.service

import api.foodstacks.model.Shop
import api.foodstacks.repository.ShopRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class ShopService(private val shopRepository: ShopRepository) {
    fun getAll(): Iterable<Shop> {
        return shopRepository.findAll()
    }

    fun getShopById(shopId: String): Shop? {
        return shopRepository.findByIdOrNull(shopId)
    }

    fun create(shop: Shop): Shop {
        val newShop = shop.copy(
            walink = generateWhatsappLink(shop.number)
        )
        return shopRepository.save(newShop)
    }

    fun generateWhatsappLink(number : String) : String {
        return "https://api.whatsapp.com/send?phone=$number"
    }
}