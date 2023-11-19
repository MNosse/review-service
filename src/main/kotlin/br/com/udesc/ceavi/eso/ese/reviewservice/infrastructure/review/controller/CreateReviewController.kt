package br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.controller

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review
import br.com.udesc.ceavi.eso.ese.reviewservice.useCase.review.CreateReviewUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/review-web-service/api/reviews")
class CreateReviewController(private val createReviewUseCase: CreateReviewUseCase) {

    val logger: Logger = LoggerFactory.getLogger(CreateReviewController::class.java)

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun createReview(@RequestBody request: Request): Response {
        val response = Response(
            createReviewUseCase.execute(
                CreateReviewUseCase.Input(
                    imdb = request.imdb,
                    rating = request.rating
                )
            ).review
        )
        logger.info("Review Created")
        return response
    }

    data class Request(
        val imdb: String,
        val rating: Double
    )

    data class Response(
        val review: Review
    )
}