import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DrogeriaTic {

    /**
     * procesarEntrada - parse input String to save into arraylist
     * @param input
     * @return
     */
    public static ArrayList<String> procesarEntrada(String input)
    {
        ArrayList<String> parse = new ArrayList<String>();
        String word = "";

        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) != '&')
                word += input.charAt(i);

            if (input.charAt(i) == '&' || i == input.length() - 1)
            {
                parse.add(word);
                word = "";
            }            
        }

        return parse;
    }

    /**
     * Main - Prepares the control flow according the input
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> parse = null;
        Producto product = null;
        Iterator<Producto> it = null;
        ArrayList<Producto> listProducts = new ArrayList<Producto>();
        int op = 0;

        do {
            parse = procesarEntrada(sc.nextLine());
            op = Integer.parseInt(parse.get(0));
            switch (op)
            {
                case 1: // add a new product                   
                        if (parse.get(1).equals("Medicamento"))
                        {
                            product = new Medicamento(parse.get(6), parse.get(2), Long.parseLong(parse.get(3)), Float.parseFloat(parse.get(4)), parse.get(5));
                        }
                        else if (parse.get(1).equals("Alimentos"))
                        {
                            product = new Alimentos(parse.get(6), parse.get(2), Long.parseLong(parse.get(3)), Float.parseFloat(parse.get(4)), parse.get(5));
                        }
                        listProducts.add(product);
                        break;

                case 2: // show all of the products

                        it = listProducts.iterator();
                        System.out.println("***DrogueriaTic***");
                        while(it.hasNext()) {
                            System.out.println(it.next());
                        }
                        break;                
            }
        } while (op != 3);

        sc.close();
    }
}
