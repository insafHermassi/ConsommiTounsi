package com.S2t.ConsommiTounsi.service;

import com.S2t.ConsommiTounsi.Dto.LivraisonDto;
import com.S2t.ConsommiTounsi.entities.Livraison;
import com.S2t.ConsommiTounsi.exception.RessourcesNotFound;

import java.util.List;
import java.util.Map;

public interface LivraisonService {
    public Livraison save(LivraisonDto livraisonDto) throws RessourcesNotFound;
    public LivraisonDto getLivraison(Long id) throws RessourcesNotFound;
    public List<LivraisonDto> getLivraisons();
    public Map<String,Boolean> deleteLivraison(Long id) throws RessourcesNotFound;
    public List<LivraisonDto>getLivraisonByLivreur(Long idLivreur)throws RessourcesNotFound;
    public Livraison update(long id, LivraisonDto livraisonDto) throws RessourcesNotFound;
}

