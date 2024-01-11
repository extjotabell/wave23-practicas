package com.meli.MiniSeries.service;

import com.meli.MiniSeries.dto.MessageDTO;
import com.meli.MiniSeries.dto.MiniSerieReqDTO;
import com.meli.MiniSeries.dto.MiniSerieResDTO;

import java.util.List;

public interface IMiniSerieService {
    List<MiniSerieResDTO> findAll();
    MiniSerieResDTO find(Long id);
    MiniSerieResDTO save(MiniSerieReqDTO miniSerieReqDTO);
    MiniSerieResDTO update(Long id, MiniSerieReqDTO miniSerieReqDTO);
    MessageDTO delete(Long id);
}
