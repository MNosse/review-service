package br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.gateway

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review

interface ReviewGateway {
    fun create(imdb: String, rating: Double): Review
    fun getByImdb(imdb: String): Review?
}