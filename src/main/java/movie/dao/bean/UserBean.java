package movie.dao.bean;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserBean {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer stunb;
    private String password;
    private String nickname;
    private String sex;
    private Integer age;
    private String school;
    private String label1;
    private String label2;
    private String label3;

    public Integer getStunb() {
        return stunb;
    }

    public void setStunb(Integer stunb) {
        this.stunb = stunb;
    }

    public Integer getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getNickname() {
        return nickname;
    }

    public String getSex() {
        return sex;
    }

    public Integer getAge() {
        return age;
    }

    public String getLabel1() {
        return label1;
    }

    public String getLabel2() {
        return label2;
    }

    public String getLabel3() {
        return label3;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNickname(String name) {
        this.nickname = name;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setLabel1(String label1) {
        this.label1 = label1;
    }

    public void setLabel2(String label2) {
        this.label2 = label2;
    }

    public void setLabel3(String label3) {
        this.label3 = label3;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}
