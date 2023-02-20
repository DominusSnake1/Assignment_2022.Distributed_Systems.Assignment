package gr.hua.dit.ds.Katanemimena_Ergasia.Entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "interested")
public class Interested {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "owner_afm")
    private int owner_afm;

    @Column(name = "interested_afm")
    private int interested_afm;

    @Column(name = "registration")
    @NotNull
    private int registration;

    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public int getOwner_afm() {return owner_afm;}

    public void setOwner_afm(int owner_afm) {this.owner_afm = owner_afm;}

    public int getInterested_afm() {return interested_afm;}

    public void setInterested_afm(int intersted_afm) {this.interested_afm = intersted_afm;}

    public int getRegistration() {return registration;}

    public void setRegistration(int KTEO_id) {this.registration = KTEO_id;}

    @Override
    public String toString() {
        return "Interested{" + "id=" + id + ", owner_afm=" + owner_afm + ", interested_afm=" + interested_afm + ", registration=" + registration + '}';
    }
}
