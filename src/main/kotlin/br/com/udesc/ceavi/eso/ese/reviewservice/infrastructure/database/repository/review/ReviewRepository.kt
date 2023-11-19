package br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.repository.review

import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.schema.review.ReviewSchema
import org.springframework.data.jpa.repository.JpaRepository

interface ReviewRepository : JpaRepository<ReviewSchema, String> {
    fun findByImdb(imdb: String): ReviewSchema?
}