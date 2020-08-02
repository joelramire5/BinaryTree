package cr.ac.ulead.logic;

import java.time.LocalDate;

public class LogicaPersona {

public Node root;

    public LogicaPersona() {
        root = null;
    }

    public int intConverter(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            System.out.println("Ha ocurrido un error al insertar a el usuario %s");
            return -1;
        }
    }
public void insert(String id, String name, String lastname, LocalDate birthday) {
    Node newnode = new Node();
    Person person = new Person(id, name, lastname, birthday);
    newnode.person = person;

    if (root == null) {
        this.root = newnode;
    } else {
        Node Current = root;
        Node Parent;
        while (true) {
            Parent = Current;
            if (birthday.isEqual(Current.person.getBirthday())) {
                if (intConverter(id) > intConverter(Current.person.getId())) {
                    Current = Current.Rightchild;
                    if (Current == null) {
                        Parent.Rightchild = newnode;
                        return;
                    }
                } else {
                    Current = Current.Leftchild;
                    if (Current == null) {
                        Parent.Leftchild = newnode;
                        return;
                    }
                }
            } else {
                if (birthday.isAfter(Current.person.getBirthday())) {
                    Current = Current.Rightchild;
                    if (Current == null) {
                        Parent.Rightchild = newnode;
                        return;
                    }
                } else {
                    Current = Current.Leftchild;
                    if (Current == null) {
                        Parent.Leftchild = newnode;
                        return;
                    }
                }
            }
        }
    }
}


    public void inorder(Node localroot){
    if(root!=null){
    inorder(localroot.Leftchild);
    System.out.println("Nombre: "+localroot.person.getName()+" Apellido: "+localroot.person.getLastname()+ " ID: "+localroot.person.getId()+" Fecha de nacimiento: "+localroot.person.getBirthday());
    inorder(localroot.Rightchild);
    }

    }
    public void preOrder(Node localroot) {
        if (localroot != null) {
            preOrder(localroot.Leftchild);
            preOrder(localroot.Rightchild);
            System.out.println("Nombre: "+localroot.person.getName()+" Apellido: "+localroot.person.getLastname()+ " ID: "+localroot.person.getId()+" Fecha de nacimiento: "+localroot.person.getBirthday());
        }
    }


    public void postorder(Node localroot) {
        if (localroot != null) {
            System.out.println("Nombre: "+localroot.person.getName()+" Apellido: "+localroot.person.getLastname()+ " ID: "+localroot.person.getId()+" Fecha de nacimiento: "+localroot.person.getBirthday());
            preOrder(localroot.Leftchild);
            preOrder(localroot.Rightchild);

        }
    }

}
