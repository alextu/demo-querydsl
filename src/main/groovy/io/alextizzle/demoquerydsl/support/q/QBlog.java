package io.alextizzle.demoquerydsl.support.q;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QBlog is a Querydsl query type for QBlog
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QBlog extends com.mysema.query.sql.RelationalPathBase<QBlog> {

    private static final long serialVersionUID = -1460510917;

    public static final QBlog blog = new QBlog("BLOG");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath title = createString("title");

    public QBlog(String variable) {
        super(QBlog.class, forVariable(variable), "PUBLIC", "BLOG");
        addMetadata();
    }

    public QBlog(String variable, String schema, String table) {
        super(QBlog.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QBlog(Path<? extends QBlog> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "BLOG");
        addMetadata();
    }

    public QBlog(PathMetadata<?> metadata) {
        super(QBlog.class, metadata, "PUBLIC", "BLOG");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(title, ColumnMetadata.named("TITLE").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647).notNull());
    }

}

