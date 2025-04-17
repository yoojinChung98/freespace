package org.example.freespace.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.lang.reflect.Field;
import java.util.ArrayList;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/main")
public class MainController {

    @PostMapping("/test")
    public void test(@RequestBody String testStr) throws Exception {
        //
        ArrayList<TestClass> classList = new ArrayList<>();
        for (int i = 0; i < 3000; i++) {
            TestClass targetClass = new TestClass();
            classList.add(targetClass);
        }
        log.info(String.valueOf(getCapacity(classList)));
        classList.trimToSize();
        log.info(String.valueOf(getCapacity(classList)));
        //
    }

    private static int getCapacity(ArrayList<?> targetList) throws Exception {
        Field dataField = ArrayList.class.getDeclaredField("elementData");
        dataField.setAccessible(true);
        Object[] elementData = (Object[]) dataField.get(targetList);
        return elementData.length;
    }

    @Getter
    @Setter
    public class TestClass {
        private String testField1;
        private String testField2;
        private String testField3;
        private String testField4;
    }

    // 인터페이스 다형성 테스트
    @PostMapping("/upcast")
    public void upcast() {
        Dog dog = new Dog();
        dog.move();
        dog.where();
        GroundAnimal groundAnimal = (GroundAnimal) dog;
        groundAnimal.move();
        groundAnimal.where();
        // 당연한거지만 extends 하지 않은 타입으로는 형변환 불가능
//        SkyAnimal skyAnimal = (SkyAnimal) dog;
        // 결국 마지막으로 오버라이딩 된 메서드가 호출
        GroundAnimal pipi = new Pipi();
        pipi.move();

        Animal animal = (Animal) dog;
        animal.move();
        animal.where();

    }

    public interface Animal {
        public void move();
        public void where();
    }

    public class GroundAnimal implements Animal {
        @Override
        public void move() {
            log.info("GroundAnimal move");
        }
        @Override
        public void where() {
            log.info("on the ground");
        }
    }

    public class SkyAnimal implements Animal {
        @Override
        public void move() {
            log.info("SkyAnimal move on sky");
        }
        @Override
        public void where() {
            log.info("on the sky");
        }
    }

    public class Dog extends GroundAnimal {
        @Override
        public void move() {
            log.info("Dog move");
        }
    }

    public class Owl extends SkyAnimal {
        @Override
        public void move() {
            log.info("owl move");
        }
    }

    public class Pipi extends Dog {
        //
        // rebase test 3
        // rebase test 3
    }
}
