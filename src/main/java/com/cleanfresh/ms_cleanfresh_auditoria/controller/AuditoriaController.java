package com.cleanfresh.ms_cleanfresh_auditoria.controller;

import com.cleanfresh.ms_cleanfresh_auditoria.dto.AuditEntry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Esqueleto de EP2: devuelve una respuesta fija, con la misma forma de datos
 * que hoy usa la pestaña "Registro de auditoría" del panel Admin. El registro
 * real de acciones y accesos denegados llega en la siguiente entrega.
 */
@RestController
@RequestMapping("/api/auditoria")
public class AuditoriaController {

    @GetMapping
    public List<AuditEntry> eventos() {
        return List.of(
                new AuditEntry("11:32", "operador@cf.co", "Actualizó ORD-2047 → EN_PREPARACION", "info"),
                new AuditEntry("11:05", "admin@cf.co", "Modificó precio de catálogo (Planchado)", "warn"),
                new AuditEntry("10:48", "auth.cognito", "Token JWT renovado (AWS Cognito)", "info"),
                new AuditEntry("10:12", "system", "Intento de acceso rechazado (rol insuficiente)", "error")
        );
    }
}
