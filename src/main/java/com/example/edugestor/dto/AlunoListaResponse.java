package com.example.edugestor.dto;

public record AlunoListaResponse(
        Long matricula,
        String nome,
        String curso,
        String turno
) { }
