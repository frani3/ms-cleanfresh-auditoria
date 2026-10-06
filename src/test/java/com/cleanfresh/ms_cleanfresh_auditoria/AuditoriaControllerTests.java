package com.cleanfresh.ms_cleanfresh_auditoria;

import com.cleanfresh.ms_cleanfresh_auditoria.controller.AuditoriaController;
import com.cleanfresh.ms_cleanfresh_auditoria.dto.AuditEntry;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AuditoriaControllerTests {

    @Test
    void devuelveLosCuatroEventosDeEjemploConSuNivel() {
        List<AuditEntry> eventos = new AuditoriaController().eventos();

        assertEquals(4, eventos.size());
        assertEquals("info", eventos.get(0).level());
        assertEquals("error", eventos.get(3).level());
    }
}
