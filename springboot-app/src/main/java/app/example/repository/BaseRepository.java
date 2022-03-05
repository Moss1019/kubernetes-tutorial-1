package app.example.repository;

import app.example.entity.RepoObj;

import java.util.UUID;
import java.util.Map;
import java.util.HashMap;

public class BaseRepository<T extends RepoObj> {
  protected static Map<String, Map<Object, RepoObj>> collections = new HashMap<>();

  protected String collectionName;

  public BaseRepository(String collectionName) {
  this.collectionName = collectionName;
  collections.put(collectionName, new HashMap<>());
  }
}
