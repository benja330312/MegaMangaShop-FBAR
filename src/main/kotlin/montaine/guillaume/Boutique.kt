package montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Article
import org.example.montaine.guillaume.montaine.guillaume.PaysValides

class Boutique(val Pays: PaysValides) {

    public val nom: String = "MegaMangaShop"
    private val articles = mutableListOf<Article>()

    fun ajouterArticle(article: Article){
        articles.add(article)
    }

    fun getTotalHTCommande():Double{
        var totalHT = 0.0
        for (article in articles) {
            totalHT += article.calculerTotal()
        }
        return totalHT
    }

    fun creerTicket(): TicketDeCaisse {
        return TicketDeCaisse(boutique = this, TotalHT = getTotalHTCommande())
    }
}

