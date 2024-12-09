package montaine.guillaume

import de.huxhorn.sulky.ulid.ULID

class TicketDeCaisse(val id: String = ULID().nextULID(), val boutique: Boutique, val totalHT: Double) {

    init {
        if (totalHT.equals(0.0)) {
            throw IllegalArgumentException("Le montant HT ne peut pas être nul ou inférieur ou égal à zéro.")
        }
        if (totalHT < 0.0){
            throw IllegalArgumentException("Le montant HT est nul !")
        }
    }

    fun getTax(): Double {
        return boutique.Pays.getTVA()
    }

    fun getRemise(): Double {
        return when {
            totalHT > 1000 -> 0.10
            totalHT in 500.0..1000.0 -> 0.07
            totalHT in 300.0..500.0 -> 0.05
            totalHT in 200.0..300.0 -> 0.03
            totalHT in 150.0..200.0 -> 0.02
            else -> 0.0
        }
    }

    fun getTotalTTC(): Double {
        return appliquerRemise(appliquerTVA(totalHT))
    }

    fun appliquerRemise(total: Double): Double {
        return total * (1 - getRemise())
    }

    fun appliquerTVA(total: Double): Double {
        return total * (1 + getTax()/100)
    }

    override fun toString(): String {
        // Arrondir les valeurs
        val totalHTArrondi = String.format("%.2f", totalHT)
        val tvaArrondi = String.format("%.2f", getTax())
        val remiseArrondie = String.format("%.2f", getRemise() * 100)
        val totalTTC = getTotalTTC()
        val totalTTCarrondi = String.format("%.2f", totalTTC)

        return """
        ##### ${boutique.nom} #####
        Total HT: $totalHTArrondi€
        TVA (${boutique.Pays}): $tvaArrondi%
        Remise: $remiseArrondie%
        Total TTC: $totalTTCarrondi€
    """.trimIndent()
    }

}