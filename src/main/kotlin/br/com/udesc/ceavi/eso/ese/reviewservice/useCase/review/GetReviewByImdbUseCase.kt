package br.com.udesc.ceavi.eso.ese.reviewservice.useCase.review

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.gateway.ReviewGateway
import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review
import org.springframework.stereotype.Service

@Service
class GetReviewByImdbUseCase(
    private val reviewGateway: ReviewGateway
) {
    fun execute(input: Input): Output {
        return Output(
            reviewGateway.getByImdb(
                imdb = input.imdb
            )
        )
    }

    data class Input(
        val imdb: String
    )

    data class Output(
        val review: Review?
    )
}