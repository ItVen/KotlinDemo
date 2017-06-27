package kotilndemo.ellen.com.kotlintest

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , OnClickListener {
    var message: String? =""
    override fun onClick(v: View?) {
        Toast.makeText(this,"哎呀！",Toast.LENGTH_SHORT).show()
        // 跳转 // 获取class是使用::反射
        var intent  = Intent(this,JavaPageActivity::class.java)
        intent.putExtra("Java","我是Kotlin界面过来的")
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        message= if (getMassage() != null) getMassage() else "我是用Kotlin插件改的"
        hello.text=message
        phone.hint = "电话号码"
        email.hint = "email"
        password.hint = "password"
        commit.text = "提交"
        jumb()
    }
    fun jumb(): Unit{
        commit.setOnClickListener(this)
    }
    fun getMassage(): String?{
        return intent.getStringExtra("Test")
    }

    override fun onResume() {
        super.onResume()
        Log.i("Tag",getMassage()+"---")
        message= if (getMassage() != null) getMassage() else "我是用Kotlin插件改的"
        hello.text=message
    }
}

