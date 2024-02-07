@ExtendWith(MockitoExtension.class)
public class AppSpyTest {

  @Spy 
  private App2 app2; // During the UT, there is an objected created for App2

  @Test
  void testMultiply() {
    // If we just mock provider2(), provider() is still working normally (due to Spy)

    when(app2.provider2(8, 2)).thenReturn(105);
    App1 app1 = new App1(app2);
    int actual = app1.multiply(8, 2);
    assertEquals(109, actual); // 8 / 2 + 100
  }
  

}
