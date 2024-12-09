
package org.example.montaine.guillaume

import montaine.guillaume.Boutique
import org.example.montaine.guillaume.montaine.guillaume.Article
import org.example.montaine.guillaume.montaine.guillaume.PaysValides

fun main() {
    val boutiqueEspagne = Boutique(PaysValides.ESP, "Mangas esp")
    boutiqueEspagne.ajouterArticle(Article("manga 1", 3.99, 19))

    println(boutiqueEspagne.creerTicket().toString())

    val boutiqueFrance = Boutique(PaysValides.FRA, "Mangas fr")
    boutiqueFrance.ajouterArticle(Article("manga 2", 3.92, 42))
    boutiqueFrance.ajouterArticle(Article("manga 3", 4.10, 82))
    boutiqueFrance.ajouterArticle(Article("manga 4", 18.95, 12))

    println(boutiqueFrance.creerTicket().toString())


}