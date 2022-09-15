package music_app.controller;

import music_app.model.Music;
import music_app.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller

@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public String list(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList", musicList);
        return "list";
    }
    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute Music music, RedirectAttributes redirectAttributes) {
        music.setId((int) (Math.random() * 10000));
        musicService.save(music);
        redirectAttributes.addFlashAttribute("message", "Create music: " + music.getName() + " OK!");
        return "redirect:/music";
    }
    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Music music) {
        musicService.update(music);
        return "redirect:/music";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "delete";
    }

    @PostMapping("/delete")
    public String delete(Music music, RedirectAttributes redirect) {
        musicService.remove(music.getId());
        redirect.addFlashAttribute("success", "Removed customer successfully!");
        return "redirect:/music";
    }

}
