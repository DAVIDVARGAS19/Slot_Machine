package com.davidvargas.slotmachine

import android.annotation.SuppressLint
import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import android.os.Handler
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {
    @SuppressLint("ShowToast")

    val random = Random()
    var slot1: Int = 0
    var slot2: Int = 0
    var slot3: Int = 0
    var ganancias: Int = 10000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mainActivityBtJugar.setOnClickListener {

            val toast = Toast.makeText(this, "Se han descontado 1000 euros", Toast.LENGTH_SHORT)

            toast.show()


            mainActivitySlot1.setImageResource(R.drawable.animation)
            val slot1Anin: AnimationDrawable = mainActivitySlot1.drawable as AnimationDrawable
            slot1Anin.start()

            mainActivitySlot2.setImageResource(R.drawable.animation)
            val slot2Anin: AnimationDrawable = mainActivitySlot2.drawable as AnimationDrawable
            slot2Anin.start()

            mainActivitySlot3.setImageResource(R.drawable.animation)
            val slot3Anin: AnimationDrawable = mainActivitySlot3.drawable as AnimationDrawable
            slot3Anin.start()

            val handler = Handler()
            handler.postDelayed({

                slot1Anin.stop()
                slot2Anin.stop()
                slot3Anin.stop()
                toast.cancel()

                setImagenes()
                obtenerPuntaje()

            }, 1000)
        }
    }

    private fun setImagenes() {
        slot1 = random.nextInt(7)
        slot2 = random.nextInt(7)
        slot3 = random.nextInt(7)
        when (slot1) {

            0 -> mainActivitySlot1.setImageResource(R.drawable.ic_cereza)
            1 -> mainActivitySlot1.setImageResource(R.drawable.ic_dado)
            2 -> mainActivitySlot1.setImageResource(R.drawable.ic_gran_diamante)
            3 -> mainActivitySlot1.setImageResource(R.drawable.ic_herradura_grande)
            4 -> mainActivitySlot1.setImageResource(R.drawable.ic_maquina_de_casino)
            5 -> mainActivitySlot1.setImageResource(R.drawable.ic_poker)
            6 -> mainActivitySlot1.setImageResource(R.drawable.ic_trebol_grande)
        }
        when (slot2) {

            0 -> mainActivitySlot2.setImageResource(R.drawable.ic_cereza)
            1 -> mainActivitySlot2.setImageResource(R.drawable.ic_dado)
            2 -> mainActivitySlot2.setImageResource(R.drawable.ic_gran_diamante)
            3 -> mainActivitySlot2.setImageResource(R.drawable.ic_herradura_grande)
            4 -> mainActivitySlot2.setImageResource(R.drawable.ic_maquina_de_casino)
            5 -> mainActivitySlot2.setImageResource(R.drawable.ic_poker)
            6 -> mainActivitySlot2.setImageResource(R.drawable.ic_trebol_grande)
        }
        when (slot3) {

            0 -> mainActivitySlot3.setImageResource(R.drawable.ic_cereza)
            1 -> mainActivitySlot3.setImageResource(R.drawable.ic_dado)
            2 -> mainActivitySlot3.setImageResource(R.drawable.ic_gran_diamante)
            3 -> mainActivitySlot3.setImageResource(R.drawable.ic_herradura_grande)
            4 -> mainActivitySlot3.setImageResource(R.drawable.ic_maquina_de_casino)
            5 -> mainActivitySlot3.setImageResource(R.drawable.ic_poker)
            6 -> mainActivitySlot3.setImageResource(R.drawable.ic_trebol_grande)
        }

    }

    @SuppressLint("ShowToast", "SetTextI18n")
    private fun obtenerPuntaje() {

        if (slot1 == slot2 && slot2 == slot3) {

            val snackbar =
                Snackbar.make(relativeContainer, "Has ganado $100000 euros", Snackbar.LENGTH_SHORT)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(resources.getColor(R.color.gold))
            snackbar.show()
            ganancias += 100000

        } else if (slot1 == slot2 || slot2 == slot3 || slot1 == slot3) {
            val snackbar =
                Snackbar.make(relativeContainer, "Has ganado $5000 euros", Snackbar.LENGTH_SHORT)
            val snackbarView = snackbar.view
            snackbarView.setBackgroundColor(resources.getColor(R.color.Green))
            snackbar.show()
            ganancias += 50000
        }
        ganancias -= 1000
        mainActivityTvGanancias.text = "$$ganancias"
    }
}