package org.example.montaine.guillaume.tests

import de.huxhorn.sulky.ulid.ULID
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import montaine.guillaume.Boutique
import montaine.guillaume.TicketDeCaisse
import org.example.montaine.guillaume.montaine.guillaume.PaysValides

class RecapitulatifCommandeTest : BehaviorSpec ({
    context("Etant donné une commande avec remise et TVA en France") {
        given("Une commande de 400€ HT en France") {
            val commande = TicketDeCaisse(ULID().nextULID(), Boutique(PaysValides.FRA, "Manga Store"), 250.0)

            When("Je demande d'afficher un recapitulatif de la commande") {
                val recap = commande.toString()

                Then("J'ai un récapitulatif de la commande")
                    recap shouldBe "Boutique: Manga Store\n" +
                            "Total HT: 250.0€\n" +
                            "TVA (FRA): 20.0%\n" +
                            "Remise: 3.0%\n" +
                            "Total TTC: 291.0€"
            }
        }
    }
})