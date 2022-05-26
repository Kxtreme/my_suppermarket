package me.kxtre.mysuppermarket.model

import com.github.javafaker.Faker

class Grocery(val name: String, val department: String, val price: String, val imageUrl: String) {

    companion object {
        fun generate(): Grocery {
            val faker = Faker()
            val commerce = faker.commerce()
            return Grocery(
                commerce.productName(),
                commerce.department(),
                commerce.price(),
                "https://picsum.photos/id/${faker.number().numberBetween(0, 100)}/640/480"
            )
        }
    }
}