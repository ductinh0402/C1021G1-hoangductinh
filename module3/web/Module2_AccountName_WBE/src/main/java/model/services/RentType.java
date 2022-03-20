package model.services;

public class RentType {
    private int idRentType;
    private String nameRentType;
    private double costRentType;

    public RentType() {
    }

    public RentType(int idRentType, String nameRentType, double costRentType) {
        this.idRentType = idRentType;
        this.nameRentType = nameRentType;
        this.costRentType = costRentType;
    }

    public int getIdRentType() {
        return idRentType;
    }

    public void setIdRentType(int idRentType) {
        this.idRentType = idRentType;
    }

    public String getNameRentType() {
        return nameRentType;
    }

    public void setNameRentType(String nameRentType) {
        this.nameRentType = nameRentType;
    }

    public double getCostRentType() {
        return costRentType;
    }

    public void setCostRentType(double costRentType) {
        this.costRentType = costRentType;
    }
}
