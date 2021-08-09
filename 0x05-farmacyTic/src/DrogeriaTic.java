import java.util.Scanner;

public class DrogeriaTic {

    public void procesarEntrada()
    {

    }

    public static void main(String[] args) throws Exception
    {
        Scanner sc = new Scanner(System.in);
        int op = 0;

        do {
            
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
