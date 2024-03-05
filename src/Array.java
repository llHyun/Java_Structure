import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


class Userd {
    final String name;
    final int age;

    Userd(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

public class Array {
    public static void main(String[] args) {
        test13();
    }

    //배열 복사
    public static void test1(){
        int[] arr1 = {10, 20, 30, 40, 50};

        int[] arr2 = new int[arr1.length * 2]; // 우선 초기 배열보다 길이가 두배인 새로운 배열을 선언

        // Array.copyOf() 메서드 사용
        arr2 = Arrays.copyOf(arr1, arr1.length); // arr1 배열을 arr1.length 전체 길이만큼 전체 복사해서 arr2에 할당
        System.out.println(Arrays.toString(arr2)); // [10, 20, 30, 40, 50]

        arr2 = Arrays.copyOfRange(arr1, 1, 3); // 배열요소 시작점, 끝점 지정. 1, 2 만 복사해서 반환
        System.out.println(Arrays.toString(arr2)); // [10, 20, 30, 40, 50]

    }
    //배열 정렬
    public static void test2() {
        Integer[] arr = { 3,2,0,1,4 };

        // 오름차순 정렬
        Arrays.sort(arr); // 자기 자신 배열을 정렬 시킴 (정렬된 배열을 반환하는 것이 아니다)
        System.out.println(Arrays.toString(arr)); // [0,1,2,3,4]

        // 내림차순 정렬
        Arrays.sort(arr, Collections.reverseOrder()); // 배열을 내림차순으로 정렬할 때는 Collections 클래스의 reverseOrder() 함수를 사용
        System.out.println(Arrays.toString(arr)); // [4,3,2,1,0]

        // 배열 일부부만 정렬
        int[] arr_new = { 3,2,0,1,4 };
        Arrays.sort(arr_new, 0, 3); // 배열 요소 0, 1, 2 만 정렬
        System.out.println(Arrays.toString(arr_new)); // [0, 2, 3, 1, 4]
    }

    //wrapper class와 기본 자료형 간 자동 변환
    public static void test3(){
        Integer wrapperInt = 21;
        int primaryInt = wrapperInt; // wrapperInt가 자동 언박싱 되는 모습
        System.out.println(primaryInt+wrapperInt);
    }

    //배열 비교
    public static void test4(){
        String[] arr1 = { "홍길동", "임꺽정", "박혁거세", "주몽", "고담덕" };
        String[] arr2 = { "홍길동", "임꺽정", "박혁거세", "주몽", "고담덕" };
        String[] arr3 = { "홍길동", "임꺽정", "박혁거세", "주몽" };

        System.out.println("arr1 == arr2 : " + Arrays.equals(arr1, arr2)); // arr1 == arr2 : true

        System.out.println("arr1 == arr3 : " + Arrays.equals(arr1, arr3)); // arr1 == arr3 : false
    }

    //다차원 배열
    public static void test5(){
        int[] arr = {0,1,2,3,4};
        System.out.println(Arrays.toString(arr)); // [0, 1, 2, 3, 4]

        // 2차원 배열 한방 출력
        int[][] arr2 = {
                {10,20,30},
                {40,50,60},
                {70,80,90},
                {100,200,300}
        };
        System.out.println(Arrays.deepToString(arr2));
    }

    //다차원 배열 비교
    public static void test6(){
        String[][] arr1 = {
                { "홍길동", "임꺽정" },
                { "박혁거세", "주몽", "고담덕" }
        };
        String[][] arr2 = {
                { "홍길동", "임꺽정" },
                { "박혁거세", "주몽", "고담덕" }
        };
        String[][] arr3 = {
                { "홍길동" },
                { "주몽", "고담덕" }
        };

        System.out.println("arr1 == arr2 : " + Arrays.deepEquals(arr1, arr2)); // arr1 == arr2 : true

        System.out.println("arr1 == arr3 : " + Arrays.deepEquals(arr1, arr3)); // arr1 == arr3 : false
    }

    //가변 배열
    public static void test7(){
        int[][] score = {
                {100, 100},
                {20, 20, 20},
                {30, 30},
                {40, 40},
                {50, 50, 50}
        };

        System.out.println(Arrays.deepToString(score));
    }

    //객체 배열
    public static void test8(){
        // myObject 클래스
        class myObject{
            final int id;
            final String descriptions;

            myObject(int id, String description) {
                this.id = id;
                this.descriptions = description;
            }
        }

        // myObject 클래스를 담을 수 있는 공간 3개 크기의 객체 배열 생성
        myObject[] arrayObj = new myObject[3];

        // 객체 배열 초기화
        arrayObj[0] = new myObject(101, "first");
        arrayObj[1] = new myObject(102, "second");
        arrayObj[2] = new myObject(103, "third");

        // 객체 배열 사용
        System.out.println(arrayObj[2].descriptions); // "first  array, John"

        /* ************************************ */

        // 객체 배열 선언 + 초기화 한번에
        myObject[] arrayObj2 = {
                new myObject(101, "first"),
                new myObject(101, "second"),
                new myObject(101, "third")
        };
    }

    //객체 배열 복사
    //(그냥 복사하면 주소값을 복사하기 때문에 하나의 값을 바꾸면 두개가 다 바뀌게 돼버림)
    public static void test9(){
        class myObject{
            int id;
            final String description;

            myObject(int id, String description) {
                this.id = id;
                this.description = description;
            }
        }
        //주소값을 복사함
        myObject[] arrayObj = {
                new myObject(101, "first"),
                new myObject(102, "second"),
                new myObject(103, "third")
        };
        System.out.println(Arrays.toString(arrayObj)); // [main$1myObject@251a69d7, main$1myObject@7344699f, main$1myObject@6b95977]

        //for문으로 내부 정보를 복사
        myObject[] arrayObj2 = new myObject[3];
        for(int i = 0; i < arrayObj.length; i++) {
            arrayObj2[i] = new myObject(arrayObj[i].id, arrayObj[i].description);
        }

        // 배열 내용물 객체의 @주소가 달라짐을 볼 수 있다.
        System.out.println(Arrays.toString(arrayObj2)); // [main$1myObject@7e9e5f8a, main$1myObject@8bcc55f, main$1myObject@58644d46]

        System.out.println(arrayObj[0].id); // 101
        arrayObj2[0].id = 999; // 복사한 arrayObj2의 첫째 객체의 멤버를 변경
        System.out.println(arrayObj2[0].id); // 999
        System.out.println(arrayObj[0].id); // 101
    }

    //객체 배열 정렬(comparable 사용)
    public static void test10(){
        // 클래스에 Comparable<> 인터페이스를 구현한다
        class User implements Comparable<User> {
            final String name;
            final int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public int compareTo(User user) {
                // 비교 로직을 구현
                return Integer.compare(this.age, user.age);
            }
        }

        User[] users = {
                new User("홍길동", 32),
                new User("김춘추", 64),
                new User("임꺽정", 48),
                new User("박혁거세", 14),
        };

        Arrays.sort(users); // 나이순 정렬
        // Arrays.sort(users, Collections.reverseOrder()); // 역순 정렬

        for (User u : users) { // 출력
            System.out.println(u.name + " " + u.age + "세");
        }
    }

    //객체 배열 정렬(Comparator 사용)
    public static void test11(){

        Userd[] users = {
                new Userd("홍길동", 32),
                new Userd("김춘추", 64),
                new Userd("임꺽정", 48),
                new Userd("박혁거세", 14),
        };

        // Arrays.sort(배열, new Comparator<>() { ... });
        Arrays.sort(users, new Comparator<Userd>() {
            @Override
            public int compare(Userd u1, Userd u2) {
                return Integer.compare(u1.age, u2.age); // Integer 클래스에 정의된 compare 함수로 두 가격 정수 원시값을 비교
            }
        });

        // java8 람다식으로 다음과 같이 축약이 가능
        Arrays.sort(users, (u1, u2) -> Integer.compare(u1.age, u2.age)); // 나이순 정렬

        // 출력
        for (Userd u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }
    }


    //객체 배열 정렬(문자열 순서)
    public static void test12(){


        Userd[] users = {
                new Userd("홍길동", 32),
                new Userd("김춘추", 64),
                new Userd("임꺽정", 48),
                new Userd("박혁거세", 14),
        };

        // Arrays.sort(배열, new Comparator<>() { ... });
        Arrays.sort(users, new Comparator<Userd>() {
            @Override
            public int compare(Userd u1, Userd u2) {
                return u1.name.compareTo(u2.name);
            }
        });

        // java8 람다식으로 다음과 같이 축약이 가능
        Arrays.sort(users, (u1, u2) -> u1.name.compareTo(u2.name)); // 이름순 정렬

        // 출력
        for (Userd u : users) {
            System.out.println(u.name + " " + u.age + "세");
        }
    }

    //객체 배열 정렬(나이순, 이름순, 나이순+이름순)
    public static void test13(){
        class User {
            private final String name;
            private final int age;

            User(String name, int age) {
                this.name = name;
                this.age = age;
            }

            public int getAge() {
                return this.age;
            }
            public String getName() {
                return this.name;
            }
        }

        User[] users = {
                new User("홍길동", 30),
                new User("김춘추", 60),
                new User("임꺽정", 30),
                new User("김좌진", 20),
                new User("주몽", 50),
                new User("심사임당", 30),
        };

        Arrays.sort(users, Comparator.comparing(User::getAge)); // 나이순 정렬
        for (User u : users) { System.out.println(u.name + " " + u.age + "세"); } // 출력

        System.out.println("\n");

        Arrays.sort(users, Comparator.comparing(User::getName)); // 이름순 정렬
        for (User u : users) { System.out.println(u.name + " " + u.age + "세"); }

        System.out.println("\n");

        Arrays.sort(users, Comparator.comparing(User::getAge).thenComparing(User::getName)); // 먼저 나이순 정렬하고 나이가 같으면 따로 이름순 정렬
        for (User u : users) { System.out.println(u.name + " " + u.age + "세"); }
    }
}
