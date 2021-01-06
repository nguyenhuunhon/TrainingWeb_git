package Model;

public class ObjectPet {
    private String IDObjectPet;
    private String namePet;
    public ObjectPet(String IDObjectPet,String namePet){
        this.IDObjectPet=IDObjectPet;
        this.namePet=namePet;
    }

    public String getIDObjectPet() {
        return IDObjectPet;
    }

    public String getNamePet() {
        return namePet;
    }

    public void setIDObjectPet(String IDObjectPet) {
        this.IDObjectPet = IDObjectPet;
    }

    public void setNamePet(String namePet) {
        this.namePet = namePet;
    }

}
