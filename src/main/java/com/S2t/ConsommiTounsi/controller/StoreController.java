package com.S2t.ConsommiTounsi.controller;

import com.S2t.ConsommiTounsi.entities.Category;
import com.S2t.ConsommiTounsi.entities.Store;
import com.S2t.ConsommiTounsi.entities.TypeRay;
import com.S2t.ConsommiTounsi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Store")
public class StoreController extends BasicController {
    @Autowired
    StoreService storeService;

    @PostMapping
    public Store saveStore(@RequestBody Store store) {

        return storeService.Save(store);
    }

    @GetMapping
    public List<Store> getStore() {
        return storeService.getStore();
    }

    @GetMapping(value = "/{id}")

    public Store getStore(@PathVariable("id") long id) {
        return storeService.getStore(id);
    }

    @DeleteMapping
    public Map<String, Boolean> deleteStore(@RequestParam("id") long id) {
        return storeService.deleteStore(id);
    }


    @PutMapping
    public Store updateStore(@RequestParam("id") long id, @RequestBody Store store) {
        return storeService.updateStore(id, store);
    }

    @GetMapping(value = "/find")
    public List<Store> getBycategory(@RequestParam("category") Category category) {
        return storeService.searchByCategory(category);
    }

    @GetMapping(value = "/search")
    public List<Store> getBytypeRay(@RequestParam("typeRay") TypeRay typeRay) {
        return storeService.findBytypeRay(typeRay);
    }
}
