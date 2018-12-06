package br.com.bertolini.calculaflex

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.bertolini.calculaflex.extensions.format
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        calculate()
    }

    private fun calculate() {
        val gasPrice = intent.extras.getDouble("gasPrice",0.0)
        val ethanolPrice = intent.extras.getDouble("ethanolPrice",0.0)
        val gasAverage = intent.extras.getDouble("gasAverage",0.0)
        val ethanolAverage = intent.extras.getDouble("ethanolAverage",0.0)

        val performanceMyCar = ethanolAverage / gasAverage
        val priceOfIndice = ethanolPrice / gasPrice

        if(priceOfIndice <= performanceMyCar){
            tvSuggestion.text = getString(R.string.ethanol)
        }else{
            tvSuggestion.text = getString(R.string.gasoline)
        }

        tvEthanolAverageResult.text = (ethanolPrice / ethanolAverage).format(2)
        tvGasAverageResult.text = (gasPrice / gasAverage).format(2)
}
}
