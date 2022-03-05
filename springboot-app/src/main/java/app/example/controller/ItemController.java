package app.example.controller;

import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.UUID;

import app.example.view.*;
import app.example.service.*;

@RequestMapping(value = "/api/items")
@Controller
public class ItemController {
	@Autowired
	private ItemService service;
  
	@RequestMapping(value = "", method = RequestMethod.POST)
	public ResponseEntity<?> insert(@RequestBody ItemView newItem) {
		ItemView result = service.insert(newItem);
		if (result == null) {
			return ResponseEntity.status(400).body("Could not create new Item");
		}
		return ResponseEntity.ok(result);
	}

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<?> selectAll() {
        List<ItemView> result = service.selectAll();
        if (result.size() == 0) {
            return ResponseEntity.status(404).body("No results");
        }
        return ResponseEntity.ok(result);
    }

	@RequestMapping(value = "{value}", method = RequestMethod.GET)
	public ResponseEntity<?> getByPk(@PathVariable UUID value) {
		ItemView result = service.selectByPk(value);
		if (result == null) {
			return ResponseEntity.status(404).body("Could not find Item with id " + value);
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@RequestBody ItemView updatedItem) {
		boolean result = service.update(updatedItem);
		if (!result) {
			return ResponseEntity.status(400).body("Could not update Item");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable UUID id) {
		boolean result = service.delete(id);
		if (!result) {
			return ResponseEntity.status(400).body("Could not delete Item");
		}
		return ResponseEntity.ok(result);
	}

	@RequestMapping(value = "byTitle/{title}", method = RequestMethod.GET)
	public ResponseEntity<?> selectByTitle(@PathVariable String title) {
		ItemView result = service.selectByTitle(title);
		if (result == null) {
			return ResponseEntity.status(404).body("Could not find item by " + title);
		}
		return ResponseEntity.ok(result);
	}
}
