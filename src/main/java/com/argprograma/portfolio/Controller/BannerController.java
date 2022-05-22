
package com.argprograma.portfolio.Controller;

import com.argprograma.portfolio.Service.IService;
import com.argprograma.portfolio.Modelo.Banner;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/banners")
public class BannerController {
    
    @Autowired
    private IService<Banner> bannerServ;
    
    @GetMapping("/all")
    @ResponseBody
    public ResponseEntity<List<Banner>> buscarBanner(){
        List<Banner> todosLosBanners = bannerServ.buscarObjetos();
        return new ResponseEntity<>(todosLosBanners, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/{id}")
    public ResponseEntity<Banner> buscarBannerByID(@PathVariable("id") Long id){
        Banner bannerEncontrado = bannerServ.buscarObjetoById(id);
        return new ResponseEntity<>(bannerEncontrado, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Banner> crearBanner(@RequestBody Banner banner){
        Banner nuevoBanner = bannerServ.crearObjeto(banner);
        return new ResponseEntity<>(nuevoBanner, HttpStatus.CREATED);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Banner> editarBanner(@RequestBody Banner banner){
        Banner bannerEditado = bannerServ.editarObjeto(banner);
        return new ResponseEntity<>(bannerEditado, HttpStatus.OK);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrarBanner(@PathVariable("id") Long id){
        bannerServ.borrarObjetoById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
