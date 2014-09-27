import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        try {
            Class[] cArg = new Class[1];
            cArg[0] = Comparable[].class;

            List<Object> params = new ArrayList<Object>();
            Integer[] some = new Integer[10];
            for (int i = 0; i < 10; i++) {
                some[i] = i;
            }
            params.add(some);

            OrderedSet<Integer> obj = (OrderedSet<Integer>) Class.forName(args[0]).getConstructor(cArg).newInstance(params.toArray());

            // Тест на добавление элемента массива
            System.out.println(obj.add(10));

            // Тест на вывод итератором
            for (Integer ob : obj) {
                System.out.println(ob);
            }

            // Тест на удаление элемента массива
            System.out.println(obj.remove(7) + " " + obj.remove(0) + " " + obj.remove(11));
            for (Integer ob : obj) {
                System.out.println(ob);
            }

            // Тест на минимум и максимум
            System.out.println(obj.min() + " " + obj.max());
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}


