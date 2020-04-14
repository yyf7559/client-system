package cn.entity;

public class Role {
    private Integer id;
    private String name;
    private Role(){
        super();
    }
    private Role(String name){
        super();
        this.name=name;
    }

    @Override
    public String toString() {
        return "Role[id="+id+", name="+name+"]";
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
