package uo.ri.cws.application.service.mechanic.crud.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.UUID;

import uo.ri.cws.application.persistence.util.jdbc.Jdbc;
import uo.ri.cws.application.service.mechanic.MechanicCrudService.MechanicDto;
import uo.ri.util.assertion.ArgumentChecks;

public class UpdateMechanic {
    
    private static final String TMECHANICS_UPDATE = 
        "update TMechanics set name = ?, surname = ?, "
        + "version = version + 1, updatedat = ?"
        + "where id = ?";
    
    MechanicDto m = new MechanicDto();
    
    public UpdateMechanic(MechanicDto dto) {
        ArgumentChecks.isNotNull(dto, "invalid null dto to create mechanic");
        ArgumentChecks.isNotBlank(dto.name, "Invalid name to create mechanic");
        ArgumentChecks.isNotBlank(dto.surname, "Invalid surname to create mechanic");
        


        m.name = dto.name;
        m.surname = dto.surname;
        
        m.id = UUID.randomUUID().toString();


    }
    
    public void execute() {
        // Process
        try (Connection c = Jdbc.createThreadConnection()) {
            try (PreparedStatement pst = c
                    .prepareStatement(TMECHANICS_UPDATE)) {
                pst.setString(1, m.name);
                pst.setString(2, m.surname);
                pst.setTimestamp(3, new Timestamp(
                        System.currentTimeMillis()));
                pst.setString(4, m.id);

                pst.executeUpdate();
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
