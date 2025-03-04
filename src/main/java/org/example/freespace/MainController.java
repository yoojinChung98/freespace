package org.example.freespace;

import org.example.freespace.enumstudy.CafeDrink;
import org.example.freespace.enumstudy.CafeDrinkFunctionalInterface;
import org.example.freespace.enumstudy.DrinkType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
//@RequestMapping("/main")
public class MainController {

    @PostMapping("/test")
    public void test(@RequestBody String testStr) {
        System.out.println("test Pass!");
    }

    @GetMapping("/enum-test")
    public void enumTest() {
        // 실행 테스트
        CafeDrink americano = CafeDrink.AMERICANO;
        System.out.println("타입: " + americano.getDrinkType()); // tea
        americano.make();
        americano.receive();
        CafeDrink.AMERICANO.doWork();

        CafeDrink camomile = CafeDrink.CAMOMILE;
        System.out.println("타입: " + camomile.getDrinkType()); // tea
        camomile.make();
        camomile.receive();
        CafeDrink.CAMOMILE.doWork();
    }

    @GetMapping("/enum-test-functionalinterface")
    public void enumTestFunctionalInterface() {
        // 실행 테스트
        CafeDrinkFunctionalInterface americano = CafeDrinkFunctionalInterface.AMERICANO;
        System.out.println("타입: " + americano.getCoffeeType()); // tea
        americano.make();
        americano.receive();
        americano.callWorker();

        CafeDrinkFunctionalInterface camomile = CafeDrinkFunctionalInterface.CAMOMILE;
        System.out.println("타입: " + camomile.getCoffeeType()); // tea
        camomile.make();
        camomile.receive();
        camomile.callWorker();
    }

    @GetMapping("/enum-test-enumgroup")
    public void enumTestEnumGroup() {
//        DrinkType americanoType = DrinkType.findDrinkType(CafeDrink.AMERICANO);
//        double discount = americanoType.getDiscount();
        System.out.println("커피 종류별 할인 이벤트 중입니다~ 아메리카노의 가격은 : " +
                CafeDrink.AMERICANO.getPrice() *
                        DrinkType.findDrinkType(CafeDrink.AMERICANO).getDiscount()
        + " 원 입니다.");
    }
}
