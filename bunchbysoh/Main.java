package bunchbysoh;

public class Main {
  static class CountsBySoH {
    public int healthy = 0;
    public int exchange = 0;
    public int failed = 0;
  };

  static CountsBySoH countBatteriesByHealth(int[] presentCapacities) {
    CountsBySoH counts = new CountsBySoH();
    
    for (int capacity : presentCapacities) {
      // Convert present capacity to SoH
      double soh = (double) capacity / 120.0 * 100.0;

      // Classify batteries based on SoH
      if (soh > 80.0 && soh <= 100.0) {
        counts.healthy++;
      } else if (soh >= 65.0 && soh <= 80.0) {
        counts.exchange++;
      } else {
        counts.failed++;
      }
    }
    return counts;
  }

  static void testBucketingByHealth() {
    System.out.println("Counting batteries by SoH...\n");
    int[] presentCapacities = {115, 118, 80, 95, 91, 77};
    CountsBySoH counts = countBatteriesByHealth(presentCapacities);

    // Print the status of batteries 
    System.out.println("Healthy Batteries: " + counts.healthy);
    System.out.println("Exchange Batteries: " + counts.exchange);
    System.out.println("Failed Batteries: " + counts.failed);

    // Given asserts
    assert(counts.healthy == 2);
    assert(counts.exchange == 3);
    assert(counts.failed == 1);
    
    System.out.println("Done counting :)\n");
  }

  public static void main(String[] args) {
    testBucketingByHealth();
  }
}
