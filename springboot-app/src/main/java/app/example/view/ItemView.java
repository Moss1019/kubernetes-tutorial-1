package app.example.view;

import java.util.*;

public class ItemView {
  private UUID itemId = new UUID(0L, 0L);
  private String title = "";

  public ItemView() {

  }

  public ItemView(UUID itemId, String title) {
    this.itemId = itemId;
    this.title = title;
	}

  public UUID getItemId() {
		return itemId;
	}

  public String getTitle() {
		return title;
	}
}
