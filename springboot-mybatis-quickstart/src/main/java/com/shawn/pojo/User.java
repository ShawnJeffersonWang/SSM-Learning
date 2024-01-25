package com.shawn.pojo;

/* 实体类臃肿，虽然只有5个属性，但是需要为每个属性提供getter,setter,有参无参构造,toString,hashCode,equals
 lombok就是来解决这个问题的
 Lombok是一个实用的Java类库，能通过注解的形式自动生成构造器，getter/setter,equals,hashCode,toString等方法，
 并可以自动化生成日志变量，简化Java开发，提高效率

 lombok会在编译时，自动生成对应的Java代码，我们使用lombok时，还需要安装一个lombok插件(idea自带)
 */


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Getter
//@Setter
//@ToString
//@EqualsAndHashCode

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    // 属性与字段一一对应，实体类定义时推荐使用包装类型
    private Integer id;
    private String name;
    private Short age;
    private Short gender;
    private String phone;

/*
    public Integer getId() {
        return id;
    }

    public User() {
    }

    public User(Integer id, String name, Short age, Short gender, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                '}';
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

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public Short getGender() {
        return gender;
    }

    public void setGender(Short gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }*/
}
