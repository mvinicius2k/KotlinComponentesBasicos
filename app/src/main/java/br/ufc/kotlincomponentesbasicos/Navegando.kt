package br.ufc.kotlincomponentesbasicos

import android.app.Activity
import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.view.MenuItem
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.ArrayList


class Navegando : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var listView: ListView
    private lateinit var btnPopup: Button
    private lateinit var player: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navegando)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.title = "Navegando"

        this.player = MediaPlayer.create(this, R.raw.som)

        viewManager = LinearLayoutManager(this)


        val array = intent.getStringArrayListExtra("array")

        if(array != null){
            viewAdapter = RecyclerAdapter(array)
            recyclerView = findViewById<RecyclerView>(R.id.recLista).apply {
                setHasFixedSize(true)
                layoutManager = viewManager
                adapter = viewAdapter

            }

            this.listView = findViewById(R.id.lisListView)
            val adapter = ArrayAdapter(this,android.R.layout.simple_list_item_1, array)
            listView.adapter = adapter

            listView.setOnItemLongClickListener { _, _, position, _ ->

                Toast.makeText(this, array[position] + " segurado.", Toast.LENGTH_SHORT).show()

                true
            }

            btnPopup = findViewById(R.id.btnPopup)

            btnPopup.setOnClickListener {
                val popupMenu = PopupMenu(this,btnPopup)
                popupMenu.menuInflater.inflate(R.menu.options_menu, popupMenu.menu)

                popupMenu.setOnMenuItemClickListener { item: MenuItem? ->
                    if (item != null) {
                        when(item.itemId){
                            R.id.item0 -> {
                                finish()
                            }
                            R.id.item1 -> {
                                Toast.makeText(this, "Já estamos nessa tela", Toast.LENGTH_SHORT).show()

                            }
                            R.id.item2 -> {
                                player.start()

                            }
                            R.id.item3 -> {
                                val intent = Intent(this, Tabs::class.java)

                                startActivity(intent)
                            }


                        }
                    }
                    true
                }

                popupMenu.show()

            }

        }












    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return true
    }
}