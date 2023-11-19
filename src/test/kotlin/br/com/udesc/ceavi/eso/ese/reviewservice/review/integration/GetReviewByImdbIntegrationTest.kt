package br.com.udesc.ceavi.eso.ese.reviewservice.review.integration

import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.repository.review.ReviewRepository
import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.database.schema.review.ReviewSchema
import br.com.udesc.ceavi.eso.ese.reviewservice.infrastructure.review.controller.GetReviewByImdbController
import org.junit.jupiter.api.BeforeEach
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
class GetReviewByImdbIntegrationTest @Autowired constructor(
    private val reviewRepository: ReviewRepository,
    private val getReviewByImdbController: GetReviewByImdbController
) {
    private var imdb = "tt1375670"
    private val rating = 4.3

    @BeforeEach
    fun setup() {
        reviewRepository.save(
            ReviewSchema(
                imdb = imdb,
                rating = rating
            )
        )
    }

    @Test
    fun test() {
        assertDoesNotThrow {
            getReviewByImdbController.getReviewByImdb(imdb).review.let { review ->
                assert(
                    review!!.imdb == imdb
                            && review.rating == rating
                )
            }
        }
    }
}