package sample;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class MyController {

    private MyService myResponseService;

    @RequestMapping(value = "/friends", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> friends() {
        return myResponseService.getResponse();
    }

  @RequestMapping(value = "/unfriendMe", method = RequestMethod.PUT, produces = "application/json;charset=UTF-8")
  public ResponseEntity<String> unfriends() {
    return myResponseService.getResponse();
  }

    @RequestMapping(value = "/sayHello", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    public ResponseEntity<String> sayHello() {
        return new ResponseEntity<>("{ \"reply\": \"Hello\" }", HttpStatus.OK);
    }

    public MyController withMyResponseService(MyService myResponseService) {
        this.myResponseService = myResponseService;
        return this;
    }
}
