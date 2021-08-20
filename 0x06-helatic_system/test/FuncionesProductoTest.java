import static org.junit.Assert.assertEquals;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.After;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

public class FuncionesProductoTest
{
    private FuncionesProducto instance;

    public FuncionesProductoTest()
    {}

    @BeforeClass
    public static void setUpClass()
    {}

    @AfterClass
    public static void tearDownClass()
    {}

    @Before
    public void setUp()
    {
        instance = new FuncionesProducto();
    }

    @After
    public void tearDown()
    {}

    @Test
    public void testObtenerProductos()
    {
        System.out.println("obtenerProductos");
        ArrayList<String> list = new ArrayList<String>();

        list.add("CHOCOCONO");
        list.add("HELADO DE MANÍ");
        list.add("PALETA DE AGUA");
        list.add("HELADO DE MANI");
        list.add("PALETA DE MANGO BICHE");
        list.add("CHOCOCONO");

        String a[] = new String[] {"CHOCOCONO", "HELADO DE MANI", "PALETA DE AGUA", "PALETA DE MANGO BICHE"};

        List<String> expResult = Arrays.asList(a);
        ArrayList<String> result = instance.obtenerProductos(list);

        assertEquals(expResult, result);
        //fail("The test case is a prototype");
    }

}