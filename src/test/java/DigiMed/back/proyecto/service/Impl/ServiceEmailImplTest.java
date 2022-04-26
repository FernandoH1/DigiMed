package DigiMed.back.proyecto.service.Impl;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ServiceEmailImplTest {

    @Test
    public void send_email_message(){

        ServiceEmailImpl serviceSendEmail = new ServiceEmailImpl();
        Assert.assertEquals("Message succesfully sent",serviceSendEmail.sendEmailMessage("fqgomez@misena.edu.co", "Prueba","TestUnitario" ));
    }

}