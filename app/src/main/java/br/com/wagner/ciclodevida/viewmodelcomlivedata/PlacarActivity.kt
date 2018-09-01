package br.com.wagner.ciclodevida.viewmodelcomlivedata

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.wagner.ciclodevida.R
import kotlinx.android.synthetic.main.activity_basquete.*
import kotlinx.android.synthetic.main.activity_basquete.view.*

class PlacarActivity : AppCompatActivity() {

    var placarViewModel: PlacarViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basquete)

        placarViewModel = ViewModelProviders.of(this)
                .get(PlacarViewModel::class.java)

       placarViewModel?.placarVisitante?.observe(this, Observer {
           textViewVisitante.text = it?.toString()
       })

        placarViewModel?.placarCasa?.observe(this, Observer {
            textViewCasa.text = it?.toString()
        })



        button3pontos.setOnClickListener{
            placarViewModel?.pontoCasa(3)
        }
        button2pontos.setOnClickListener{
            placarViewModel?.pontoCasa(2)
        }
        button1ponto.setOnClickListener{
            placarViewModel?.pontoCasa(1)
        }

        button3pontosVizitante.setOnClickListener {
            placarViewModel?.pontoVisitante(3)
        }
        button2pontosVisitante.setOnClickListener {
            placarViewModel?.pontoVisitante(2)
        }
        button1pontoVisitante.setOnClickListener {
            placarViewModel?.pontoVisitante(1)
        }

        buttonReset.setOnClickListener {
            placarViewModel?.reset()
        }
    }
}
