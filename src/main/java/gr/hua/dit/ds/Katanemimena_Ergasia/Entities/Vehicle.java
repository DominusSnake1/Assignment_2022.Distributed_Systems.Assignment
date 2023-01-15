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
@Table(name = "Vehicles")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "owner_id")
    @NotNull
    private int owner_id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "KTEO_id")
    @NotNull
    private int KTEO_id;

    @Column(name = "registration")
    @NotNull
    private String registration;

    public Vehicle() {

    }

    public Vehicle(int owner_id, String brand, String model, int KTEO_id, String registration) {
        this.owner_id = owner_id;
        this.brand = brand;
        this.model = model;
        this.KTEO_id = KTEO_id;
        this.registration = registration;
    }

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getBrand() {return brand;}

    public void setBrand(String brand) {this.brand = brand;}

    public String getModel() {return model;}

    public void setModel(String model) {this.model = model;}

    public int getKTEO_id() {return KTEO_id;}

    public void setKTEO_id(int KTEO_id) {this.KTEO_id = KTEO_id;}

    public String getRegistration() {return registration;}

    public void setRegistration(String registration) {this.registration = registration;}

    public int getOwner_id() {return owner_id;}

    public void setOwner_id(int owner_id) {this.owner_id = owner_id;}

    @Override
    public String toString() {
        return "Vehicle{" + "id=" + id + ", owner_id=" + owner_id + ", brand='" + brand + '\'' + ", model='" + model + '\'' + ", KTEO_id=" + KTEO_id + ", registration='" + registration + '\'' + '}';
    }
}
