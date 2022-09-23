//Cristopher Soto Ventura 4B - DSM
package model;

public class BeanPerson {
    private String curp;
    private String rfc;
    private String name;
    private String first_lastname;
    private String second_lastname;
    private String fecha_nac;

    public BeanPerson() {
    }

    public BeanPerson(String curp, String rfc, String name, String first_lastname, String second_lastname, String fecha_nac) {
        this.curp = curp;
        this.rfc = rfc;
        this.name = name;
        this.first_lastname = first_lastname;
        this.second_lastname = second_lastname;
        this.fecha_nac = fecha_nac;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFirst_lastname() {
        return first_lastname;
    }

    public void setFirst_lastname(String first_lastname) {
        this.first_lastname = first_lastname;
    }

    public String getSecond_lastname() {
        return second_lastname;
    }

    public void setSecond_lastname(String second_lastname) {
        this.second_lastname = second_lastname;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    @Override
    public String toString() {
        return "BeanPerson{" +
                "curp='" + curp + '\'' +
                ", rfc='" + rfc + '\'' +
                ", name='" + name + '\'' +
                ", first_lastname='" + first_lastname + '\'' +
                ", second_lastname='" + second_lastname + '\'' +
                ", fecha_nac='" + fecha_nac + '\'' +
                '}';
    }
}