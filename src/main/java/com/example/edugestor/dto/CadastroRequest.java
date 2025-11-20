package com.example.edugestor.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public record CadastroRequest(
        @NotEmpty
        String nome,

        @NotEmpty
        @Email(regexp = "[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}",
                flags = Pattern.Flag.CASE_INSENSITIVE,
                message = "O email precisa ser válido.")
        String email,

        @NotEmpty
        String senha
) { }
