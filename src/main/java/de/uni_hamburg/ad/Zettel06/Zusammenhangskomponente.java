package de.uni_hamburg.ad.Zettel06;

import java.util.*;

public class Zusammenhangskomponente {
  
  
  public Long getConnectedComponentCount(Map<Long, Set<Long>> adjazenzMap) {
    Long componentCount = 0L;
    Queue<Long> queue = new LinkedList<>();
    
    // iteriere solange, bis die adjazenzMap leer ist
    while (!adjazenzMap.isEmpty()) {
      
      // hol einen Entry aus der Map (kann beliebig sein) und queue ihn
      queue.offer(adjazenzMap.entrySet().iterator().next().getKey());
      List<Long> componentList = new ArrayList<>();
      
      // arbeite die Queue ab
      while (!queue.isEmpty()) {
        Long head = queue.poll();
        
        // füge den key zur Komponentenliste, falls nicht vorhanden
        if (!componentList.contains(head)) {
          componentList.add(head);
        }
        // füge die values zur Komponentenliste und queue sie, falls nicht vorhanden
        for (var value : adjazenzMap.get(head)) {
          if (!componentList.contains(value)) {
            componentList.add(value);
            queue.offer(value);
          }
        }
        // remove key+value aus der Map wenn diese abgearbeitet wurden
        adjazenzMap.remove(head);
      }
      // wenn die Queue leer ist -> Komponente gefunden
      componentCount++;
    }
    return componentCount;
  }
}




/*
1. Wir gucken uns die erste Reihe in der Map an und packen den Key in die Queue
2. Wir arbeiten die Queue ab:
  2.1 Füge den Key in eine Liste (falls noch nicht vorhanden) und füge danach die Werte in die Liste (falls noch nicht vorhanden)
  2.2 Falls ein Wert hinzugefügt wurde, pack ihn auch in die Queue
  2.3 Wenn alle Werte von einem Entry hinzugefügt wurden, dequeue und aus der Map streichen
3. Wenn die Queue empty ist, KomponentenCount++
4. Wenn die Map noch nicht leer ist, beginne erneut bei 1
 */

