package id.yuana.room.crud.demo.data.local

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import id.yuana.room.crud.demo.data.local.dao.ProductDao
import id.yuana.room.crud.demo.data.local.entity.ProductEntity

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Fri 27 2018 23.07
 **/
@Database(entities = arrayOf(ProductEntity::class), version = 1)
abstract class BelanjaDatabase : RoomDatabase() {

    abstract fun productDao(): ProductDao
}