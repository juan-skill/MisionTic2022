import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class DrogeriaTic {

    public static ArrayList<String> procesarEntrada(String input)
    {
        ArrayList<String> parse = new ArrayList<String>();
        String word = "";

        //1&Medicamento&nombre&codigo&precio&marca&concentracion
        //1&Alimentos&nombre&codigo&precio&marca&presentacion
        for (int i = 0; i < input.length(); i++)
        {
            if (input.charAt(i) != '&')
                word += input.charAt(i);

            if (input.charAt(i) == '&' || i == input.length() - 1)
            {
                System.out.println("simbol &");
                parse.add(word);
                word = "";
            }
            
        }

        Iterator<String> it = parse.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }

        return null;
    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            procesarEntrada("1&Alimentos&nombre&codigo&precio&marca&presentacion");
            op = Integer.parseInt(sc.nextLine());
            switch (op)
            {
                case 1: //
                        //String input = sc.nextLine();
                        System.out.println("case 1");

                        break;
                case 2:
                        System.out.println("case 2");
                        break;                
            }

        } while (op != 3);

        sc.close();
    }
}
