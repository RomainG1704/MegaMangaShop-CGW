package org.example.montaine.guillaume.tests

import org.example.montaine.guillaume.montaine.guillaume.Livre
import org.example.montaine.guillaume.montaine.guillaume.Panier
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class PanierTest {

    private lateinit var panier: Panier

    @BeforeEach
    fun setup() {
        panier = Panier()
    }

    @Test
    fun testAjouterLivreQuantitePositive() {
        val livre = Livre("Harry Potter", 20.0F)
        panier.ajouterLivre(livre, 2)

        assertEquals(2, panier.taillePanier(), "Le panier devrait contenir 2 livres après ajout")
        assertEquals(40.0F, panier.calculerPrix(), "Le prix total devrait être égal au prix du livre multiplié par la quantité")
    }

    @Test
    fun testAjouterLivreQuantiteZero() {
        val livre = Livre("Le Hobbit", 15.0F)
        panier.ajouterLivre(livre, 0)

        assertEquals(0, panier.taillePanier(), "Le panier ne devrait pas augmenter si la quantité ajoutée est 0")
        assertEquals(0.0F, panier.calculerPrix(), "Le prix total devrait être 0 si aucun livre n'est ajouté")
    }

    @Test
    fun testAjouterLivreQuantiteNegative() {
        val livre = Livre("1984", 10.0F)

        val exception = assertThrows<IllegalArgumentException> {
            panier.ajouterLivre(livre, -1)
        }

        assertNotNull(exception, "Une exception devrait être lancée pour une quantité négative")
    }

    @Test
    fun testAjouterPlusieursLivres() {
        val livre1 = Livre("Harry Potter", 20.0F)
        val livre2 = Livre("Le Hobbit", 15.0F)

        panier.ajouterLivre(livre1, 1)
        panier.ajouterLivre(livre2, 3)

        assertEquals(4, panier.taillePanier(), "Le panier devrait contenir 4 livres au total")
        assertEquals(65.0F, panier.calculerPrix(), "Le prix total devrait être la somme des prix des livres multipliés par leurs quantités")
    }

    @Test
    fun testAjouterQuantiteCumulative() {
        val livre = Livre("Harry Potter", 20.0F)

        panier.ajouterLivre(livre, 2)
        panier.ajouterLivre(livre, 3)

        assertEquals(5, panier.taillePanier(), "Le panier devrait cumuler les quantités pour le même livre")
        assertEquals(100.0F, panier.calculerPrix(), "Le prix total devrait être mis à jour en conséquence")
    }

    @Test
    fun testPanierVide() {
        assertEquals(0, panier.taillePanier(), "Un nouveau panier devrait être vide")
        assertEquals(0.0F, panier.calculerPrix(), "Le prix total d'un panier vide devrait être 0")
    }
}
