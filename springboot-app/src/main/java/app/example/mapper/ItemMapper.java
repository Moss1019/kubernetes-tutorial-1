package app.example.mapper;

import app.example.entity.*;
import app.example.view.*;

import java.util.*;
import java.util.stream.Collectors;

public class ItemMapper {
	public static ItemView toView(Item item) {
		return new ItemView(item.getItemId(), item.getTitle());
	}

  public static Item toEntity(ItemView itemView) {
		Item item = new Item();
    item.setItemId(itemView.getItemId());
    item.setTitle(itemView.getTitle());
		return item;
	}
}
