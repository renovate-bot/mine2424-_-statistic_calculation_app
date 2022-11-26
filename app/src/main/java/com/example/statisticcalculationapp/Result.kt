package com.example.statisticcalculationapp

// TODO: convert data class to normal optional class
data class Result(
    var summary: String,
    val attemptsNumber: Int,
    val successNumber: Int,
    val probabilityOfSuccess: Double,
)