
package co.com.strevens.sga.cliente;

import co.com.strevens.sga.domain.Persona;
import co.com.strevens.sga.servicio.PersonaServiceRemote;
import java.util.List;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;


public class ClientePersonaService {
    public static void main(String[] args) {
        System.out.println("Iniciando llamada al EJB desde el cliente\n");
        try {
            //(Java Naming and Directory Interface) jndi
            Context jndi = new InitialContext();
            PersonaServiceRemote personaService = (PersonaServiceRemote) jndi.lookup("java:global/sga-jee/PersonaServiceImpl!co.com.strevens.sga.servicio.PersonaServiceRemote");
        
            //Ya se dispone del objeto del lado del cliente
            List<Persona> personas = personaService.listarPersona();
            for(Persona persona: personas){
                System.out.println(persona);
            }
            
        } catch (NamingException ex) {
            ex.printStackTrace(System.out);
        }
    }
}
