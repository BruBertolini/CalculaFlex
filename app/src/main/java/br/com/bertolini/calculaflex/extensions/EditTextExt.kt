package br.com.bertolini.calculaflex.extensions

import android.widget.EditText

fun EditText.getValue() = this.text.toString()

fun EditText.getDouble() = this.getValue().toDouble()