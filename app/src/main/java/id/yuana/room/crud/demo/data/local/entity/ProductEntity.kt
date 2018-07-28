package id.yuana.room.crud.demo.data.local.entity

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Jul, Fri 27 2018 23.08
 **/
@Entity(tableName = "products")
data class ProductEntity(
        @ColumnInfo(name = "name") var name: String,
        @ColumnInfo(name = "price") var price: Int,
        @ColumnInfo(name = "image") var image: String
) {

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    override fun toString(): String {
        return "ProductEntity(name='$name', price=$price, image='$image', id=$id)"
    }


}
