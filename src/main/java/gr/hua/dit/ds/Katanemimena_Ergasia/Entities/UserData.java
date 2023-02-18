package gr.hua.dit.ds.Katanemimena_Ergasia.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "UserData")
public class UserData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "user_type")
    private String user_type;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    @NotBlank
    private String last_name;

    @Column(name = "afm")
    @NotNull
    private int afm;

    @Column(name = "area_code")
    @NotNull
    private int area_code;

    public UserData() {

    }

    public UserData(String user_type, String first_name, String last_name, int afm, int area_code) {
        this.user_type = user_type;
        this.first_name = first_name;
        this.last_name = last_name;
        this.afm = afm;
        this.area_code = area_code;
    }

    public String getUser_type() {return user_type;}

    public void setUser_type(String user_type) {this.user_type = user_type;}

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getFirst_name() {return first_name;}

    public void setFirst_name(String first_name) {this.first_name = first_name;}

    public String getLast_name() {return last_name;}

    public void setLast_name(String last_name) {this.last_name = last_name;}

    public int getAfm() {return afm;}

    public void setAfm(int afm) {this.afm = afm;}

    public int getArea_code() {return area_code;}

    public void setArea_code(int area_code) {this.area_code = area_code;}

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", user_type='" + user_type + '\'' + ", first_name='" + first_name + '\'' + ", last_name='" + last_name + '\'' + ", afm=" + afm + ", area_code=" + area_code + '}';
    }
}
