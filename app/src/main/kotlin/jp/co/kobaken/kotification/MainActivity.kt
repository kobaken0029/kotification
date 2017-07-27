package jp.co.kobaken.kotification

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import jp.co.kobaken.kotification.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    companion object {
        val ARG_ID = "id"
        val ARG_TYPE = "type"
    }

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.id.text = intent.getStringExtra("id")
        binding.type.text = intent.getStringExtra("type")
    }
}
