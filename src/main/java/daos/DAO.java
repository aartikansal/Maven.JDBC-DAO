package daos;

import java.sql.Connection;
import java.util.List;

public abstract class DAO<T> {
    protected final Connection connection;

    public abstract T findByID(int id);

    public abstract List findAll();

    public abstract T update(T dto);

    public abstract T create(T dto);

    public abstract void delete(int id);

    public DAO(Connection connection) {
        this.connection = connection;
    }
}
