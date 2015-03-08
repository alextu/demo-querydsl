package io.alextizzle.demoquerydsl.support.q;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBlogTag is a Querydsl query type for QBlogTag
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QBlogTag extends com.mysema.query.sql.RelationalPathBase<QBlogTag> {

    private static final long serialVersionUID = -2061936033;

    public static final QBlogTag blogTag = new QBlogTag("BLOG_TAG");

    public final NumberPath<Integer> idBlog = createNumber("idBlog", Integer.class);

    public final NumberPath<Integer> idTag = createNumber("idTag", Integer.class);

    public QBlogTag(String variable) {
        super(QBlogTag.class, forVariable(variable), "PUBLIC", "BLOG_TAG");
        addMetadata();
    }

    public QBlogTag(String variable, String schema, String table) {
        super(QBlogTag.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBlogTag(Path<? extends QBlogTag> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "BLOG_TAG");
        addMetadata();
    }

    public QBlogTag(PathMetadata<?> metadata) {
        super(QBlogTag.class, metadata, "PUBLIC", "BLOG_TAG");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(idBlog, ColumnMetadata.named("ID_BLOG").withIndex(2).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(idTag, ColumnMetadata.named("ID_TAG").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
    }

}

