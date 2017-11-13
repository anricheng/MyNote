package aspect.chou.aric.com.kotlindemo

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        lazy { var zhou="text" }

        //定义一个常量数组
        var arrs = Array(3){Array(2){IntArray(1)}};

        //空安全的变量
        var str:String  =""

        //可为空字符串变量
        var str2:String ? =null

        //when 表达式=常量  变量 返回数值的表达式  返回boolean的表达式

        var x=10;
        when(x){
            2-> println("等于2")

            if (x>0) 1 else -1-> println()
        }

        Thread(Runnable {  })





    }

}
