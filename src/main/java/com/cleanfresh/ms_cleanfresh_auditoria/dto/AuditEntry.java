package com.cleanfresh.ms_cleanfresh_auditoria.dto;

public record AuditEntry(String time, String actor, String action, String level) {
}
