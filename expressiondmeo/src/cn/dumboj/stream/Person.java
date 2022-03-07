package cn.dumboj.stream;

import java.util.ArrayList;
import java.util.List;

public class Person {
    private String name; // 姓名
    private int salary; // 薪资
    private int age; // 年龄
    private String sex; //性别
    private String area; // 地区

    // 构造方法
    public Person(String name, int salary, int age,String sex,String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }

    /**
     * 无参构造
     * */
    public Person() {
    }

    public Person(String name, int salary, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.sex = sex;
        this.area = area;
    }

    /**
     * 只做Person在案例中使用初始化样例，本静态方法返回空list
     * */
    public static List<Person> getPerson(){
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 22,"male", "New York"));
        personList.add(new Person("Jack", 7000, 25,"male", "Washington"));
        personList.add(new Person("Lily", 7000, 24,"female", "Washington"));
        personList.add(new Person("Anni", 8200, 30,"female", "New York"));
        personList.add(new Person("Owen", 9500, 27,"male", "New York"));
        personList.add(new Person("Alisa", 7900, 28,"female", "New York"));
        return personList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
