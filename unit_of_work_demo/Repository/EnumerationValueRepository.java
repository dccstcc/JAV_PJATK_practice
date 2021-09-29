package Repository;

import Entity.EnumerationValue;

public interface EnumerationValueRepository extends Repository {
    EnumerationValue withName(String name);
    EnumerationValue withKey(int key, String name);
    EnumerationValue withStringKey(String key, String name);
}
