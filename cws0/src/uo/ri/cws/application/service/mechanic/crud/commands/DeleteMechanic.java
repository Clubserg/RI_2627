package uo.ri.cws.application.service.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import uo.ri.cws.application.persistence.util.jdbc.Jdbc;
import uo.ri.util.assertion.ArgumentChecks;

public class DeleteMechanic {
    
    private static final String TMECHANICS_DELETE = "DELETE FROM TMECHANICS "
        + "WHERE ID = ?";
    
    private String idMechanic;
    
    public DeleteMechanic(String idMechanic) {
        ArgumentChecks.isNotBlank(idMechanic, "Invalid mechanic id to delete mechanic");
        this.idMechanic = idMechanic;
    }
    
    public void execute() {
        try (Connection c = Jdbc.createThreadConnection();) {
            try (PreparedStatement pst = c
                    .prepareStatement(TMECHANICS_DELETE)) {
                pst.setString(1, idMechanic);
                pst.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
