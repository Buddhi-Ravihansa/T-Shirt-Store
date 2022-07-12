package com.sunmass.demo.cloth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class Clothcontroller {

    @Autowired private ClothService service1;
    @Autowired private BrandService service2;


    @GetMapping("/clothes")
    public String showClothList(Model model) {
        List<Cloth> listClothes = service1.listAll();

        model.addAttribute("listClothes", listClothes);

        return "clothes";
    }

    @GetMapping("/clothes/new")
    public String showNewCloth(Model model) {
        model.addAttribute("cloth", new Cloth());
        List<Brand> listBrands = service2.listAll();
        model.addAttribute("listBrands", listBrands);
        model.addAttribute("pageTitle", "Add New Dress..");
        return "cloth_form";
    }

    @PostMapping("/clothes/save")
    public String saveCloth(Cloth cloth, RedirectAttributes rad){
        service1.save(cloth);
        rad.addFlashAttribute("message", "The cloth has saved successfully");

        return "redirect:/clothes";
    }

    @GetMapping("/clothes/edit/{id}")
    public String showEditForm(@PathVariable("id") Integer id, Model model, RedirectAttributes rad){
        try {
            Cloth cloth= service1.get(id);
            List<Brand> listBrands = service2.listAll();
            model.addAttribute("listBrands", listBrands);
            model.addAttribute("cloth", cloth);
            model.addAttribute("pageTitle", "EditCloth( ID:" +id + ")");
            return "cloth_form";
        } catch (ClothNotFoundException e) {
            rad.addFlashAttribute("message", e.getMessage());
            return "redirect:/clothes";
        }
    }

    @GetMapping("/clothes/delete/{id}")
    public String deleteCloth(@PathVariable("id") Integer id, RedirectAttributes rad){
        try {
            service1.delete(id);
            rad.addFlashAttribute("message", "The cloth ID " +id+ " has been deleted.");
        } catch (ClothNotFoundException e) {
            rad.addFlashAttribute("message", e.getMessage());
        }
        return "redirect:/clothes";
    }
}
