package ru.job4j.tracker;

/**
 * @author Plaksin Arseniy (arsp93@mail.ru)
 * @version $Id$
 * @since 5.11.2018
 */
public class Item {
    /**
     * Id заявки.
     */
    private String id;
    /**
     * Название заявки.
     */
    private String name;
    /**
     * Описание заявки.
     */
    private String desc;
    /**
     * Время создания.
     */
    private long created;
    /**
     * Комментарии к заявке.
     */
    private String[] comments;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public long getCreated() {
        return created;
    }

    public void setCreated(long created) {
        this.created = created;
    }

    public String[] getComments() {
        return comments;
    }

    public void setComments(String[] comments) {
        this.comments = comments;
    }

    public Item() {

    }

    public Item(String name, String desc) {
        this.name = name;
        this.desc = desc;
    }

    public Item(String id, String name, long created) {
        this.id = id;
        this.name = name;
        this.created = created;
    }

    public Item(String id, String name, String desc, long created, String[] comments) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.created = created;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Id : " + this.id + " Имя : " + this.name + " Описание : " + this.desc;
    }
}
