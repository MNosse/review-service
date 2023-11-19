package br.com.udesc.ceavi.eso.ese.reviewservice.useCase.review

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.gateway.ReviewGateway
import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review
import org.springframework.stereotype.Service

@Service
class CreateReviewUseCase(
    private val reviewGateway: ReviewGateway
) {
    fun execute(input: Input): Output {
        return Output(
            reviewGateway.create(
                imdb = input.imdb,
                rating = input.rating
            )
        )
    }

    data class Input(
        val imdb: String,
        val rating: Double
    )

    data class Output(
        val review: Review
    )
}