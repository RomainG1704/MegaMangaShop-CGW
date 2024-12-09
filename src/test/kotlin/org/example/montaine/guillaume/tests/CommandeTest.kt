package org.example.montaine.guillaume.tests

import org.example.montaine.guillaume.montaine.guillaume.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class CommandeTest {


    @BeforeEach
    fun setup() {
        val remises = Remises(mutableListOf(
            Remise(0, 150, 1f),
            Remise(150, 200, 0.98f),
            Remise(200, 300, 0.97f),
            Remise(300, 500, 0.95f),
            Remise(500, 1000, 0.93f),
            Remise(500, Int.MAX_VALUE, 0.9f)
        ))
    }

    @Test
    fun testCommande1Sprint1() {
        val boutique = Boutique("France")
        val commande : Commande = Commande(boutique)
        val livre = Livre("Harry Potter", 3.99F)
        commande.getPanier().ajouterLivre(livre, 19)
        assertEquals(90.972F, commande.calculerPrix())
    }

    @Test
    fun testCommande2Sprint1() {
        val boutique = Boutique("France")
        val commande : Commande = Commande(boutique)
        val livre1 = Livre("Harry Potter", 3.92F)
        val livre2 = Livre("Harry Potter", 4.10F)
        commande.getPanier().ajouterLivre(livre1, 42)
        commande.getPanier().ajouterLivre(livre2, 82)
        assertEquals(558.93744F, commande.calculerPrix())
    }

    @Test
    fun testCommande1Sprint2() {
        val boutique = Boutique("Espagne")
        val commande : Commande = Commande(boutique)
        val livre = Livre("Harry Potter", 3.99F)
        commande.getPanier().ajouterLivre(livre, 19)
        assertEquals(89.60742F, commande.calculerPrix())
    }

    @Test
    fun testCommande2Sprint2() {
        val boutique = Boutique("France")
        val commande : Commande = Commande(boutique)
        val livre1 = Livre("Harry Potter", 3.92F)
        val livre2 = Livre("Harry Potter", 4.10F)
        val livre3 = Livre("Harry Potter", 18.95F)
        commande.getPanier().ajouterLivre(livre1, 42)
        commande.getPanier().ajouterLivre(livre2, 82)
        commande.getPanier().ajouterLivre(livre3, 12)
        assertEquals(812.7158F, commande.calculerPrix())
    }
}