package io.alextu.demoquerydsl.support.q;

import static com.mysema.query.types.PathMetadataFactory.*;

import com.mysema.query.types.path.*;

import com.mysema.query.types.PathMetadata;
import javax.annotation.Generated;
import com.mysema.query.types.Path;

import com.mysema.query.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QTag is a Querydsl query type for QTag
 */
@Generated("com.mysema.query.sql.codegen.MetaDataSerializer")
public class QTag extends com.mysema.query.sql.RelationalPathBase<QTag> {

    private static final long serialVersionUID = -1432569631;

    public static final QTag tag = new QTag("TAG");

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final StringPath name = createString("name");

    public QTag(String variable) {
        super(QTag.class, forVariable(variable), "PUBLIC", "TAG");
        addMetadata();
    }

    public QTag(String variable, String schema, String table) {
        super(QTag.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QTag(Path<? extends QTag> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "TAG");
        addMetadata();
    }

    public QTag(PathMetadata<?> metadata) {
        super(QTag.class, metadata, "PUBLIC", "TAG");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.INTEGER).withSize(10).notNull());
        addMetadata(name, ColumnMetadata.named("NAME").withIndex(2).ofType(Types.VARCHAR).withSize(2147483647).notNull());
    }

}

