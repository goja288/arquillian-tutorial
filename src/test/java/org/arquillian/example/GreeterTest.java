package org.arquillian.example;

/**
 * Created by goja288 on 6/13/2016.
 */
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import javax.inject.Inject;


@RunWith(Arquillian.class) // para decirle que JUnit utilice Arquillian
public class GreeterTest {

    @Deployment // método estático anotado con @Deployment que retorna un archivo ShrinkWrap. O sea el archivo de prueba#1
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(Greeter.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    Greeter greeter;

    @Test // al menos un método debe tener la notacion @Test
    public void should_create_greeting() {
        Assert.assertEquals("Hello, Earthling!",
                greeter.createGreeting("Earthling"));
        greeter.greet(System.out, "Earthling");
    }


    /**
     * #1
     * Qué es un archivo de pruebas?
     * El propósito de un archivo de pruebas es aislar las clases y recursos que son necesarios por la prueba del resto
     * del classpath. A diferencia de una prueba unitaria normal, Arquillian no simplemente se sumerge dentro del
     * classpath. En lugar de eso, incluye solamente lo que la prueba necesita (que puede ser todo el classpath,
     * si así lo decides). El archivo se define utilizando ShrinkWrap, que es un API en Java para la creación de
     * archivos (e.g., jar, war, ear). La estrategia de micro-despliegues te permite enfocarte exactamente en las
     * clases que quieres probar y, como resultado, la prueba permanece muy pequeña.
     *
     * Más info: http://arquillian.org/guides/shrinkwrap_introduction/
     *
     */

    /**
     * #2
     * Arquillian selecciona el contenedor basándose en el adaptador para contenedor que está disponible en el classpath.
     * Una prueba con Arquillian debe ser ejecutada en cualquier contenedor que es compatible con el modelo de
     * programación utilizado en la prueba (siempre y cuando exista un adaptador de Arquillian para dicho contenedor).
     * Nuestra prueba utiliza CDI como modelo de programación, por tanto necesitamos utilizar un contenedor que soporte
     * CDI. Queremos una solución rápida para el desarrollo, por tanto vamos a arrancar el contenedor Weld EE embebido.
     */

    /**
     * Para resumir, aquí están las tres librerías que necesitas para utilizar Arquillian (con JUnit):
     *  - Integración Arquillian JUnit
     *  - Adaptador Arquillian para el contenedor
     *  - Ambiente de ejecución del contenedor (contenedor embebido) o cliente del contenedor (contenedor remoto)
     */
}
