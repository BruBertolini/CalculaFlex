package br.com.bertolini.calculaflex

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.bertolini.calculaflex.extensions.getDouble
import br.com.bertolini.calculaflex.watchers.DecimalTextWatcher
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etGasPrice.addTextChangedListener(DecimalTextWatcher(etGasPrice))
        etEthanolPrice.addTextChangedListener(DecimalTextWatcher(etEthanolPrice))

        etGasAverage.addTextChangedListener(DecimalTextWatcher(etGasAverage,1))
        etEthanolAverage.addTextChangedListener(DecimalTextWatcher(etEthanolAverage,1))

        btCalculate.setOnClickListener{
            val nxView = Intent(this, ResultActivity::class.java)
            nxView.putExtra("gasPrice",etGasPrice.getDouble())
            nxView.putExtra("ethanolPrice",etEthanolPrice.getDouble())
            nxView.putExtra("gasAverage",etGasAverage.getDouble())
            nxView.putExtra("ethanolAverage",etEthanolAverage.getDouble())

            startActivity(nxView)
        }




    }
}
