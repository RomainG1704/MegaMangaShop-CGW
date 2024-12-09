package org.example.montaine.guillaume.montaine.guillaume


class Remises {

    private val remises: MutableList<Remise>

    constructor(remises: MutableList<Remise>) {
        remises.sorted()
        this.remises = remises.sorted().toMutableList()
    }

    public fun addRemise(remise: Remise) {
        if (remises.any { current -> remise.isOverlapping(current) }) {
            throw IllegalArgumentException("The remise $remise is overlapping with another")
        }
        remises.add(remise)
    }

    fun getRemiseFor(remise: Int) : Float {
        val correctRemise = remises.find { current -> current.amountInRange(remise) }
        if (correctRemise != null) {
            return correctRemise.pourcent
        }
        return 0f
    }
}