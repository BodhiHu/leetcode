import java.math.BigDecimal;

public class Exec {
  public static void main(String args[]) {
    float f1 = 1.0f;
    float f2 = 1.0f;
    Float F1 = 1.0f;
    Float F2 = 1.0f;
    Double D1 = 1.0;
    BigDecimal BD1 = new BigDecimal("1.0");
    BigDecimal BD2 = new BigDecimal("1.0");

    System.out.printf("f1 == f2: %s\n", f1 == f2);
    System.out.printf("F1 == f1: %s\n", F1 == f1);
    System.out.printf("F1 == F2: %s\n", F1 == F2);
    System.out.printf("F1.equals(f1): %s\n", F1.equals(f1));
    System.out.printf("F1.equals(F2): %s\n", F1.equals(F2));
    System.out.printf("BD1.equals(BD2): %s\n", BD1.equals(BD2));
  }
}
