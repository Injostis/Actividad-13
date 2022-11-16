import java.util.*;
interface Anonymous{
    public List<String> arrange(List<String> list);
};

public class Main {
    public static List<String> myList = new ArrayList<>();

    public static void main(String[] args) {
        setWords();
        System.out.println("Orden natural.");
        printWords(myList);

        //Orden por longitud Clase anónima
        System.out.println("Orden por longitud Clase anónima");
        Anonymous anon = new Anonymous() {
            @Override
            public List<String> arrange(List<String> list) {
                list.sort(Comparator.comparingInt(String::length));
                return list;
            }
        };
        printWords(anon.arrange(myList));

        //Orden por longitud Lambda
        System.out.println("Orden por longitud Lambda");
        Collections.sort(myList, (a,b) -> Integer.compare(a.length(), b.length()));
        printWords(myList);

        //Orden por longitud Método de referencia
        System.out.println("Orden por longitud Método de referencia");
        myList.sort(Comparator.comparingInt(String::length));
        printWords(myList);

        //Orden alfabético Clase anónima
        System.out.println("Orden alfabético Clase anónima");
        Anonymous anon2 = new Anonymous() {
            @Override
            public List<String> arrange(List<String> list) {
                list.sort((a, b) -> a.compareTo(b));
                return list;
            }
        };
        printWords(anon2.arrange(myList));

        //Orden alfabético Lambda
        System.out.println("Orden alfabético Lambda");
        myList.sort((a, b) -> a.compareTo(b));
        printWords(myList);

        //Orden alfabético Método de referencia
        System.out.println("Orden alfabético Método de referencia");
        myList.sort(String::compareTo);
        printWords(myList);
    }

    public static void setWords(){
        myList.addAll(Arrays.asList(
                new String("Donkey"),
                        new String("Size"),
                        new String("Injure"),
                        new String("Tame"),
                        new String("Squealing"),
                        new String("Broken"),
                        new String("Lake"),
                        new String("Park"),
                        new String("Lying")));
    }

    public static void printWords(List list){
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
        System.out.println();
    }
}