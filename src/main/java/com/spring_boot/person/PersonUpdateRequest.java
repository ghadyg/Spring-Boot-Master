package com.spring_boot.person;

import jakarta.validation.constraints.NotNull;

public record PersonUpdateRequest(@NotNull String  name,@NotNull Integer age) {
}
