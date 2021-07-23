import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class AlgoSolving {

  double calculatePrice(List<Integer> books) {

    double price = 0;
    int timesFirstBookExist = 0;
    int timesSecondBookExist = 0;
    int timesThirdBookExist = 0;
    int timesFourthBookExist = 0;
    int timesFifthBookExist = 0;

    Map<String, Double> prices = new HashMap<>();
    prices.put("fiveBooks", (5 * 8) - 0.75);
    prices.put("fourBooks", (4 * 8) - 0.8);
    prices.put("threeBooks", (3 * 8) - 0.90);
    prices.put("twoBooks", (2 * 8) - 0.95);
    prices.put("oneBook", (double) 8);

    // calculate number of occurence of each book in the input list

    for (int i = 0; i < books.size(); i++) {

      if (books.get(i) == 0) {
        timesFirstBookExist++;
      }
      if (books.get(i) == 1) {
        timesSecondBookExist++;
      }
      if (books.get(i) == 2) {
        timesThirdBookExist++;
      }
      if (books.get(i) == 3) {
        timesFourthBookExist++;
      }
      if (books.get(i) == 4) {
        timesFifthBookExist++;
      }

    }

    // add number of occurence of each book to occurences list
    List<Integer> occurences = new ArrayList<>();
    if (timesFirstBookExist > 0) {
      occurences.add(timesFirstBookExist);
    }
    if (timesSecondBookExist > 0) {
      occurences.add(timesSecondBookExist);
    }
    if (timesSecondBookExist > 0) {
      occurences.add(timesThirdBookExist);
    }
    if (timesSecondBookExist > 0) {
      occurences.add(timesFourthBookExist);
    }
    if (timesSecondBookExist > 0) {
      occurences.add(timesFifthBookExist);
    }

    int initialSiz = occurences.size();

    for (int i = 0; i < initialSiz; i++) {

      List<Integer> allIndexesThatContainsMin = min(occurences);

      int minNumberOfOccurences = occurences.get(allIndexesThatContainsMin.get(0));

      if (occurences.size() == 5) {
        price += minNumberOfOccurences * prices.get("fiveBooks");
      }
      if (occurences.size() == 4) {
        price += minNumberOfOccurences * prices.get("fourBooks");
      }
      if (occurences.size() == 3) {
        price += minNumberOfOccurences * prices.get("threeBooks");
      }

      if (occurences.size() == 2) {
        price += minNumberOfOccurences * prices.get("twoBooks");
      }

      if (occurences.size() == 1) {
        price += minNumberOfOccurences * prices.get("oneBook");
        ;
      }

      occurences.removeAll(allIndexesThatContainsMin);
      for (int j = 0; j < occurences.size(); j++) {

        occurences.set(j, occurences.get(j) - minNumberOfOccurences);
      }

    }

    return price;

  }

  // finds the minimum number of occurence and turns all indexes that has this
  // number
  private List<Integer> min(List<Integer> occurences) {
    return null;
  }
}