package com.example.joyerialasperlas.service;

import com.example.joyerialasperlas.dto.JewelCreationDTO;
import com.example.joyerialasperlas.dto.JewelDTO;
import com.example.joyerialasperlas.dto.JewelIdDTO;
import com.example.joyerialasperlas.dto.MessageJewelDTO;
import com.example.joyerialasperlas.exception.JewelNotFoundException;
import com.example.joyerialasperlas.model.Jewel;
import com.example.joyerialasperlas.repository.IJewelRepository;
import com.example.joyerialasperlas.exception.IllegalJewelCreationException;
import com.example.joyerialasperlas.utils.Mapper;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class JewelService implements IJewelService {
  private final IJewelRepository repository;

  public JewelService(IJewelRepository repository) {
    this.repository = repository;
  }

  @Override
  public JewelIdDTO createJewel(JewelCreationDTO jewelCreationDTO){
    if (!jewelCreationDTO.isOnSale()) {
      throw new IllegalJewelCreationException();
    }
    Jewel jewel = Mapper.jewelCreationDTOToJewel(jewelCreationDTO);
    repository.save(jewel);
    return new JewelIdDTO(jewel.getId());
  }

  @Override
  public List<JewelDTO> getAll() {
    return repository.findAll().stream().filter(Jewel::isOnSale).map(Mapper::jewelToJewelDTO).toList();
  }

  @Override
  public String deleteJewel(Long id) {
   Jewel jewel =  getJewelById(id);
   jewel.setOnSale(false);
   repository.save(jewel);
   return "The jewel has been deleted";
  }

  @Override
  public MessageJewelDTO updateJewel(JewelCreationDTO jewelDTO, Long id) {
    Jewel jewel = getJewelById(id);
    jewel.setName(jewelDTO.getName());
    jewel.setParticularity(jewelDTO.getParticularity());
    jewel.setMaterial(jewelDTO.getMaterial());
    jewel.setWeight(jewelDTO.getWeight());
    jewel.setOnSale(jewelDTO.isOnSale());
    jewel.setHaveStone(jewelDTO.isHaveStone());
    repository.save(jewel);
    JewelDTO jewelResponse = Mapper.jewelToJewelDTO(jewel);
    System.out.println(jewelResponse);
    return new MessageJewelDTO(200, jewelResponse);
  }

  private Jewel getJewelById(Long id){
    return repository.findById(id).orElseThrow(()->new JewelNotFoundException(id));
  }
}
