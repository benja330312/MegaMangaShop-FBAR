package org.example.montaine.guillaume.montaine.guillaume

enum class PaysValides(val tva: Double) {
    FRA(20.0),
    ESP(18.2),
    ALL(15.6),
    UK(22.8),
    BEL(17.0);

    fun getTVA(): Double {
        return tva
    }
}
