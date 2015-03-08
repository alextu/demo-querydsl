package io.alextu.demoquerydsl.support
import com.mysema.query.Tuple
import com.mysema.query.sql.SQLQuery
import com.mysema.query.types.ConstructorExpression
import com.mysema.query.types.QTuple
import io.alextu.demoquerydsl.support.q.QBlog
import io.alextu.demoquerydsl.support.q.QBlogTag
import io.alextu.demoquerydsl.support.q.QTag
import io.alextu.demoquerydsl.blog.Blog
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jdbc.query.QueryDslJdbcTemplate
import org.springframework.stereotype.Repository
/**
 * Created by alexis on 06/03/15.
 */
@Repository
class BlogRepository {

    @Autowired
    QueryDslJdbcTemplate queryDslJdbcTemplate

    QBlog BLOG = QBlog.blog
    QBlogTag BLOG_TAG = QBlogTag.blogTag
    QTag TAG = QTag.tag

    Blog fetchBlog(int id) {
        SQLQuery sql = queryDslJdbcTemplate.newSqlQuery().from(BLOG).where(BLOG.id.eq(id))
        queryDslJdbcTemplate.queryForObject(sql, ConstructorExpression.create(Blog, BLOG.id, BLOG.title))
    }

    List<Blog> fetchAllBlogs() {
        SQLQuery sql = queryDslJdbcTemplate.newSqlQuery().from(BLOG)
        queryDslJdbcTemplate.query(sql, ConstructorExpression.create(Blog, BLOG.id, BLOG.title))
    }

    List<Blog> fetchAllBlogsWithTags() {
        SQLQuery sql = queryDslJdbcTemplate.newSqlQuery()
                            .from(BLOG)
                            .leftJoin(BLOG_TAG).on(BLOG.id.eq(BLOG_TAG.idBlog))
                            .leftJoin(TAG).on(BLOG_TAG.idTag.eq(TAG.id))
        List<Tuple> tuples = queryDslJdbcTemplate.query(sql, new QTuple(BLOG.id, BLOG.title, TAG.name))
        tuples.groupBy blogId() collect blogWithTags()
    }

    private Closure blogId() {
        return { Tuple t -> t.get(BLOG.id) }
    }

    private Closure blogWithTags() {
        return { int id, List<Tuple> ts ->
                def title = ts[0].get(BLOG.title)
                def tags = ts*.get(TAG.name)
                new Blog(id, title, tags)
        }
    }

}
