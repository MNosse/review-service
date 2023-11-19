package br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.gateway

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.gateway.ReviewGateway
import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review
import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.repository.review.ReviewRepository
import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.schema.review.ReviewSchema
import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.gateway.converter.convert
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class ReviewDatabaseGateway(private val reviewRepository: ReviewRepository) : ReviewGateway {
    override fun create(imdb: String, rating: Double): Review {
        return convert(
            reviewRepository.save(
                ReviewSchema(
                    imdb = imdb,
                    rating = rating
                )
            )
        )
    }

    override fun getByImdb(imdb: String): Review? {
        return reviewRepository.findByImdb(imdb)?.let { review ->
            convert(review)
        }
    }

}