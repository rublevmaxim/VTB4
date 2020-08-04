import java.util.ArrayList;
import java.util.Arrays;

public class FruitBox<T extends Fruit> {
    public ArrayList<T> getContainer() {
        return container;
    }

    private ArrayList<T> container;

    //Создатся пустой список
    public FruitBox(ArrayList<T> container) {
        this.container = container;
    }

    //Создатся список с набором фруктов
    public FruitBox(T...fruits){
        this.container=new ArrayList<T>(Arrays.asList(fruits));
    }

    //Добавляем фрукт
    public void add(T fruits){
        this.container.add(fruits);
    }

    //Добавляем набор фруктов
    public void add(T...fruits){
        this.container.addAll(Arrays.asList(fruits));
    }

    public float getWeight(){
        if (container.size()==0){
            return 0.0f;
        }
        return container.size()*container.get(0).getWeight();
    }
    // В данной ситуации в место <? extends Fruit> можно написать просто <?>,т.к.
    // public class FruitBox<T extends Fruit>
    public boolean compare(FruitBox<? extends Fruit> box){
        return  Math.abs(this.getWeight()-box.getWeight())<0.0001;
    }

    public void transfer_box(FruitBox<? super T> box){
        if (this==box) {
            return;
        }
        box.container.addAll(this.container);
        this.container.clear();
    }
}
