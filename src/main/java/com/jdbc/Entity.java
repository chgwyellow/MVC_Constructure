package com.jdbc;

/**
 * ClassName: Entity
 * Package: com.jdbc
 * Description:
 * 對應資料表的類別
 * 需要有和資料表的欄位相同的屬性
 *
 * @Author chgwyellow
 * @Create 2023-6-3
 */
public class Entity {

    private Integer id;
    private String name;
    private Integer age;

    public int getId() {
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

    public int getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
