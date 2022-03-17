package com.example.custometvalidate.model;
import javax.persistence.*;

@Entity
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
//    @Column(columnDefinition = "Decimal(10,2) default '100.00'")
    private Double numberPhone;

    public Phone(Integer id, String name, Double numberPhone) {
        this.id = id;
        this.name = name;
        this.numberPhone = numberPhone;
    }

    public Phone() {
    }

    public Phone( String numberPhone) {

        this.numberPhone = Double.valueOf(numberPhone);
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

    public Double getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(Double numberPhone) {
        this.numberPhone = numberPhone;
    }
}
