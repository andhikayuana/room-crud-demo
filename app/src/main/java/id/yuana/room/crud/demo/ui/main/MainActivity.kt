package id.yuana.room.crud.demo.ui.main

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import id.yuana.room.crud.demo.App
import id.yuana.room.crud.demo.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val productDao = (application as App).db!!.productDao()

        tvProducts.text = productDao.getProducts().toString()

    }
}
