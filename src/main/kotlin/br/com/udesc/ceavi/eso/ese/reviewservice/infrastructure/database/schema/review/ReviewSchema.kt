package br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.schema.review

import jakarta.persistence.*

@Entity
@Table(name = "review")
data class ReviewSchema(
    @Id
    val imdb: String,
    val rating: Double
) {
    constructor() : this("", 0.0)
}
