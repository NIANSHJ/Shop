package model;


public class Type {

    private int id;      //分类id
    private String name; //分类名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type() {
        super();
    }

    public Type(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Type(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Type [id=" + id + ", name=" + name + "]";
    }

}
