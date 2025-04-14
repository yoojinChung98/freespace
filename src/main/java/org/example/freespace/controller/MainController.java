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
            targetClass.setTestField(String.valueOf(i));
            classList.add(targetClass);
        }
        log.info(String.valueOf(getCapacity(classList)));
        classList.trimToSize();
        log.info(String.valueOf(getCapacity(classList)));
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
        private String testField;
    }
}
