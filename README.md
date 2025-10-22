# Calculadora en Kotlin

Esta es una aplicación de calculadora simple para Android desarrollada en Kotlin.

## Características

*   Operaciones aritméticas básicas: suma, resta, multiplicación y división.
*   Interfaz de usuario clara y fácil de usar.
*   Botón de limpiar para reiniciar el cálculo.

## Estructura del Proyecto

El proyecto sigue la estructura estándar de un proyecto de Android Studio.

*   `app/src/main/java/com/example/kotlincalculadora/MainActivity.kt`: Contiene la lógica principal de la calculadora.
*   `app/src/main/res/layout/activity_main.xml`: Define el diseño de la interfaz de usuario de la calculadora.
*   `app/build.gradle`: Contiene las dependencias y la configuración de compilación para el módulo de la aplicación.
*   `build.gradle`: Contiene la configuración de compilación para todo el proyecto.
*   `settings.gradle`: Define los módulos que se incluirán en la compilación.
*   `app/src/main/AndroidManifest.xml`: El manifiesto de la aplicación.



## Diseño de la Interfaz de Usuario

La interfaz de usuario se define en `app/src/main/res/layout/activity_main.xml`. Utiliza un `LinearLayout` vertical para organizar la pantalla de resultados y la cuadrícula de botones. La cuadrícula de botones es un `GridLayout` para garantizar una disposición uniforme.

## Eventos y Listeners

Los eventos de clic en los botones se manejan en `MainActivity.kt`. Cada botón tiene un `OnClickListener` que llama a la función correspondiente para manejar la lógica:

*   `onNumberClick()`: Para los botones numéricos.
*   `onOperatorClick()`: Para los botones de operación.
*   `onEqualsClick()`: Para el botón de igual.
*   `onClearClick()`: Para el botón de limpiar.
