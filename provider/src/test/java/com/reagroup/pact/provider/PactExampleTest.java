package com.reagroup.pact.provider;

import org.junit.Before;
import org.junit.runner.RunWith;

import static org.mockito.Mockito.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import sample.MyController;
import sample.MyService;

@RunWith(PactRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContextPactTest.xml"})
@PactFile("file:src/test/resources/karmamochaconsumer-karmamochaprovider.json")
public class PactExampleTest {

  @Autowired
  private MyController myControllerWithService;

  private MyService myResponseService;

  @Before
  public void setUp() throws Exception {
    myResponseService = mock(MyService.class);
    myControllerWithService.withMyResponseService(myResponseService);
  }

  @ProviderState("default")
  public MyController shouldSayHello() {
    // do nothing
    return myControllerWithService;
  }

  @ProviderState("There is friend who has children Mary and James")
  public MyController shouldFindeFriendSue() {
    when(myResponseService.<String>getResponse())
      .thenReturn(new ResponseEntity<>("{\"friends\": [{\"name\": \"Sue\"}]}"
                                      , HttpStatus.OK));
    return myControllerWithService;
  }

  @ProviderState("I have no friends")
  public MyController cannotUnfiendWhenNoFriend() {
      when(myResponseService.<String>getResponse())
      .thenReturn(new ResponseEntity<>("{\"why\":\"you have no friend\"}"
                                      , HttpStatus.NOT_FOUND));
    return myControllerWithService;
  }

  @ProviderState("I am friends with Fred")
  public MyController shouldUnfriendFred() {
    when(myResponseService.<String>getResponse())
      .thenReturn(new ResponseEntity<>("{\"reply\":\"Bye\"}"
                                      , HttpStatus.OK));
    return myControllerWithService;
  }

}
