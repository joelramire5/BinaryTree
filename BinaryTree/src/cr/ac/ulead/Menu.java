package cr.ac.ulead;

import cr.ac.ulead.logic.LogicaPersona;
import cr.ac.ulead.logic.Node;
import cr.ac.ulead.logic.ReadingFile;

import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Menu {
    Scanner input = new Scanner(System.in);
    PrintStream output = new PrintStream(System.out);
    LogicaPersona logicaPersona= new LogicaPersona();
    ReadingFile readingFile =new ReadingFile();


    public void menuopciones(){
        output.println("Person Binary Tree");
        output.println("Options");
        output.println("1. Insertar Person");
        output.println("2. Load Csv File");
        output.println("3. Preorder");
        output.println("4. In Order");
        output.println("5. Post Order");
        output.println("6. Exit");
    }


    public void principalmenu() throws FileNotFoundException {
        int Option;
        do{
            this.menuopciones();
            Option =input.nextInt();
            input.skip("[\r\n]");
            switch (Option){
                case 1:
                    insertdata(logicaPersona);
                    break;
                case 2:
                    readingFile.loadingPerson(logicaPersona);
                    break;
                case 3:
                    logicaPersona.preOrder(logicaPersona.root);
                    break;
                case 4:
                    logicaPersona.inorder(logicaPersona.root);
                    break;
                case 5:
                    logicaPersona.postorder(logicaPersona.root);
                    break;

                case 6:
                    output.println("El programa ha salido con exito");
                    System.exit(1);

            }
        }while(Option!=6);
    }

    public void insertdata(LogicaPersona logicaPersona){
        output.println("Insert the ID");
        String ID=input.nextLine();
        output.println("Insert the Name");
        String name=input.nextLine();
        output.println("Insert the LastName");
        String LastName = input.nextLine();
        output.println("Insert the Birthday Date with the format(AAAA-MM-DD");
        LocalDate date=LocalDate.parse(input.next("....-..-.."));
        logicaPersona.insert(ID,name,LastName,date);

    }
}