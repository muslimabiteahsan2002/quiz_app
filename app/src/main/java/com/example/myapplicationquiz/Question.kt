package com.example.myapplicationquiz

class Question {
    companion object {
        val question = listOf(
            "What is the capital city of bangladesh?",
            "What is the mother language day of bangladesh?",
            "What is the victory day of bangladesh?",
            "What is the may day of bangladesh?",
            "What is the independence day of bangladesh?",
            "What is the woman day of bangladesh?"
        )
        val option = listOf(
            listOf("dhaka", "sylhet", "khulna", "barishal"),
            listOf("21 feb", "26 march", "1 may", "16 dec"),
            listOf("21 feb", "26 march", "1 may", "16 dec"),
            listOf("21 feb", "26 march", "1 may", "16 dec"),
            listOf("21 feb", "26 march", "1 may", "16 dec"),
            listOf("21 feb", "8 march", "1 may", "16 dec")
        )
        val answer = listOf(
            "dhaka",
            "21 feb",
            "16 dec",
            "1 may",
            "26 march",
            "8 march"
        )
    }
}
