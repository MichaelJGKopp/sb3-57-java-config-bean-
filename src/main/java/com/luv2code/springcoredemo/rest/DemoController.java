package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  // define a private field for the dependency
  private Coach myCoach;

  // define a constructor for dependency injection

    @Autowired
    public DemoController(@Qualifier("cricketCoach") Coach theCoach) {
    System.out.println("In constructor: " + getClass().getSimpleName());
      this.myCoach = theCoach;
    }

//  @Autowired
//  public void setMyCoach(Coach myCoach) {
//    this.myCoach = myCoach;
//  }

  @GetMapping("/dailyworkout")
  public String getDailyWorkout() {
    return "<html><body><p style='font-size:24px;'>"
        + myCoach.getDailyWorkout()
        + "</p></body></html>";
  }
}
