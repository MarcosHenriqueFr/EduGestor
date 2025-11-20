package com.example.edugestor.dto;

import com.example.edugestor.model.enums.Cargo;
import com.example.edugestor.model.enums.Setor;

public record CadastroResponse (
    String nome,
    String email,
    Setor setor,
    Cargo cargo
) { }
