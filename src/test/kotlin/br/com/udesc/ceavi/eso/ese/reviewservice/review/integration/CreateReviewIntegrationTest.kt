package br.com.udesc.ceavi.eso.ese.reviewservice.review.integration

import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.controller.CreateReviewController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CreateReviewIntegrationTest @Autowired constructor(
    private val createReviewController: CreateReviewController
) {
    private val imdb = "tt1375670"
    private val rating = 6.0

    @Test
    fun test() {
        assertDoesNotThrow {
            createReviewController.createReview(
                CreateReviewController.Request(
                    imdb = imdb,
                    rating = rating
                )
            ).review.let { review ->
                assert(
                    review.imdb == imdb
                            && review.rating == rating
                )
            }
        }
    }
}