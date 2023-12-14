package com.musicas.executandomusicas

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    // Declarando variáveis globais para os elementos da interface e o MediaPlayer --
    private lateinit var executarSom: ImageView
    private var mediaPlayer = MediaPlayer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicializando a variável executarSom com o ImageView do layout
        executarSom = findViewById(R.id.executarSom)

        // Inicializando o MediaPlayer com a primeira música (badmantingsriddim)
        mediaPlayer = MediaPlayer.create(this, R.raw.badmantingsriddim)

        // Configurando um OnClickListener para o botão de executar/pausar música
        executarSom.setOnClickListener {

            // Verificando se o MediaPlayer está reproduzindo
            if (mediaPlayer.isPlaying) {
                // Se estiver reproduzindo, pausa a música e muda o ícone para pause
                mediaPlayer.pause()
                executarSom.setImageResource(R.drawable.ic_pause)
            } else {
                // Se não estiver reproduzindo, inicia a música e muda o ícone para play
                mediaPlayer.start()
                executarSom.setImageResource(R.drawable.ic_play)
            }
        }

        // Inicializando o botão de parar música
        val pararMusicaButton = findViewById<ImageView>(R.id.parar_musica)

        // Configurando um OnClickListener para o botão de parar música
        pararMusicaButton.setOnClickListener {

            // Verificando se o MediaPlayer está reproduzindo
            if (mediaPlayer.isPlaying){
                // Se estiver reproduzindo, para a música e reinicializa o MediaPlayer
                mediaPlayer.stop()
                mediaPlayer = MediaPlayer.create(this, R.raw.badmantingsriddim)
            }
        }
    }
}