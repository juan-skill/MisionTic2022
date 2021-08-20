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

    @Test
    public void testObtenerPosicionesProductosFaltantes()
    {
        ArrayList<Integer> lPos = new ArrayList<>();
        // lPos = [0, 1, 4, 5, 6]
        lPos.add(0);
        lPos.add(1);
        lPos.add(4);
        lPos.add(5);
        lPos.add(6);

        //tipos = [‘HELADO MARACUMANGO’, 'CHOCOCONO', 'PALETA DE AGUA', 'HELADO DE MANI', 'PALETA DE MANGO BICHE', ‘HELADO MARACUMANGO’, 'CHOCOCONO']
        ArrayList<String> ltipos = new ArrayList<>();
        ltipos.add("HELADO MARACUMANGO"); 
        ltipos.add("CHOCOCONO"); 
        ltipos.add("PALETA DE AGUA"); 
        ltipos.add("HELADO DE MANI"); 
        ltipos.add("PALETA DE MANGO BICHE");
        ltipos.add("HELADO MARACUMANGO");
        ltipos.add("CHOCOCONO");
        

        //cat = ‘HELADO MARACUMANGO’
        String cat = "HELADO MARACUMANGO";

        ArrayList<Integer> expResult = new ArrayList<>();
        expResult.add(0);
        expResult.add(5);

        ArrayList<Integer> result = instance.obtenerPosicionesProductosFaltantes(lPos, ltipos, cat);

        assertEquals(expResult, result);
    }

}