package app.example.repository;

import app.example.entity.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class ItemRepository extends BaseRepository<Item> {

  public ItemRepository() {
    super("items");
  }
  
  public Item insert(Item item) {
    collections.get(collectionName)
        .put(item.getPrimary(), item);
    return item;
  }

  public boolean delete(UUID value) {
    Optional<Item> obj = collections.get(collectionName)
        .values()
        .stream()
        .filter(x -> x.getPrimary().equals(value))
        .map(x -> (Item)x)
        .findFirst();
    if(obj.isPresent()) {
      collections.get(collectionName).remove(value);
      return true;
    }
    return false;
  }

  public List<Item> selectAll() {
    return collections.get(collectionName).values()
        .stream()
        .map(x -> {
          Item a = (Item)x;
          return a;
        })
        .collect(Collectors.toList());
  }

  public Item selectByPk(UUID itemId) {
    return collections.get(collectionName).values()
        .stream()
        .filter(x -> x.getPrimary().equals(itemId))
        .map(x -> {
          Item a = (Item)x;
          return a;
        })
        .findFirst().orElse(null);
  }

  public boolean update(Item updated) {
    Optional<Item> item = collections.get(collectionName)
        .values()
        .stream()
        .filter(x -> x.getPrimary().equals(updated.getPrimary()))
        .map(x -> (Item)x)
        .findFirst();
    if(item.isPresent()) {
      collections.get(collectionName).put(updated.getPrimary(), updated);
      return true;
    }
    return false;
  }

  public Item selectByTitle(String value) {
    return collections.get(collectionName)
        .values()
        .stream()
        .map(x -> {
          Item a = (Item)x;
          return a;
        })
        .findFirst().orElse(null);
  }
}
