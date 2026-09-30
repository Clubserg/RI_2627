package uo.ri.cws.application.ui.manager.mechanic.action;

import java.util.Optional;

import uo.ri.conf.Factories;
import uo.ri.cws.application.service.mechanic.MechanicCrudService.MechanicDto;
import uo.ri.util.console.Console;
import uo.ri.util.exception.BusinessException;
import uo.ri.util.menu.Action;

public class UpdateMechanicAction implements Action {




    @Override
    public void execute() throws BusinessException {

        // Get info
        String id = Console.readString("Type mechahic id to update");

        // check mechanic exists
        Optional<MechanicDto> existing = Factories.service
            .forMechanicCrudService()
            .findById(id);
        // Ask for new data
        // nif is the identity, cannot be changed
        String name = Console.readString("Name");
        String surname = Console.readString("Surname");
        existing.get().name = name;
        existing.get().surname = surname;

        // update
//        updateMechanic(id, name, surname);
        Factories.service
            .forMechanicCrudService()
            .update(existing.get());

        // Print result
        Console.println("Mechanic updated");
    }



}