import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // Задача 1
        //Получить из int->Integer и наоборот
        int intArray [] = {5,2,3};
        // Получение Integer[] из int[]
        Integer [] integerArray = IntStream.of(intArray).boxed().toArray(Integer []::new);
        // Получение int[] из Integer[]
        int result [] = Arrays.stream(integerArray).mapToInt(i->i).toArray();

        System.out.println(Arrays.toString(result));


        Object[] arr =new Object[]{"Кот",1,true};
        swap_obj(arr,10,12);
        System.out.println(Arrays.toString(arr));

        // Задача 2
        ArrayList<Object> arrlist=new ArrayList<>(Arrays.asList(arr));
        System.out.println(arrlist.get(0));

        String[] arr_str=new String[]{"qwe","sdf","xcv"};
        Integer[] arr_int=new Integer[]{1,2,3,4,5};

        ArrayList<Integer> arrlist1=convertToList(arr_int);
        ArrayList<String> arrlist2=convertToList(arr_str);

        System.out.println(arrlist1.toString());
        System.out.println(arrlist2.toString());

        // Задача 3

        FruitBox<Apple> box_apple=new FruitBox<>(new Apple(1.0f),new Apple(1.0f),new Apple(1.0f));
        FruitBox<Apple> box_apple1=new FruitBox<>(new Apple(1.0f),new Apple(1.0f),new Apple(1.0f));
        FruitBox<Orange> box_orange=new FruitBox<>(new Orange(1.5f),new Orange(1.5f),new Orange(1.5f));
        FruitBox<Fruit> box=new FruitBox<>();


        if (box_apple.compare(box_orange))
            System.out.println("Коробки одинаково весят");
            else
            System.out.println("Коробки весят по разному");


        System.out.println(box_apple.getWeight());
        System.out.println(box_orange.getWeight());

        box_apple.transfer_box(box_apple1);
        System.out.println(box_apple);
        System.out.println(box_apple1);

        box_apple1.transfer_box(box);
        box_orange.transfer_box(box);
        System.out.println(box.getContainer().size());


    }
    //Замена эл. массива местами
    public static void swap_obj(Object[] arr, int ind1,int ind2){
       try {
           Object tmp = arr[ind1];
           arr[ind1] = arr[ind2];
           arr[ind2] = tmp;
       }
       catch(ArrayIndexOutOfBoundsException e){
           System.out.println("Индексы выходят за пределы массива");
       }
    }
    //Преобразуем массив заданного типа к списку
    public static <T> ArrayList<T> convertToList(T[] arr){
        return new ArrayList<>(Arrays.asList(arr));
    }

}
