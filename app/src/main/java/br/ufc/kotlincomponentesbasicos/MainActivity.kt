package br.ufc.kotlincomponentesbasicos

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    lateinit var spinnerLista: ArrayList<String>
    lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.spinnerLista = ArrayList()
        this.player = MediaPlayer.create(this, R.raw.som)

        val fundo = findViewById<ConstraintLayout>(R.id.layFundo)
        val etxtEditText = findViewById<EditText>(R.id.etxtEditText)
        val radAzul = findViewById<RadioButton>(R.id.radAzul)
        val radVerde = findViewById<RadioButton>(R.id.radVerde)
        val radVermelho = findViewById<RadioButton>(R.id.radVermelho)
        val viewText = findViewById<TextView>(R.id.txtvToggleButton)
        val viewBotao = findViewById<ToggleButton>(R.id.tbtnBotao)

        radAzul.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                fundo.setBackgroundColor(Color.rgb(200,200,250))
            }
        }

        radVerde.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){
                fundo.setBackgroundColor(Color.rgb(200,250,200))
            }
        }

        radVermelho.setOnCheckedChangeListener { _, isChecked ->
            if(isChecked){

                fundo.setBackgroundColor(Color.rgb(250,200,200))
            }
        }

        etxtEditText.setOnKeyListener { _, _, _ ->
            findViewById<TextView>(R.id.txtBemVindo).text = "Olá " + etxtEditText.text
            true
        }

        viewBotao.setOnCheckedChangeListener() { _, isChecked ->

            Log.d("Bug","Apertado")

            if(isChecked){
                viewText.text = getString(R.string.toggle_on)
                etxtEditText.isEnabled = true
            }
            else{
                viewText.text = getString(R.string.toggle_off)

                etxtEditText.isEnabled = false


            }

        }



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflar = menuInflater
        inflar.inflate(R.menu.options_menu, menu)



        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.item0 -> {
                Toast.makeText(this, "Já estamos em Início", Toast.LENGTH_SHORT).show()
            }
            R.id.item1 -> {
                val bundle = Bundle()
                bundle.putStringArrayList("array",spinnerLista)

                val intent = Intent(this, Navegando::class.java)

                intent.putExtras(bundle)
                startActivity(intent)
            }
            R.id.item2 -> {
                player.start()

            }
            R.id.item3 -> {
                val intent = Intent(this, Tabs::class.java)

                startActivity(intent)
            }


        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
    }
    
    fun onBtnAdicionarClick(v: View){
        var autoCompleteTxt = findViewById<AutoCompleteTextView>(R.id.atxtAutoComplete).text.toString()

        spinnerLista.add(autoCompleteTxt)


        val spinner = findViewById<Spinner>(R.id.spnSpinner)

        val adaptador = ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, spinnerLista)
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinner.adapter = adaptador

        val autocomplete = findViewById<AutoCompleteTextView>(R.id.atxtAutoComplete)
        val adaptadorAutoComplete = ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, spinnerLista)
        autocomplete.threshold = 1
        autocomplete.setAdapter(adaptadorAutoComplete)


    }







}