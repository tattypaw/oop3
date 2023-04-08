import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        MyList list = new MyList();
        list.add("узел 1");
        list.add("узел 2");
        list.add(1, "узел 2_1");
        
        for(Object item : list)
        {
            System.out.println(item);
        }

        list.remove(1);

        for(Object item : list)
        {
            System.out.println(item);
        }

    }
}