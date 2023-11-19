package br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.controller

import br.com.udesc.ceavi.eso.ese.reviewservice.entity.review.model.Review
import br.com.udesc.ceavi.eso.ese.reviewservice.useCase.review.GetReviewByImdbUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/review-web-service/api/reviews")
class GetReviewByImdbController(private val getReviewByImdbUseCase: GetReviewByImdbUseCase) {

    val logger: Logger = LoggerFactory.getLogger(GetReviewByImdbController::class.java)

    @GetMapping("/{imdb}/")
    @ResponseStatus(HttpStatus.OK)
    fun getReviewByImdb(@RequestParam imdb: String): Response {
        val response = Response(
            getReviewByImdbUseCase.execute(
                input = GetReviewByImdbUseCase.Input(
                    imdb = imdb
                )
            ).review
        )
        if (response.review != null) {
            logger.info("Review Retrieved")
        } else {
            logger.info("Review Not Found")
        }
        return response
    }

    data class Response(
        val review: Review?
    )
}