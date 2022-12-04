package com.example.statisticcalculationapp

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import com.example.statisticcalculationapp.databinding.ActivityMainBinding
import java.math.BigInteger
import kotlin.math.E
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ------------------画面切り替えの処理-------------------- //
        // ボタンを押したときにイベントを取得できるようにする
        val switchViewButton:Button = findViewById(R.id.switchPoViewButton)
        switchViewButton.setOnClickListener {
            //  一部のビューだけを変更する
            // 変更したいレイアウトを取得する
            val layout: ConstraintLayout = findViewById(R.id.layout)
            // レイアウトのビューをすべて削除する
            layout.removeAllViews()
            // レイアウトをR.layout.poissonに変更する
            layoutInflater.inflate(R.layout.poisson, layout)
        }

        // ------------------正規分布の場合の処理-------------------- //

        val resultBinding: ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val executeButton: Button = findViewById(R.id.execute_button)
        executeButton.setOnClickListener {
            val attemptsNum = findViewById<EditText>(R.id.edit_number_of_attempts)
            val successNum = findViewById<EditText>(R.id.edit_number_of_success)
            val probabilityOfSuccessNum = findViewById<EditText>(R.id.edit_probability_of_success)

            val debugText = "試行回数: ${attemptsNum.text}, 成功回数: ${successNum.text}, 成功確率: ${probabilityOfSuccessNum.text}"
            println(debugText)

            val result = Result(
                "",
                attemptsNum.text.toString().toBigInteger(),
                successNum.text.toString().toBigInteger(),
                probabilityOfSuccessNum.text.toString().toDouble(),
            )


            val combiVal = calcCombination(result.attemptsNumber, result.successNumber)
            println("combiVal: $combiVal")
            val sum = calcBinomialDistribution(result.attemptsNumber, result.successNumber, result.probabilityOfSuccess, combiVal)
            result.summary = sum.toString()
            println("sum: $sum")
            resultBinding.summaryTextView.text = result.summary
        }

        // -----------------ポアソン分布の場合の処理--------------------- //
    }


    // 組み合わせの実装(nCt)
    private fun calcCombination(n: BigInteger, t: BigInteger): BigInteger {
        if (n < BigInteger.ZERO || t < BigInteger.ZERO || t > n) throw Throwable("不正な引数です")

        var r: BigInteger = t
        if (n - r < r) r = n - r
        if (r == BigInteger.ZERO) return BigInteger.ONE
        if (r == BigInteger.ONE) return n

        val numerator = arrayOf(r)
        val denominator = arrayOf(r)

        for (k in 0 until r) {
            numerator[k] = n - r + k + 1
            denominator[k] = k + 1
        }

        for (p in 2..r) {
            val pivot = denominator[(p - 1)]
            if (pivot > 1) {
                val offset: Long = (n - r) % p
                var k = p - 1
                while (k < r) {
                    numerator[(k - offset)] /= pivot
                    denominator[k] /= pivot
                    k += p
                }
            }
        }

        var result: Long = 1
        for (k in 0 until r) {
            if (numerator[k] > 1) result *= numerator[k]
        }

        return result
    }
    // 二項分布関数の実装
    private fun calcBinomialDistribution(n: Long, k: Long, p: Double, combiVal: Long): Double {
        val successP = p.pow(k)
        val failedP = (1-p).pow(n-k)
        return combiVal * successP * failedP
    }

    // 階乗
    private fun factorial(n: Int): Int {
        return if (n <= 0) 1 else n * factorial(n - 1)
    }

    private fun poissonDistribution(x: Int, lambda: Double): Double {
        val upperVal = E.pow(-lambda) * lambda.pow(x)
        val bottomVal = factorial(x)
        return upperVal / bottomVal
    }
}