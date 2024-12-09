
package org.example.montaine.guillaume

import org.example.montaine.guillaume.montaine.guillaume.Remise
import org.example.montaine.guillaume.montaine.guillaume.Remises

fun main() {
    val remises = Remises(mutableListOf(
        Remise(0, 150, 1f),
        Remise(150, 200, 0.98f),
        Remise(200, 300, 0.97f),
        Remise(300, 500, 0.95f),
        Remise(500, 1000, 0.93f),
        Remise(500, Int.MAX_VALUE, 0.9f)
    ))

}