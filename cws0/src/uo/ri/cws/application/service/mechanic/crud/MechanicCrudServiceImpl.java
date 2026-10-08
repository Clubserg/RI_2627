package uo.ri.cws.application.service.mechanic.crud;

import java.util.List;
import java.util.Optional;

import uo.ri.cws.application.persistence.util.command.CommandExecutor;
import uo.ri.cws.application.service.mechanic.MechanicCrudService;
import uo.ri.cws.application.service.mechanic.crud.commands.AddMechanic;
import uo.ri.cws.application.service.mechanic.crud.commands.DeleteMechanic;
import uo.ri.cws.application.service.mechanic.crud.commands.FindAllMechanics;
import uo.ri.cws.application.service.mechanic.crud.commands.FindMechanicById;
import uo.ri.cws.application.service.mechanic.crud.commands.FindMechanicByNif;
import uo.ri.cws.application.service.mechanic.crud.commands.UpdateMechanic;
import uo.ri.util.exception.BusinessException;

public class MechanicCrudServiceImpl implements MechanicCrudService {
	
	private CommandExecutor executor = new CommandExecutor();

    @Override
    public MechanicDto create(MechanicDto dto) throws BusinessException {
        return executor.execute(new AddMechanic(dto));
    }

    @Override
    public void delete(String mechanicId) throws BusinessException {
        new DeleteMechanic(mechanicId).execute();
        
    }

    @Override
    public void update(MechanicDto dto) throws BusinessException {
        new UpdateMechanic(dto).execute();
        
    }

    @Override
    public Optional<MechanicDto> findById(String id) throws BusinessException {
        return new FindMechanicById(id).execute();
    }

    @Override
    public Optional<MechanicDto> findByNif(String nif) throws BusinessException {
        return new FindMechanicByNif(nif).execute();
    }

    @Override
    public List<MechanicDto> findAll() throws BusinessException {
        return new FindAllMechanics().execute();
    }

}
