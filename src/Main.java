class Samples<T> {
    private T value; // 멤버 변수 val의 타입은 T 이다.

    // T 타입의 값 val을 반환한다.
    public T getValue() {
        return value;
    }

    // T 타입의 값을 멤버 변수 val에 대입한다.
    public void setValue(T value) {
        this.value = value;
    }
}

interface ISample<T> {
    public void addElement(T t, int index);
    public T getElement(int index);
}

class Sample<T> implements ISample<T> {
    private final T[] array;

    public Sample() {
        array = (T[]) new Object[10];
    }

    @Override
    public void addElement(T element, int index) {
        array[index] = element;
    }

    @Override
    public T getElement(int index) {
        return array[index];
    }
}
public class Main{
    public static void main(String[] args) {
        exam2();
    }

    public static void exam1(){
        // 정수형을 다루는 제네릭 클래스
        Samples<Integer> s1 = new Samples<>();
        s1.setValue(1);

        // 실수형을 다루는 제네릭 클래스
        Samples<Double> s2 = new Samples<>();
        s2.setValue(1.0);

        // 문자열을 다루는 제네릭 클래스
        Samples<String> s3 = new Samples<>();
        s3.setValue("1dd");

        System.out.println(s1.getValue());
        System.out.println(s2.getValue());
        System.out.println(s3.getValue());
    }

    static void exam2(){
        Sample<String> sample = new Sample<>();
        sample.addElement("This is string", 5);
        System.out.println(sample.getElement(5));
    }
}


