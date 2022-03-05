package app.example.entity;

public interface JoinedRepoObj<T, K> extends RepoObj<T> {
  K getSecondary();
}
