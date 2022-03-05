package app.example.service;

import org.springframework.stereotype.Service;

import org.springframework.beans.factory.annotation.Autowired;

import app.example.entity.*;
import app.example.view.*;
import app.example.mapper.*;
import app.example.repository.*;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ItemService {
	@Autowired
	private ItemRepository repo;

	public ItemView insert(ItemView newItem) {
		Item item = ItemMapper.toEntity(newItem);item.setItemId(UUID.randomUUID());
		Item result = repo.insert(item);
		return ItemMapper.toView(result);
	}

	public ItemView selectByPk(UUID value) {
		Item dbResult = repo.selectByPk(value);
		if(dbResult == null) {
			return null;
		}
		return ItemMapper.toView(dbResult);
	}

	public List<ItemView> selectAll() {
		List<Item> dbResult = repo.selectAll();
		return dbResult
			.stream()
			.map(x -> ItemMapper.toView(x))
			.collect(Collectors.toList());
	}

	public boolean update(ItemView updatedItem) {
		return repo.update(ItemMapper.toEntity(updatedItem));
	}

	public boolean delete(UUID id) {
		return repo.delete(id);
	}

		public ItemView selectByTitle(String value) {
		Item dbResult = repo.selectByTitle(value);
		if(dbResult == null) {
			return null;
		}
		return ItemMapper.toView(dbResult);
	}
}
