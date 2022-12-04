package com.example.statisticcalculationapp

import java.math.BigInteger

// TODO: convert data class to normal optional class
data class Result(
    var summary: String,
    val attemptsNumber: BigInteger,
    val successNumber: BigInteger,
    val probabilityOfSuccess: Double,
)