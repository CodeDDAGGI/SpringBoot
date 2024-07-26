package com.study.ssr.controller;

import com.study.ssr.model.Dvd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Objects;

@Controller
public class DvdController {
    @GetMapping("/dvds")
    public String dvdListPage(Model model) {
        Dvd dvd = Dvd.builder()
                .title("테스트1")
                .producer("테스트 제작사1")
                .publisher("테스트 발행사1")
                .build();

        Dvd dvd2 = Dvd.builder()
                .title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();

        Dvd dvd3 = Dvd.builder()
                .title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();

        model.addAttribute(dvd); // 객체 키 밸류
        model.addAttribute("names", List.of("김준일", "김준이", "김준삼")); // 리스트
        model.addAttribute("dvdList", List.of(dvd, dvd2, dvd3)); // 리스트
        model.addAttribute("title", "테스트 제목"); // 모델에 추가 // 리터럴 문자열

        return "views/dvd_list"; // view네임을 리턴해줌
    }

    // 서로 같은 코드
    // ModelAndView 리턴
    //    @GetMapping
    //    public ModelAndView dvdListPage() {
    //        ModelAndView mav = new ModelAndView();
    //        mav.setViewName("views/dvd_list");
    //        return mav;
    //    }
    
    @ResponseBody // 문자열 그대로 응답("views/dvd_list" 출력)
    @GetMapping("/dvds/body")
    public String getViewName() {
        return "views/dvd_list";
    }

    // 문법
    @ResponseBody // 붙여야 데이터가 전달이댐
    @GetMapping("/dvd") // JSON으로 리턴해줌
    public Object getDvd() {
        Dvd dvd = Dvd.builder().title("테스트")
                .producer("테스트 제작사")
                .publisher("테스트 발행사")
                .build();
        Dvd dvd2 = Dvd.builder().title("테스트2")
                .producer("테스트 제작사2")
                .publisher("테스트 발행사2")
                .build();
        Dvd dvd3 = Dvd.builder().title("테스트3")
                .producer("테스트 제작사3")
                .publisher("테스트 발행사3")
                .build();

        return List.of(dvd, dvd2, dvd3);
    }
}
