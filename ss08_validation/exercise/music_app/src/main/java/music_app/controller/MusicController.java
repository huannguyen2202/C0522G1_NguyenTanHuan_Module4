package music_app.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import music_app.dto.MusicDto;
import music_app.model.Music;
import music_app.service.IMusicService;

@Controller
@RequestMapping("/music")
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping("")
    public String list(Model model) {
        model.addAttribute("musicList", iMusicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("musicDto", new MusicDto());
        return "create";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult, Music music, RedirectAttributes redirectAttributes) {

        new MusicDto().validate(musicDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "create";
        } else {
            Music music1 = new Music();
            BeanUtils.copyProperties(musicDto, music1);
            iMusicService.save(music);
            redirectAttributes.addFlashAttribute("message", "Create blog: " + music.getName() + " OK!");
            return "redirect:/music";
        }
    }

    @GetMapping("/{id}/edit")
    public String editMusic(@PathVariable int id, Model model) {
        MusicDto musicDto = new MusicDto();
        Music music = iMusicService.findById(id);
        BeanUtils.copyProperties(music, musicDto);
        model.addAttribute("musicDto", musicDto);
        return "edit";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute @Validated MusicDto musicDto, BindingResult bindingResult,
                         RedirectAttributes redirectAttributes) {
        new MusicDto().validate(musicDto, bindingResult);

        if (bindingResult.hasFieldErrors()) {
            return "edit";
        } else {
            Music music = new Music();

            BeanUtils.copyProperties(musicDto, music);

            iMusicService.update(music);
            redirectAttributes.addFlashAttribute("mess", "Add new successful!!");
            return "redirect:/music";
        }

    }
}
