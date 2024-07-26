
package com.study.rest.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class C {

    @Autowired(required = false) // 종속성 주입 무조건 안해도된다는 표시
    private D d;

    public  void cCall() {
        System.out.println("C객체에서 메소드 호출");
        d.dCall();
    }
}
