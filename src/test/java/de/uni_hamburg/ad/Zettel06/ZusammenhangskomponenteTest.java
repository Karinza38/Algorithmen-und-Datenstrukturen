package de.uni_hamburg.ad.Zettel06;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class ZusammenhangskomponenteTest {
  Zusammenhangskomponente zsk = new Zusammenhangskomponente();

  @Test
  void getConnectedComponentCountTest1() {
    Map<Long, Set<Long>> testMap = new HashMap<>();
    /*
    1 ↔  2  5
    ↕ ↗↙    ↕
    3 ↔  4  6
     */

    Set<Long> set1 = new HashSet<>();
    set1.add(2L);
    set1.add(3L);
    testMap.put(1L, set1);

    Set<Long> set2 = new HashSet<>();
    set2.add(3L);
    set2.add(1L);
    testMap.put(2L, set2);

    Set<Long> set3 = new HashSet<>();
    set3.add(4L);
    set3.add(2L);
    set3.add(1L);
    testMap.put(3L, set3);

    Set<Long> set4 = new HashSet<>();
    set4.add(3L);
    testMap.put(4L, set4);

    Set<Long> set5 = new HashSet<>();
    set5.add(6L);
    testMap.put(5L, set5);

    Set<Long> set6 = new HashSet<>();
    set6.add(5L);
    testMap.put(6L, set6);

    assertThat(zsk.getConnectedComponentCount(testMap),is(2L));
  }

  @Test
  void getConnectedComponentCountTest_noNodes() {
    Map<Long, Set<Long>> testMap = new HashMap<>();
    assertThat(zsk.getConnectedComponentCount(testMap),is(0L));
  }

  @Test
  void getConnectedComponentCountTest_noEdges() {
    Map<Long, Set<Long>> testMap = new HashMap<>();
    testMap.put(1L, new HashSet<Long>());
    testMap.put(2L, new HashSet<Long>());
    testMap.put(3L, new HashSet<Long>());
    assertThat(zsk.getConnectedComponentCount(testMap),is(3L));
  }

  @Test
  void getConnectedComponentCountTest3() {
    Map<Long, Set<Long>> testMap = new HashMap<>(); /*
    1 ↔  2  5   7
    ↕ ↗↙    ↕
    3 ↔  4  6
     */

    Set<Long> set1 = new HashSet<>();
    set1.add(2L);
    set1.add(3L);
    testMap.put(1L, set1);

    Set<Long> set2 = new HashSet<>();
    set2.add(1L);
    set2.add(3L);
    testMap.put(2L, set2);

    Set<Long> set3 = new HashSet<>();
    set2.add(1L);
    set2.add(2L);
    testMap.put(3L, set3);

    Set<Long> set4 = new HashSet<>();
    testMap.put(4L, set4);

    Set<Long> set5 = new HashSet<>();
    set5.add(6L);
    testMap.put(5L, set5);

    Set<Long> set6 = new HashSet<>();
    set6.add(5L);
    testMap.put(6L, set6);

    Set<Long> set7 = new HashSet<>();
    testMap.put(7L, set7);
    assertThat(zsk.getConnectedComponentCount(testMap),is(4L));
  }

  @Test
  void getConnectedComponentCountTest_twoCicles() {
    Map<Long, Set<Long>> testMap = new HashMap<>(); /*
    1 ←  2  5 →7
    ↓ ↗     ↑↙
    3     4 →6
     */

    Set<Long> set1 = new HashSet<>();
    set1.add(3L);
    testMap.put(1L, set1);

    Set<Long> set2 = new HashSet<>();
    set2.add(1L);
    testMap.put(2L, set2);

    Set<Long> set3 = new HashSet<>();
    set2.add(2L);
    testMap.put(3L, set3);

    Set<Long> set4 = new HashSet<>();
    testMap.put(6L, set4);

    Set<Long> set5 = new HashSet<>();
    set5.add(7L);
    testMap.put(5L, set5);

    Set<Long> set6 = new HashSet<>();
    set6.add(5L);
    testMap.put(6L, set6);

    Set<Long> set7 = new HashSet<>();
    set6.add(4L);
    testMap.put(7L, set7);
    assertThat(zsk.getConnectedComponentCount(testMap),is(2L));
  }
}
