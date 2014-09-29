import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        System.out.println(args[0] + ":");
        try {
            Class[] cArg = new Class[1];
            cArg[0] = Comparable[].class;

            List<Object> params = new ArrayList<Object>();
            Integer[] some = new Integer[10];
            for (int i = 0; i < 10; i++) {
                some[i] = 2 * (10 - i);
            }
            params.add(some);

            OrderedSet<Integer> obj = (OrderedSet<Integer>) Class.forName(args[0]).getConstructor(cArg).newInstance(params.toArray());

            // Тест на добавление элемента массива
            System.out.println(obj.add(21));

            // Тест на вывод итератором
            for (Integer ob : obj) {
                System.out.println(ob);
            }

            // Тест на удаление элемента массива
            System.out.println(obj.remove(7) + " " + obj.remove(2) + " " + obj.remove(11));
            for (Integer ob : obj) {
                System.out.println(ob);
            }

            // Тест на минимум и максимум
            System.out.println(obj.min() + " " + obj.max());

            // Очистка массива перед замером скорости
            for (int i = 0; i <= 100; i++) {
                obj.remove(i);
            }

            // Замер скорости
            System.out.println("Time test started...");
            Random random = new Random(27644437); // Берём произвольное большое простое число
            long start = System.currentTimeMillis();

            for (int i = 0; i < 10000; i++) {
                if (random.nextBoolean()) {
                    obj.add(random.nextInt());
                } else {
                    obj.remove(random.nextInt());
                }
            }

            long end = System.currentTimeMillis();

            System.out.println("Time " + ((end - start) / 1000.0) + " s.");
        } catch (ClassNotFoundException | InvocationTargetException | NoSuchMethodException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}


