package org.example.freespace.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.freespace.javastudy.enumstudy.CafeDrink;
import org.example.freespace.javastudy.enumstudy.CafeDrinkFunctionalInterface;
import org.example.freespace.javastudy.enumstudy.DrinkType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/java")
public class JavastudyController {
    //

    @PostMapping("/enum-test")
    public void enumTest() {
        CafeDrink americano = CafeDrink.AMERICANO;
        log.info("타입: " + americano.getDrinkType()); // tea
        americano.make();
        americano.receive();
        CafeDrink.AMERICANO.doWork();

        CafeDrink camomile = CafeDrink.CAMOMILE;
        log.info("타입: " + camomile.getDrinkType()); // tea
        camomile.make();
        camomile.receive();
        CafeDrink.CAMOMILE.doWork();
    }

    @PostMapping("/enum-test-functionalinterface")
    public void enumTestFunctionalInterface() {
        CafeDrinkFunctionalInterface americano = CafeDrinkFunctionalInterface.AMERICANO;
        log.info("타입: " + americano.getCoffeeType()); // tea
        americano.make();
        americano.receive();
        americano.callWorker();

        CafeDrinkFunctionalInterface camomile = CafeDrinkFunctionalInterface.CAMOMILE;
        log.info("타입: " + camomile.getCoffeeType()); // tea
        camomile.make();
        camomile.receive();
        camomile.callWorker();
    }

    @PostMapping("/enum-test-enumgroup")
    public void enumTestEnumGroup() {
//        DrinkType americanoType = DrinkType.findDrinkType(CafeDrink.AMERICANO);
//        double discount = americanoType.getDiscount();
        log.info("커피 종류별 할인 이벤트 중입니다~ 아메리카노의 가격은 : " +
                CafeDrink.AMERICANO.getPrice() *
                        DrinkType.findDrinkType(CafeDrink.AMERICANO).getDiscount()
                + " 원 입니다.");
    }
}
