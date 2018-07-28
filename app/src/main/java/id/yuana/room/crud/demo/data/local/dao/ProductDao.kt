package id.yuana.room.crud.demo.data.local.dao

import android.arch.persistence.room.*
import id.yuana.room.crud.demo.data.local.entity.ProductEntity
import io.reactivex.Flowable
import io.reactivex.Single


/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Fri 27 2018 23.08
 **/
@Dao
interface ProductDao {

    @Query("SELECT * FROM products")
    fun getProductsWithRx(): Flowable<List<ProductEntity>>

    @Query("SELECT * FROM products")
    fun getProducts(): List<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProductWithRx(id: Int): Single<ProductEntity>

    @Query("SELECT * FROM products WHERE id = :id")
    fun getProduct(id: Int): ProductEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(productEntity: ProductEntity)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(vararg productEntity: ProductEntity)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun update(productEntity: ProductEntity)

    @Delete
    fun delete(productEntity: ProductEntity)
}