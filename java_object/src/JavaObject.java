import java.io.FileWriter;
import java.io.IOException;

public class JavaObject {

    public static void main(String[] args) throws IOException {
        /*
        //클래스: FileWriter  인스턴스: fw
        FileWriter fw = new FileWriter("data.txt"); // FileWriter -> throws IOException 필요
        fw.write("hello");
        fw.write("Java");
        fw.close(); // 반드시 닫아준다
        */

        Print p1 = new Print();
        Print p2 = new Print();
        //클래스: Print  인스턴스: p1, p2
        p1.s = "hello";
        p1.printA();
        p1.printB();

        p2.s = "world";
        p2.printA();
        p2.printB();
    }


}

class Print{
    public String s = "";

    public void printA(){
        System.out.println("A");
        System.out.println(s + "\n");
    }

    public void printB(){
        System.out.println("B");
        System.out.println(s + "\n");
    }
}

/*
    static: 클래스를 통해 접근O, 공유됨
    instance (static없을때): 클래스를 통해 접근X, 독립된 존재

    F 클래스 / f1, f2 인스턴스 선언
    static classVar="hello" / instanceVar="world" 선언
    (1) f1.classVar="change" 일 때
            F.classVar -> "change" 출력
            f2.classVar -> "change"출력
    (2) f1.instanceVar="change" 일 때
            f1.instanceVar -> "change"출력
            f2.instanceVar -> "world"출력
*/