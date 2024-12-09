package org.example.montaine.guillaume.montaine.guillaume

class Article(val nom: String, val prixUnitaire: Double, var quantite: Int) {

    fun afficherDetails(): String {
        return "Article: $nom, Prix: $prixUnitaire€, Quantité: $quantite"
    }

    fun calculerTotal(): Double {
        if (quantite < 1) {
            throw IllegalArgumentException("Quantité nulle")
        }
        return prixUnitaire * quantite // Retourne le prix HT et non TTC !
    }
}