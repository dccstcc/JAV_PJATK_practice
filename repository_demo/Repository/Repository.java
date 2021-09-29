package Repository;

import java.util.List;

public interface Repository<TEntity> {
    TEntity getById(int id);
    List<TEntity> allOnPage(PagingInfo page);
    void add(TEntity entity);
    void delete(TEntity entity);
    void modify(TEntity entity);
    int count();
}
