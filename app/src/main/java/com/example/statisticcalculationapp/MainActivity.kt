package com.example.statisticcalculationapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ボタンを押したときにイベントを取得できるようにする
        val switchViewButton:Button = findViewById(R.id.switchViewButton)
        switchViewButton.setOnClickListener {
            //  一部のビューだけを変更する
            // 変更したいレイアウトを取得する
            val layout: LinearLayout = findViewById(R.id.layout)
            // レイアウトのビューをすべて削除する
            layout.removeAllViews()
            // レイアウトをR.layout.poissonに変更する
            layoutInflater.inflate(R.layout.poisson, layout)
        }

        val attemptsNum = findViewById<EditText>(R.id.edit_number_of_attempts)
        val successNum = findViewById<EditText>(R.id.edit_number_of_success)
        val probabilityOfSuccessNum = findViewById<EditText>(R.id.edit_probability_of_success)

        val executeButton: Button = findViewById(R.id.execute_button)
        executeButton.setOnClickListener {
            val debugText = "試行回数: $attemptsNum, 成功回数: $successNum, 成功確率: $probabilityOfSuccessNum"
            println(debugText)
            Toast.makeText(this, attemptsNum.toString(), Toast.LENGTH_SHORT).show()
        }

//
//        /* 値を格納する変数 */
//        var value = 0
//
//        /* 計算結果をクリアするかどうかを判断するためのフラグ */
//        /* trueの時に数字ボタンが押された時に計算結果をクリアする */
//        /*
//            例えば"="押された時にフラグをtrueにし、
//            その後数字ボタンが押された時などにクリアするために使う
//        */
//        var clear = false
//
//        /* 計算処理を行うかどうかを判断するためのフラグ */
//        /* trueの時にのみ計算ボタンが押された時に計算処理を行う */
//        /*
//            例えば"+"押された後に、
//            数字ボタンが押されないまま"-"が押された時等は
//            計算は行いたくないのでこのフラグを利用して制御する
//         */
//        var calc = false
//
//        /* 演算子を記憶しておく変数 */
//        /* nullの可能性あり */
//        var operator : String? = null
//
//        /* 数字ボタン */
//        val buttonZero : Button = findViewById(R.id.zero)
//        val buttonOne : Button = findViewById(R.id.one)
//        val buttonTwo : Button = findViewById(R.id.two)
//        val buttonThree : Button = findViewById(R.id.three)
//        val buttonFour : Button = findViewById(R.id.four)
//        val buttonFive : Button = findViewById(R.id.five)
//        val buttonSix : Button = findViewById(R.id.six)
//        val buttonSeven : Button = findViewById(R.id.seven)
//        val buttonEight : Button = findViewById(R.id.eight)
//        val buttonNine : Button = findViewById(R.id.nine)
//
//        /* 計算ボタン */
//        val buttonAdd : Button = findViewById(R.id.add)
//        val buttonMul : Button = findViewById(R.id.mul)
//        val buttonSub : Button = findViewById(R.id.sub)
//        val buttonDiv :Button = findViewById(R.id.div)
//
//        /* 実行ボタン */
//        val buttonEqual:Button = findViewById(R.id.equal)
//
//        /* クリアボタン */
//        val buttonClear : Button = findViewById(R.id.clear)
//
//        /* 表示テキスト */
//        val textArea : TextView = findViewById(R.id.display)
//
//        /* 数字ボタンを押された時の処理をまとめた関数 */
//        fun numButtonAction(num : String) {
//            textArea.text = if(textArea.text.toString() != "0" && !clear){
//                textArea.text.toString() + num
//            } else {
//                clear = false
//                num
//            }
//            calc = true
//        }
//
//        /* クリアボタンを押された時の処理 */
//        /* 全て初期値に戻す */
//        buttonClear.setOnClickListener {
//            textArea.text ="0"
//            value = 0
//            operator = null
//            clear = false
//            calc = false
//        }
//
//        /* 数字ボタンを押された時の処理 */
//        /* 表示領域を更新 */
//        buttonZero.setOnClickListener {
//            numButtonAction("0")
//        }
//
//        buttonOne.setOnClickListener {
//            numButtonAction("1")
//        }
//
//        buttonTwo.setOnClickListener {
//            numButtonAction("2")
//        }
//
//        buttonThree.setOnClickListener {
//            numButtonAction("3")
//        }
//
//        buttonFour.setOnClickListener {
//            numButtonAction("4")
//        }
//
//        buttonFive.setOnClickListener {
//            numButtonAction("5")
//        }
//
//        buttonSix.setOnClickListener {
//            numButtonAction("6")
//        }
//
//        buttonSeven.setOnClickListener {
//            numButtonAction("7")
//        }
//
//        buttonEight.setOnClickListener {
//            numButtonAction("8")
//        }
//
//        buttonNine.setOnClickListener {
//            numButtonAction("9")
//        }
//
//        /* 計算の実処理を行う関数 */
//        fun calculation(op : String?) :Int {
//            return when (op) {
//                "+" -> {
//                    value + textArea.text.toString().toInt()
//                }
//                "-" -> {
//                    value - textArea.text.toString().toInt()
//                }
//                "*" -> {
//                    value * textArea.text.toString().toInt()
//                }
//                "/" -> {
//                    value / textArea.text.toString().toInt()
//                }
//                else -> {
//                    textArea.text.toString().toInt()
//                }
//            }
//        }
//
//        /* 計算ボタンを押された時の処理をまとめた関数 */
//        fun calcButtonAction(op : String?) {
//            /* 計算処理有効の場合のみ計算と表示の更新を行う */
//            if (calc) {
//                value = calculation(operator)
//                clear = true
//                calc = false
//                textArea.text = value.toString()
//            }
//            /* 演算子は計算処理無効でも更新 */
//            operator = op
//        }
//
//
//        /* 計算ボタンが押された時の処理 */
//        buttonAdd.setOnClickListener {
//            calcButtonAction("+")
//        }
//
//        buttonMul.setOnClickListener {
//            calcButtonAction("*")
//        }
//
//        buttonSub.setOnClickListener {
//            calcButtonAction("-")
//        }
//
//        buttonDiv.setOnClickListener {
//            calcButtonAction("/")
//        }
//
//        /* "="ボタンが押された時の処理 */
//        buttonEqual.setOnClickListener {
//            /* 計算処理有効の場合のみ計算と表示の更新を行う */
//            if (calc) {
//                value = calculation(operator)
//                calc = false
//                clear = true
//                textArea.text = value.toString()
//                operator = null
//            }
//        }
    }
}