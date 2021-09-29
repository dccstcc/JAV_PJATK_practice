package Repository;

import Entity.Entity;
import Entity.EntityState;
import Entity.EnumerationValue;
import UoW.UoWRepository;

import java.util.ArrayList;
import java.util.List;

public class HsqlEnumerationValuesRepository implements EnumerationValueRepository, UoWRepository{
    private DatabaseContext databaseContext = new DatabaseContext();

    @Override
    public EnumerationValue withName(String name) {
        EnumerationValue value = null;
        for(EnumerationValue v : this.databaseContext.EnumerationValues)
            if(v.getEnumerationName() == name)
                value = v;
        return value;
    }

    @Override
    public EnumerationValue withKey(int key, String name) {
        EnumerationValue value = null;
        for(EnumerationValue v : this.databaseContext.EnumerationValues)
            if(v.getEnumerationName() == name && v.getIntKey() == key)
                value = v;
        return value;
    }

    @Override
    public EnumerationValue withStringKey(String key, String name) {
        EnumerationValue value = null;
        for(EnumerationValue v : this.databaseContext.EnumerationValues)
            if(v.getEnumerationName() == name && v.getStringKey() == key)
                value = v;
        return value;
    }

    @Override
    public Object getById(int id) {
        EnumerationValue value = null;
        for(EnumerationValue v : this.databaseContext.EnumerationValues)
            if(v.getId() == id)
                value = v;
        return value;
    }

    @Override
    public void add(Object o) {
        this.databaseContext.EnumerationValues.add((EnumerationValue)o);
    }

    @Override
    public void delete(Object o) {
        this.databaseContext.EnumerationValues.remove((EnumerationValue) o);
    }

    @Override
    public void modify(Object o) {
        EnumerationValue value = null;
        for(EnumerationValue v : this.databaseContext.EnumerationValues)
            if(((EnumerationValue)o).getId() == value.getId())
                value = v;
        value.setEntityState(EntityState.Modified);
    }

    @Override
    public int count() {
        return this.databaseContext.EnumerationValues.size();
    }

    @Override
    public List allOnPage(PagingInfo page) {
        List<EnumerationValue> values = new ArrayList<>();

        for(EnumerationValue v : this.databaseContext.EnumerationValues)
            if(values.size() < page.getPageSize())
                values.add(v);

        return values;
    }

    @Override
    public void persistAdd(Entity entity) {
        this.databaseContext.EnumerationValues.add((EnumerationValue)entity);
    }

    @Override
    public void persistUpdate(Entity entity) {
        this.modify(entity);
    }

    @Override
    public void persistRemove(Entity entity) {
        this.delete(entity);
    }
}
