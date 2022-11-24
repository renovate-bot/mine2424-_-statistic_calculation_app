package com.example.statisticcalculationapp

import android.widget.EditText
import androidx.fragment.app.Fragment
import com.google.android.material.textfield.TextInputLayout

class FormFragment: Fragment() {
    private lateinit var attemptsNumber: EditText
    private lateinit var probabilityOfSuccessNumber: EditText
    private lateinit var successNumber: EditText
    private lateinit var attemptsNumberInput: TextInputLayout
    private lateinit var probabilityOfSuccessNumberInput: TextInputLayout
    private lateinit var successNumberInput: TextInputLayout

    private fun setError() {
        if (attemptsNumber.text.isEmpty()) {
            attemptsNumberInput.error = "empty"
        }
        if (probabilityOfSuccessNumber.text.isEmpty()) {
            probabilityOfSuccessNumberInput.error = "empty"
        }
        if (successNumber.text.isEmpty()) {
            successNumberInput.error = "empty"
        }
    }
}