//Cristopher Soto Ventura 4B - DSM
package client;

import org.apache.xmlrpc.XmlRpcException;
import org.apache.xmlrpc.client.XmlRpcClient;
import org.apache.xmlrpc.client.XmlRpcClientConfigImpl;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;
import java.util.List;

public class clientRPC {
    public static Scanner teclado = new Scanner(System.in);
    public static void main(String[] args) throws MalformedURLException, XmlRpcException {
        XmlRpcClientConfigImpl config = new XmlRpcClientConfigImpl();
        config.setServerURL(new URL("http://localhost:1200"));
        XmlRpcClient client = new XmlRpcClient();
        client.setConfig(config);

        String option, curp, name, lastname1, lastname2, day, mounth, year, fechaNac, response;
        do {
            System.out.println("=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=");
            System.out.println("1. Create");
            System.out.println("2. Read one");
            System.out.println("3. Read all");
            System.out.println("4. Delete");
            System.out.println("5. Exit");
            System.out.print("Ingresa la opción a elegir: ");
            option = teclado.next();

            if (isNumber(option)){

                switch (Integer.parseInt(option)) {
                    case 1:
                        System.out.print("Ingresa el CURP de la persona ");
                        curp = teclado.next();
                        System.out.print("Ingresa el nombre de la persona ");
                        name = teclado.next();
                        System.out.print("Ingresa el primer apellido de la persona ");
                        lastname1 = teclado.next();
                        System.out.print("Ingresa el segundo apellido de la persona ");
                        lastname2 = teclado.next();
                        System.out.print("Ingresa el dia en dos digitos de nacimiento ");
                        day = teclado.next();
                        System.out.print("Ingresa el mes en dos digitos de nacimiento ");
                        mounth = teclado.next();
                        System.out.print("Ingresa el año de nacimiento ");
                        year = teclado.next();
                        fechaNac = year + "-" + mounth + "-" + day;

                        Object[] person = {curp, name, lastname1, lastname2, day, mounth, year, fechaNac};
                        response = (String)
                                client.execute("Methods.createPerson", person);
                        System.out.println(response);
                        break;
                    case 2:
                        System.out.print("Ingresa el curp de la persona por consultar ");
                        curp = teclado.next();
                        Object[] curpConsulta = {curp};
                        response = (String)
                                client.execute("Methods.consultarPersona", curpConsulta);
                        System.out.println(response);
                        break;
                    case 3:
                        Object[] nothing = {};
                        response = (String)
                                client.execute("Methods.consultarPersonas", nothing);
                        System.out.println(response);
                        break;
                    case 4:
                        System.out.print("¡ADVERTENCIA! Esta opción elimina permanentemente el registro de la base de datos");
                        System.out.print("Ingresa el curp de la persona por eliminar ");
                        curp = teclado.next();
                        Object[] curpDelete = {curp};
                        response = (String)
                                client.execute("Methods.eliminarPersona", curpDelete);
                        System.out.println(response);
                        break;
                    default:
                        System.out.println("Ingresa un opción válido");
                        break;
                }
            } else{
                System.out.println("Ingresa un opción válido");
            }

        } while (!option.equals("5"));

    }
    public static boolean isNumber(String optionString){
        try {
            int num = Integer.parseInt(optionString);
            return true;

        } catch (NumberFormatException e){
            return false;
        }
    }
}
