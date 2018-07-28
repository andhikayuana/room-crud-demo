package id.yuana.room.crud.demo

import android.app.Application
import android.arch.persistence.room.Room
import com.facebook.stetho.Stetho
import id.yuana.room.crud.demo.data.local.BelanjaDatabase
import id.yuana.room.crud.demo.data.local.entity.ProductEntity
import io.reactivex.Flowable

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Fri 27 2018 23.48
 **/
class App : Application() {

    var db: BelanjaDatabase? = null

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this)

        db = Room.databaseBuilder(this, BelanjaDatabase::class.java, "belanja_db")
                .allowMainThreadQueries()
                .build()


        db!!.productDao().insert(ProductEntity("Sepatu Mahal", 300000, "https://anu.com/sepatu.jpg"))

        db!!.productDao().insert(
                ProductEntity("Kaos Libran", 200000, "https://anu.com/kaos.jpg"),
                ProductEntity("Celana Mahal", 500000, "https://anu.com/celana.jpg"),
                ProductEntity("Baju Batik", 600000, "https://anu.com/baju-batik.jpg")
        )

        db!!.productDao().getProducts()

        db!!.productDao().getProductsWithRx()
                .flatMap { Flowable.fromIterable(it) }
                .map { it.name }
                .toList()

        val product = db!!.productDao().getProduct(1)
        product.name = "Sepatu Harga Terjangkau"
        product.price = 100000
        product.image = "https://anu.com/ini-sepatu-terjangkau.jpg"
        db!!.productDao().update(product)

    }
}