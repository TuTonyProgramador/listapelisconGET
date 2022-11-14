package com.example.listapelisconget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.listapelisconget.Peliculas.APIService
import com.example.listapelisconget.Peliculas.PelisResponser
import com.example.listapelisconget.adapter.PeliAdapter
import com.example.listapelisconget.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Cargar e inicializar el recyclerview
        binding.recycler.layoutManager = LinearLayoutManager(this)

        // Creamos una variable del tipo adapter con una lista vacia
        val peliAdapter = PeliAdapter(emptyList())

        binding.recycler.adapter = peliAdapter

        // Llamada a la API dentro de una corrutina
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getPelisMovies("movie/popular?api_key=1a1d91b004bfd10e9eb30942de1b0b4a")

            val peli = call.body()

            //Salir de la corrutina
            runOnUiThread{
                // Si la respuesta ha tenido exito cargamos la pelicula
                if (call.isSuccessful){
                    val resultado = peli?.results ?: emptyList()
                    peliAdapter.images = resultado
                    peliAdapter.notifyDataSetChanged()
                }
                else{
                    Toast.makeText(this@MainActivity,"Ha ocurrido un error", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

}