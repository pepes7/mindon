package com.example.mindon.activity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TableRow
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mindon.R
import java.io.IOException
import java.io.InputStream
import java.util.*

class HangmanGame : AppCompatActivity() {
    //declaração de variáveis
    var viewWordToBeGuessed: TextView? = null
    var viewLettersTried: TextView? = null
    var viewTriesLeft: TextView? = null
    var viewScores: TextView? = null
    lateinit var wordDisplayedCharArray: CharArray
    var wordToBeGuessed: String? = null
    var wordDisplayedString: String? = null
    var lettersTried: String? = null
    var triesLeft: String? = null
    var listOfWords: ArrayList<String?>? = null
    var wordInput: EditText? = null

    //variavel que define a dificuldade e os conteudos
    var level = 0

    //inicializando o timer e suas variáveis
    var timerView: TextView? = null
    var countDownTimer: CountDownTimer? = null
    var timeToBeCountDown: Long = 180000 //3 min
    var hits = 0
    val messageWithLettersTried = "Letras já usadas: "
    val winMessage = "You won!"
    val losingMessage = "You lost!"
    var buttonRotateAnimation: Animation? = null
    var scaleAndZoomAnimation: Animation? = null
    var scaleAndRotateAnimaton: Animation? = null
    var trReset: TableRow? = null
    var trTriesLeft: TableRow? = null
    fun revealLetterInWord(letter: Char) {
        var indexOfLetter = wordToBeGuessed!!.indexOf(letter)
        while (indexOfLetter >= 0) {
            wordDisplayedCharArray[indexOfLetter] = wordToBeGuessed!![indexOfLetter]
            indexOfLetter = wordToBeGuessed!!.indexOf(letter, indexOfLetter + 1)
        }

        //atualizar a string
        wordDisplayedString = String(wordDisplayedCharArray)
    }

    fun displayWordOnScreen() {
        var formattedString = ""
        for (character in wordDisplayedCharArray) {
            formattedString += "$character "
        }
        viewWordToBeGuessed!!.text = formattedString
    }

    fun displayScoreOnScreen() {
        var formattedString = ""
        hits++
        formattedString = "$hits "
        viewScores!!.text = formattedString
    }

    fun startGame() {
        //1 - COLETAR E EXIBIR AS PALAVRAS
        //realizar a distribuição aleatória das palavras do arrayList e pegar o primeiro elemento, e remover
        Collections.shuffle(listOfWords)
        wordToBeGuessed = listOfWords!![0]

        //inicializar o char array
        wordDisplayedCharArray = wordToBeGuessed!!.toCharArray()

        //adicionando sublinhas
        for (i in 1 until wordDisplayedCharArray.size - 1) {
            wordDisplayedCharArray[i] = '_'
        }

        //revelar a primeira letra das palavras
        revealLetterInWord(wordDisplayedCharArray[0])
        //revelar a última letra das palavras
        revealLetterInWord(wordDisplayedCharArray[wordDisplayedCharArray.size - 1])

        //inicializar uma string para o char array
        wordDisplayedString = String(wordDisplayedCharArray)
        //mostrar a string
        displayWordOnScreen()

        //2 - LIMPAR O INPUT
        //limpar os campos do input
        wordInput!!.setText("")

        //3 - LETTERS TRIED
        //Inicializando a string lettersTried com um espaço em branco
        lettersTried = " "
        //exibir na tela
        viewLettersTried!!.text = messageWithLettersTried

        //TRIES LEFT
        //inicializando a string com as tentativas que faltam
        triesLeft = " X  X  X  X  X  X "
        viewTriesLeft!!.text = triesLeft
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hangman_game)

        //inicializando variáveis
        listOfWords = ArrayList()
        viewWordToBeGuessed = findViewById<View>(R.id.wordToBeGuessed) as TextView
        wordInput = findViewById<View>(R.id.inputEditText) as EditText
        viewLettersTried = findViewById<View>(R.id.lettersUsed) as TextView
        viewTriesLeft = findViewById<View>(R.id.tries) as TextView
        viewScores = findViewById<View>(R.id.scoreView) as TextView
        trReset = findViewById<View>(R.id.tableRowReset) as TableRow
        trTriesLeft = findViewById<View>(R.id.tableRowTriesLeft) as TableRow
        timerView = findViewById(R.id.timerView)
        buttonRotateAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate)
        scaleAndZoomAnimation = AnimationUtils.loadAnimation(this, R.anim.scale)
        scaleAndRotateAnimaton = AnimationUtils.loadAnimation(this, R.anim.scale_and_rotate)


        //escanear os arquivos database.txt e inserir as palavras na arrayList
        var myInputStream: InputStream? = null
        var input: Scanner? = null
        var actualWord: String? = ""
        try {
            val getContent = intent.extras
            if (getContent != null) {
                level = getContent.getInt("content")
            }
            myInputStream = if (level == 0) {
                assets.open("database_hangman_beginner_file.txt") //escanear o database do easy level
            } else if (level == 1) {
                assets.open("database_hangman_intermediary_file.txt") //escanear o database do intermediary level
            } else {
                assets.open("database_hangman_advanced_file.txt") //escanear o database do advanced level
            }
            input = Scanner(myInputStream)
            while (input.hasNext()) { //enquanto o database ainda tiver palaras para ler
                actualWord = input.next()
                listOfWords!!.add(actualWord)
            }
        } catch (e: IOException) {
            Toast.makeText(this@HangmanGame, e.javaClass.simpleName + ": " + e.message, Toast.LENGTH_SHORT).show()
        } finally {
            //encerrar o scanner se o input não estiver vazio (se o try for executado)
            input?.close()
            //encerrar a Input Stream
            try {
                myInputStream?.close()
            } catch (e: IOException) {
                Toast.makeText(this@HangmanGame, e.javaClass.simpleName + ": " + e.message, Toast.LENGTH_SHORT).show()
            }
        }

        //inicializar o jogo
        startGame()

        //inicializar o timer
        startTimer()

        //ligação do text changed listener com o edit text
        wordInput!!.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                //se alguma letra já estiver no input field, o index do char será 0
                if (s.length != 0) {
                    checkIfLetterIsInWord(s[0])
                }
            }

            override fun afterTextChanged(s: Editable) {}
        })
    }

    fun checkIfLetterIsInWord(letter: Char) {
        //verificar se a letra foi encontrada dentro da wordToBeGuessed
        if (wordToBeGuessed!!.indexOf(letter) >= 0) {
            //a letra ainda não foi exibida
            if (wordDisplayedString!!.indexOf(letter) < 0) {
                //animação
                viewWordToBeGuessed!!.startAnimation(scaleAndZoomAnimation)

                //substituir as sublinhas com a letra escolhida
                revealLetterInWord(letter)
                //atualizar as mudanças na tela
                displayWordOnScreen()

                //verificar se o jogo foi vencido (se a letra foi a última)
                if (!wordDisplayedString!!.contains("_")) {
                    //limpando a animação nas table rows
                    trTriesLeft!!.clearAnimation()
                    startGame()
                    displayScoreOnScreen()
                }
            }
        } else {
            //a letra não foi encontrada dentro da wordToBeGuessed
            //decrementando o núero de tentativas restantes, e mostrar na tela
            decreaseAndDisplayTriesLeft()

            //verificar se o jogo foi perdido{
            if (triesLeft!!.isEmpty()) {
                //trTriesLeft.startAnimation(scaleAndRotateAnimaton);
                //viewTriesLeft.setText(losingMessage);
                viewWordToBeGuessed!!.text = wordToBeGuessed
                callGameOver()
            }
        }

        //exibir a letra que foi lançada
        if (lettersTried!!.indexOf(letter) < 0) {
            lettersTried += "$letter, "
            val messageToBeDisplayed = messageWithLettersTried + lettersTried
            viewLettersTried!!.text = messageToBeDisplayed
        }
    }

    fun decreaseAndDisplayTriesLeft() {
        //verificar se ainda restam tentativas
        if (!triesLeft!!.isEmpty()) {
            //remover os últimos 3 caracteres da string
            triesLeft = triesLeft!!.substring(0, triesLeft!!.length - 3)
            viewTriesLeft!!.text = triesLeft
        }
    }

    fun resetGame(v: View?) {
        //animação
        trReset!!.startAnimation(buttonRotateAnimation)

        //limpando a animação nas table rows
        trTriesLeft!!.clearAnimation()
        //iniciar um novo jogo
        startGame()
    }

    fun callGameOver() {
        val intent = Intent(this@HangmanGame, GameOverHangman::class.java)
        intent.putExtra("score", hits)
        intent.putExtra("level", level)
        countDownTimer!!.cancel()
        startActivity(intent)
    }

    fun startTimer() {
        countDownTimer = object : CountDownTimer(timeToBeCountDown, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                timeToBeCountDown = millisUntilFinished
                updateTimer()
            }

            override fun onFinish() {
                callGameOver()
            }
        }.start()
    }

    fun updateTimer() {
        val minutes = timeToBeCountDown.toInt() / 60000
        val seconds = timeToBeCountDown.toInt() % 60000 / 1000
        var timeLeftText: String
        timeLeftText = "" + minutes
        timeLeftText += ":"
        if (seconds < 10) timeLeftText += "0"
        timeLeftText += seconds
        timerView!!.text = timeLeftText
    }

    override fun onBackPressed() {
        super.onBackPressed()
        countDownTimer!!.cancel()
    }
}