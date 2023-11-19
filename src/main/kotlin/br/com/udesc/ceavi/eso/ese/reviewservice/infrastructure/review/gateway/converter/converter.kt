package br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.gateway.converter

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review
import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.schema.review.ReviewSchema

fun convert(review: ReviewSchema): Review {
    return Review(
        imdb = review.imdb,
        rating = review.rating
    )
}