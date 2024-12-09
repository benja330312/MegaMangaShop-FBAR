package org.example.montaine.guillaume.tests

import de.huxhorn.sulky.ulid.ULID
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import montaine.guillaume.Boutique
import montaine.guillaume.TicketDeCaisse
import org.example.montaine.guillaume.montaine.guillaume.PaysValides

class TaxesTest : BehaviorSpec ({
    context("Je veux vérifier qu'étant donné une commande en France, j'ai une TVA de 20%") {

        given("Une commande avec une boutique française") {
            val commande = TicketDeCaisse(ULID().nextULID(), Boutique(PaysValides.FRA), 100.0)

            When("Je demande la TVA associée") {
               val tva = commande.getTax()

                Then("Je reçois 20.0") {
                    tva shouldBe 20.0
                }
            }
        }
    }
    context("Je veux vérifier qu'étant donné une commande en Allemagne, j'ai une TVA de 15,6%") {
        given("Une commande avec une boutique allemande") {
            val commande = TicketDeCaisse(ULID().nextULID(), Boutique(PaysValides.ALL), 20.0)

            When("Je demande la TVA associée") {
                val tva = commande.getTax()

                Then("Je reçois 15.6") {
                    tva shouldBe 15.6
                }

            }
        }
    }
})