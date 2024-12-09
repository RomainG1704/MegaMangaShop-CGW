package org.example.montaine.guillaume.montaine.guillaume


class Remises {

    private val remises: MutableList<Remise>

    constructor(remises: MutableList<Remise>) {
        this.remises = remises
    }

    public fun addRemise(remise: Remise) {
        if (remises.any { current -> remise.isOverlapping(current) }) {
            throw IllegalArgumentException("The remise $remise is overlapping with another")
        }
        remises.add(remise)
    }

}