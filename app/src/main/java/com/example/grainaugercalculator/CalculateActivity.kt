package com.example.grainaugercalculator

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.PI
import kotlin.math.cos
import kotlin.math.pow
import kotlin.math.roundToInt
import kotlin.math.sqrt

class CalculateActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)

        val diameterOuter: EditText = findViewById(R.id.id_Diameter)
        val diameterInner: EditText = findViewById(R.id.id_diameter)
        val step: EditText = findViewById(R.id.id_step)

        val tvBigDiameter: TextView = findViewById(R.id.tvDiameterBig)
        val tvSmallDiameter: TextView = findViewById(R.id.tvDiameterSmall)
        val tvExternalCutout: TextView = findViewById(R.id.tvExternalCutout)
        val tvInternalCutout: TextView = findViewById(R.id.tvInternalCutout)
        val tvCutAngle: TextView = findViewById(R.id.tvCutAngle)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            val diameterBig = diameterOuter.text.trim().toString().toDoubleOrNull()?:0.0
            val diameterSmall = diameterInner.text.trim().toString().toDoubleOrNull()?:0.0
            val stepCircle = step.text.trim().toString().toDoubleOrNull()?:0.0

            tvBigDiameter.text = calculate_D(diameterBig, diameterSmall, stepCircle)
            tvSmallDiameter.text = calculate_d(diameterBig, diameterSmall, stepCircle)
            tvExternalCutout.text = calculate_ExCutout(diameterBig, diameterSmall, stepCircle)
            tvInternalCutout.text = calculate_InCutout(diameterBig, diameterSmall, stepCircle)
            tvCutAngle.text = calculate_alfa(diameterBig, diameterSmall, stepCircle)
        }
    }

    private fun calculate_D(bD: Double, sD: Double, step: Double): String{
        if(bD == 0.0 || sD == 0.0 || step == 0.0){
            Toast.makeText(this, "You wrote NOT DIGITS or less then 0", Toast.LENGTH_LONG).show()
        }
        val a: Double = (bD-sD)/2
        val L: Double = sqrt((PI*bD).pow(2)+step.pow(2))
        val l: Double = sqrt((PI*sD).pow(2)+step.pow(2))
        val r: Double = (((a*l)/(L-l))*100.0).roundToInt()/100.0
        val R: Double = ((r+a)*100.0).roundToInt()/100.0
        return (R*2).toString()
    }

    private fun calculate_d(bD: Double, sD: Double, step: Double): String{
        if(bD == 0.0 || sD == 0.0 || step == 0.0){
            Toast.makeText(this, "You wrote NOT DIGITS or less then 0", Toast.LENGTH_LONG).show()
            return "Please write DIGITS more then 0"
        }
        val a: Double = (bD-sD)/2
        val L: Double = sqrt((PI*bD).pow(2)+step.pow(2))
        val l: Double = sqrt((PI*sD).pow(2)+step.pow(2))
        val r: Double = (((a*l)/(L-l))*100.0).roundToInt()/100.0
        return (r*2).toString()
    }

    private fun calculate_ExCutout(bD: Double, sD: Double, step: Double): String{
        if(bD == 0.0 || sD == 0.0 || step == 0.0){
            Toast.makeText(this, "You wrote NOT DIGITS or less then 0", Toast.LENGTH_LONG).show()
            return "Please write DIGITS more then 0"
        }
        val a: Double = (bD-sD)/2
        val L: Double = sqrt((PI*bD).pow(2)+step.pow(2))
        val l: Double = sqrt((PI*sD).pow(2)+step.pow(2))
        val r: Double = (((a*l)/(L-l))*100.0).roundToInt()/100.0
        val R: Double = ((r+a)*100.0).roundToInt()/100.0
        val alfa: Double = (((2*PI*R)-L)/(2*PI*R))*360
        val T: Double = sqrt((R.pow(2))+(R.pow(2))-((2*R*R)* cos(alfa)))
        val betta: Double = (2*PI)-alfa
        return T.toString()
    }

    private fun calculate_InCutout(bD: Double, sD: Double, step: Double): String{
        if(bD == 0.0 || sD == 0.0 || step == 0.0){
            Toast.makeText(this, "You wrote NOT DIGITS or less then 0", Toast.LENGTH_LONG).show()
            return "Please write DIGITS more then 0"
        }
        val a: Double = (bD-sD)/2
        val L: Double = sqrt((PI*bD).pow(2)+step.pow(2))
        val l: Double = sqrt((PI*sD).pow(2)+step.pow(2))
        val r: Double = (((a*l)/(L-l))*100.0).roundToInt()/100.0
        val R: Double = ((r+a)*100.0).roundToInt()/100.0
        val alfa: Double = (((2*PI*R)-L)/(2*PI*R))*360
        val betta: Double = (2*PI)-alfa
        return alfa.toString()
    }

    private fun calculate_alfa(bD: Double, sD: Double, step: Double): String{
        if(bD == 0.0 || sD == 0.0 || step == 0.0){
            Toast.makeText(this, "You wrote NOT DIGITS or less then 0", Toast.LENGTH_LONG).show()
            return "Please write DIGITS more then 0"
        }
        val a: Double = (bD-sD)/2
        val L: Double = sqrt((PI*bD).pow(2)+step.pow(2))
        val l: Double = sqrt((PI*sD).pow(2)+step.pow(2))
        val r: Double = (((a*l)/(L-l))*100.0).roundToInt()/100.0
        val R: Double = ((r+a)*100.0).roundToInt()/100.0
        val alfa: Double = (((2*PI*R)-L)/(2*PI*R))*360
        val betta: Double = (2*PI)-alfa
        return alfa.toString()
    }
}