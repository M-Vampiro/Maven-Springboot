public class DemoSwitch {
  public static void main(String[] args) {
    // if, else-if -> comparison and logical operators

    // switch: single value comparison (==)
    char vipGrade = 'G'; // G / S / N
    double discount = 0.0d; // Silver(S) -> 10%, Gold(G) -> 20%
    switch (vipGrade) {
      case 'G':
        discount += 0.1d;
      case 'S':
        discount += 0.1d;
      case 'N':
    }
    System.out.println("discount=" + discount);

    // with break
    discount = 0.0d;
    switch (vipGrade) {
      case 'G':
        discount += 0.2d;
        break;
      case 'S':
        discount += 0.1d;
        break;
      case 'N':
      default: // other characters
    }

    // Switch int, String
    
  }
}