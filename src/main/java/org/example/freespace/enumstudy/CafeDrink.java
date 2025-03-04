package org.example.freespace.enumstudy;

public enum CafeDrink {
    /*
     * name : AMERICANO, LATTE, CAMOMILE, ICETEA
     * 커피종류 : coffe,  tea,  ade
     * 할인율 : 0.05, 0.20, 0.10, 0
     * 동작 : 알바생의 이벤트 소개 및 가격 안내
     */

    // 추상함수를 사용하는 경우
    AMERICANO("coffee", 3000, 0.50){
        @Override
        public void doWork() {
            long realPrice = Math.round(AMERICANO.getPrice() * AMERICANO.discount);
            System.out.println("결제 도와드리겠습니다. " + AMERICANO.name() + "는 현재 할인 이벤트중입니다. 할인해서 " + realPrice + " 원 입니다.");
        }
    },
    LATTE("coffee", 3500, 0.20){
        @Override
        public void doWork() {
            System.out.println("어... 라떼는 할인 이벤트가 끝났습니다....! 죄송합니다." + LATTE.price + " 원 결제 도와드리겠습니다.");
        }
    },
    CAMOMILE("tea", 4000, 0.10) {
        @Override
        public void doWork() {
            System.out.println("캐모마일 티를 드신 당신!!! 무료 이벤트 당첨입니다!!! 축하드립니다~~ 안녕히 가세요~");
        }
    },
    ICETEA("ade", 2800, 0) {
        @Override
        public void doWork() {
            long realPrice = Math.round(AMERICANO.getPrice() * AMERICANO.discount);
            System.out.println("ade 는 할인 제외 대상입니다. " + ICETEA.price + "결제 도와드리겠습니다.");
        }
    },
    ;


    // CafeDrink 상태 필드
    private final String drinkType;
    private final long price;
    private final double discount;
    // CafeDrink 익명 메서드 (각 상수에서 오버라이드 시켜야함.)
    public abstract void doWork();

    // 생성자
    CafeDrink(String coffeeType, long price, double discount) {
        this.drinkType = coffeeType;
        this.price = price;
        this.discount = discount;
    }

    // 커피 타입 반환 메서드 (@Getter 적용 안됨.)
    public String getCoffeeType() { return drinkType; }

    // 커피 가격 메서드
    public long getPrice() { return price; }
    // 커피별 할인률 메서드
    public double getDiscount() { return discount; }

    // 제조 메서드
    public void make() {
        System.out.println(name() + "을/를 제조하겠습니다.");
    }
    // 제작 완료 안내 메서드
    public void receive() {
        System.out.println("주문하신 " + name() + "나왔습니다.");
    }
}
