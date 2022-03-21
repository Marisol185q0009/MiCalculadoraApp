package edu.itsco.micalculadoraapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var numero1:Double = 0.0
    private var numero2:Double = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtresultado.text = "0"
        operacion = nooperacion

        btnuno.setOnClickListener { numero("1")}
        btndos.setOnClickListener { numero("2")}
        btntres.setOnClickListener { numero("3")}
        btncuatro.setOnClickListener { numero("4")}
        btncinco.setOnClickListener { numero("5")}
        btnseis.setOnClickListener { numero("6")}
        btnsiete.setOnClickListener { numero("7")}
        btnocho.setOnClickListener { numero("8")}
        btnnueve.setOnClickListener { numero("9")}
        btncero.setOnClickListener { numero("0")}
        btnpunto.setOnClickListener { numero(".")}


        btnsuma.setOnClickListener { operacionp(suma) }
        btnresta.setOnClickListener { operacionp(resta) }
        btnmul.setOnClickListener { operacionp(multiplicacion) }
        btndividir.setOnClickListener { operacionp(division) }

        btnborrar.setOnClickListener {
            numero1 = 0.0
            numero2 = 0.0
            txtresultado.text="0"
            operacion= nooperacion
        }

        btnigual.setOnClickListener {
            var resultado = when(operacion){
                suma -> numero1 + numero2
                resta -> numero1 - numero2
                multiplicacion -> numero1 * numero2
                division -> numero1 / numero2
                else -> 0
            }

            txtresultado.text = resultado.toString()

            numero1 = resultado as Double

            txtresultado.text = if("$resultado".endsWith(".0")) { "$resultado".replace(".0","") } else { "%.2f".format(resultado) }
        }
    }
     private fun numero(digito: String){
         txtresultado.text="${txtresultado.text}$digito"

         if(operacion == nooperacion && digito !="."){
             numero1 = txtresultado.text.toString().toDouble()
         }else{
             numero2 = txtresultado.text.toString().toDouble()
         }

     }
     private fun operacionp(operacion:Int){
         this.operacion = operacion

         txtresultado.text = "0"
     }
    companion object{
        const val suma=1
        const val resta=2
        const val multiplicacion=3
        const val division=4
        const val nooperacion=0
    }
}
