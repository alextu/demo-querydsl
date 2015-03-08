package io.alextizzle.demoquerydsl

import io.alextizzle.demoquerydsl.support.BlogRepository
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.SpringApplicationConfiguration
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner
import org.springframework.transaction.annotation.Transactional

@RunWith(SpringJUnit4ClassRunner)
@SpringApplicationConfiguration(classes = DemoQuerydslApplication)
@Transactional
@Sql("/test-blogs.sql")
class DemoQuerydslApplicationTests {

	@Autowired
	BlogRepository blogRepository

	@Test
	void testFetchAllBlogs() {
		def blogs = blogRepository.fetchAllBlogs()
		assert blogs.size() == 2
		assert blogs[0].title == 'Titre 1'
		assert blogs[1].title == 'Titre 2'
	}

	@Test
	void testFetchAllBlogsWithTags() {
		def blogsAndTags = blogRepository.fetchAllBlogsWithTags()
		assert blogsAndTags.size() == 2

		def blog1 = blogsAndTags[0]
		assert blog1.title == 'Titre 1'
		assert blog1.tags == ['groovy', 'opinion', 'web']

		def blog2 = blogsAndTags[1]
		assert blog2.title == 'Titre 2'
		assert blog2.tags == ['javascript', 'web']

	}
}
