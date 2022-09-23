//Cristopher Soto Ventura 4B - DSM
package server;

import model.BeanPerson;
import model.DaoPerson;

import java.util.List;
public class Methods {
    public String createPerson(String curp, String name, String lastname1, String lastname2, String day, String mounth, String year, String fechaNac){
        String  rfc, abc = "QWERTYUIOPASDFGHJKLZXCVBNM";
        String  nameUpper = name.toUpperCase(),
                lastnameUpper = lastname1.toUpperCase(),
                lastname2Upper = lastname2.toUpperCase();
        int     randString = (int)(Math.random()*26+1),
                randString2 = (int)(Math.random()*26+1),
                random = (int)(Math.random()*9+1);
        //añomesdia
        rfc = lastnameUpper.charAt(0)+ "" +lastnameUpper.charAt(1)+""+lastname2Upper.charAt(0)+""+nameUpper.charAt(0)+""+year.charAt(2)+""+year.charAt(3)+""+mounth+""+day+""+abc.charAt(randString)+""+abc.charAt(randString2)+""+random;

        BeanPerson person = new BeanPerson();
        DaoPerson daoPerson = new DaoPerson();

        person.setCurp(curp.toUpperCase());
        person.setRfc(rfc.toUpperCase());
        person.setName(name);
        person.setFirst_lastname(lastname1);
        person.setSecond_lastname(lastname2);
        person.setFecha_nac(fechaNac);

        daoPerson.registrarPerson(person);
        return rfc;
    }

    public String consultarPersona(String curp){
        BeanPerson person = new BeanPerson();
        DaoPerson daoPerson = new DaoPerson();

        person.setCurp(curp);

        daoPerson.consultarPersona(person);

        return person.toString();
    }

    public String eliminarPersona(String curp){
        BeanPerson person = new BeanPerson();
        DaoPerson daoPerson = new DaoPerson();

        person.setCurp(curp);

        daoPerson.eliminarPersona(person);

        return "Persona eliminada correctamente";
    }

    public String consultarPersonas(){
        DaoPerson daoPerson = new DaoPerson();
        List<BeanPerson> persons = daoPerson.persons();
        String personsString = String.valueOf(persons);

        return personsString;
    }
}