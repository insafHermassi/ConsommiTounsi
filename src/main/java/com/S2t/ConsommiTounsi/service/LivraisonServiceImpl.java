package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.Dto.LivraisonDto;
import com.S2t.ConsommiTounsi.Mapper.MapperLivraison;
import com.S2t.ConsommiTounsi.entities.Livraison;
import com.S2t.ConsommiTounsi.entities.Livreur;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;
import com.S2t.ConsommiTounsi.repository.LivraisonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class LivraisonServiceImpl implements LivraisonService {
    @Autowired
    LivraisonRepository livraisonRepository;
    @Autowired
    MapperLivraison mapperLivraison;
    @Autowired
    LivreurService livreurService;
    @Autowired
    CommandService commandService;

    @Override
    public Livraison save(LivraisonDto livraisonDto) throws RessourcesNotFound {

        Livraison livraison = mapperLivraison.dtoToEntity(livraisonDto);
        livraison.calculFrais();
        livraisonRepository.save(livraison);
        return livraison;
    }


    @Override
    public LivraisonDto getLivraison(Long id) throws RessourcesNotFound {
        Livraison livraison = livraisonRepository.findById(id).orElseThrow(() -> new RessourcesNotFound("livraison not found for id :" + id));
        return mapperLivraison.entityToDto(livraison);
    }

    @Override
    public List<LivraisonDto> getLivraisons() {
        List<Livraison> livraisons = (List<Livraison>) livraisonRepository.findAll();
        List<LivraisonDto> livraisonDtos = mapperLivraison.entityListToDto(livraisons);
        return livraisonDtos;
    }

    @Override
    public Map<String, Boolean> deleteLivraison(Long id) throws RessourcesNotFound {
        Livraison livraison = livraisonRepository.findById(id).orElseThrow(
                () -> new RessourcesNotFound("Appointment not found for id : " + id));
        livraisonRepository.delete(livraison);
        Map<String, Boolean> res = new HashMap<>();
        res.put("deleted", Boolean.TRUE);
        return res;
    }

    @Override
    public List<LivraisonDto> getLivraisonByLivreur(Long idLivreur) throws RessourcesNotFound {
        Livreur livreur = livreurService.getLivreur(idLivreur);
        List<Livraison> livraison = livraisonRepository.findByLivreur(livreur);
        List<LivraisonDto> livraisonDtos = mapperLivraison.entityListToDto(livraison);
        return livraisonDtos;
    }

    @Override
    public Livraison update(long id, LivraisonDto livraisonDto) throws RessourcesNotFound {
        return null;
    }
}