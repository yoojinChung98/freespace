package org.example.freespace.javastudy.enumstudy;

// 인터페이스형 함수 선언
@FunctionalInterface
interface CafeDrinkWorker {
    public void doWork(long price, double discount );
}

public enum CafeDrinkFunctionalInterface {
    /*
     * name : AMERICANO, LATTE, CAMOMILE, ICETEA
     * 커피종류 : coffe,  tea,  ade
     * 할인율 : 0.05, 0.20, 0.10, 0
     * 동작 : 가격 안내
     */

    // 파라미터로 인페이스형 함수를 익명함수로 넣는 방법. 간단한 메서드라면 람다식을 이용하여 예쁘게 만들 수 있음
    AMERICANO("coffee", 3000, 0.50, (long price, double discount) -> System.out.println("아메리카노의 가격은 " + Math.round(price*discount) + "입니다.") ),
    LATTE("coffee", 3500, 0.20, (long price, double discount) -> System.out.println("라떼의 가격은 " + Math.round(price*discount) + "입니다.")),
    CAMOMILE("tea", 4000, 0.10, (long price, double discount) -> System.out.println("캐모마일티의 가격은 " + Math.round(price*discount) + "입니다.")),
    ICETEA("ade", 2800, 0, (long price, double discount) -> System.out.println("아이스티의 가격은 " + Math.round(price*discount) + "입니다."));


    // CafeDrink 상태 필드
    private final String drinkType;
    private final long price;
    private final double discount;
    // 인터페이스형 함수 변수
    private final CafeDrinkWorker worker;

    // enum의 메서드. (알바생을 불러 일을 시킴)
    public void callWorker() {
        worker.doWork(price, discount);
    }

    // 생성자
    CafeDrinkFunctionalInterface(String coffeeType, long price, double discount, CafeDrinkWorker worker) {
        this.drinkType = coffeeType;
        this.price = price;
        this.discount = discount;
        this.worker = worker;
    }

    // 커피 타입 반환 메서드 (@Getter 적용 안됨.)
    public String getCoffeeType() { return drinkType; }
    // 커피 가격 메서드
    public long getPrice() { return price; }
    // 커피별 할인률 메서드
    public double getDiscount() { return discount; }

    // 제조 메서드
    public void make() { System.out.println(name() + "을/를 제조하겠습니다."); }
    // 제작 완료 안내 메서드
    public void receive() {
        System.out.println("주문하신 " + name() + "나왔습니다.");
    }
}
