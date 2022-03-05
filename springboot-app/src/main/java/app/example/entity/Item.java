package app.example.entity;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.Date;

public class Item implements RepoObj<UUID> {
  private UUID itemId = new UUID(0L, 0L);
  private String title = "";

  public UUID getItemId() {
		return itemId;
	}

  public String getTitle() {
		return title;
	}

	public void setItemId(UUID itemId) {
		this.itemId = itemId;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public UUID getPrimary() {
  	return itemId;
	}
}
