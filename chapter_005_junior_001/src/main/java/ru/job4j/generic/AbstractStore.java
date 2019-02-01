package ru.job4j.generic;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 31.01.2019
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {

    private SimpleArray<T> values;

    public AbstractStore(SimpleArray<T> values) {
        this.values = values;
    }

    public SimpleArray<T> getValues() {
        return values;
    }

    @Override
    public void add(Base model) {
        this.values.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        this.values.set(index, (T) model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        int index = getIndex(id);
        if (index == -1) {
            return false;
        }
        this.values.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        for (int i = 0; i < this.values.getObjects().length; i++) {
            Base val = (Base) values.get(i);
            if (val.getId().equals(id)) {
                return (T) val;
            }
        }
        return null;
    }

    private int getIndex(String id) {
        int index = -1;
        for (int i = 0; i < this.values.getObjects().length; i++) {
            Base val = (Base) values.get(i);
            if (val.getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}
