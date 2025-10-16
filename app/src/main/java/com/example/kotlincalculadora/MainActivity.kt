package com.example.kotlincalculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    // En esta sección, declaramos las variables que se utilizarán en toda la clase.
    // resultTextView es el campo de texto donde se muestran los números y resultados.
    // operand1 y operand2 almacenan los números para las operaciones.
    // currentOperator guarda el operador seleccionado (+, -, *, /).
    // isOperatorClicked es una bandera para saber si se ha presionado un operador.
    private lateinit var resultTextView: TextView
    private var operand1: Double = 0.0
    private var operand2: Double = 0.0
    private var currentOperator: String = ""
    private var isOperatorClicked: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // En el método onCreate, inicializamos la vista y configuramos los listeners de los botones.
        // Primero, obtenemos la referencia al TextView del layout.
        resultTextView = findViewById(R.id.resultTextView)

        // Luego, creamos una lista de todos los botones numéricos.
        val buttons = listOf<Button>(
            findViewById(R.id.button0),
            findViewById(R.id.button1),
            findViewById(R.id.button2),
            findViewById(R.id.button3),
            findViewById(R.id.button4),
            findViewById(R.id.button5),
            findViewById(R.id.button6),
            findViewById(R.id.button7),
            findViewById(R.id.button8),
            findViewById(R.id.button9)
        )

        // Recorremos la lista de botones numéricos y asignamos un OnClickListener a cada uno.
        // Cada vez que se presiona un botón numérico, se llama a la función onNumberClick.
        buttons.forEach { button ->
            button.setOnClickListener { onNumberClick(it) }
        }

        // Hacemos lo mismo para los botones de operadores.
        val operatorButtons = listOf<Button>(
            findViewById(R.id.buttonAdd),
            findViewById(R.id.buttonSubtract),
            findViewById(R.id.buttonMultiply),
            findViewById(R.id.buttonDivide)
        )

        // Asignamos el OnClickListener a los botones de operadores, llamando a onOperatorClick.
        operatorButtons.forEach { button ->
            button.setOnClickListener { onOperatorClick(it) }
        }

        // Finalmente, asignamos los OnClickListeners para los botones de igual y limpiar.
        findViewById<Button>(R.id.buttonEquals).setOnClickListener { onEqualsClick() }
        findViewById<Button>(R.id.buttonClear).setOnClickListener { onClearClick() }
    }

    /**
     * Esta función se llama cuando se presiona un botón numérico.
     * Si se acaba de presionar un operador, el nuevo número reemplaza el texto actual.
     * Si no, el número se agrega al final del texto actual.
     * También se maneja el caso especial de no agregar ceros a la izquierda.
     */
    private fun onNumberClick(view: View) {
        val button = view as Button
        if (isOperatorClicked) {
            resultTextView.text = button.text
            isOperatorClicked = false
        } else {
            if (resultTextView.text.toString() == "0") {
                resultTextView.text = button.text
            } else {
                resultTextView.append(button.text)
            }
        }
    }

    /**
     * Esta función se llama cuando se presiona un botón de operador.
     * Almacena el número actual como el primer operando (operand1).
     * Guarda el operador que se ha presionado.
     * Y activa la bandera isOperatorClicked para indicar que el siguiente número será el segundo operando.
     */
    private fun onOperatorClick(view: View) {
        val button = view as Button
        operand1 = resultTextView.text.toString().toDouble()
        currentOperator = button.text.toString()
        isOperatorClicked = true
    }

    /**
     * Esta función se llama cuando se presiona el botón de igual.
     * Almacena el número actual como el segundo operando (operand2).
     * Utiliza una sentencia 'when' para realizar la operación correcta según el currentOperator.
     * Muestra el resultado en el resultTextView.
     */
    private fun onEqualsClick() {
        operand2 = resultTextView.text.toString().toDouble()
        val result = when (currentOperator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "*" -> operand1 * operand2
            "/" -> operand1 / operand2
            else -> 0.0
        }
        resultTextView.text = result.toString()
        isOperatorClicked = true
    }

    /**
     * Esta función se llama cuando se presiona el botón de limpiar (C).
     * Reinicia todas las variables a sus valores iniciales, dejando la calculadora en un estado limpio.
     */
    private fun onClearClick() {
        resultTextView.text = "0"
        operand1 = 0.0
        operand2 = 0.0
        currentOperator = ""
        isOperatorClicked = false
    }
}
