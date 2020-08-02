package cr.ac.ulead.logic;


import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFile {

    public boolean datoscargados=false;

    public void loadingPerson(LogicaPersona logicapersona) throws FileNotFoundException {
        String peoplefile="C:\\Users\\taera\\IdeaProjects\\BinaryTree\\src\\cr\\ac\\ulead\\CsvFile\\Personas.csv";
        Scanner lector = new Scanner (new File(peoplefile));
        int contador=0;
        String currentline=" ";
        while (lector.hasNextLine()){
            currentline=lector.nextLine();

            if(contador!=0) {
                String[] persondata = currentline.split(",");
                System.out.println(Arrays.toString(persondata));
                logicapersona.insert(persondata[0],persondata[1],persondata[2],LocalDate.parse(persondata[3]));
            }
            contador++;
        }
        lector.close();
        datoscargados=true;
        System.out.println("Se han cargado " +contador + " datos");
    }


}
