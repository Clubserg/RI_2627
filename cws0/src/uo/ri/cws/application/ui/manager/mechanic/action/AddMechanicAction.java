package uo.ri.cws.application.ui.manager.mechanic.action;

import uo.ri.conf.Factories;
import uo.ri.cws.application.service.mechanic.MechanicCrudService.MechanicDto;
import uo.ri.util.console.Console;
import uo.ri.util.exception.BusinessException;
import uo.ri.util.menu.Action;

public class AddMechanicAction implements Action {

    @Override
    public void execute() throws BusinessException {

        MechanicDto m = new MechanicDto();
        // Get info
        m.nif = Console.readString("nif");
        m.name = Console.readString("Name");
        m.surname = Console.readString("Surname");


        //Process
//        MechanicCrudService service = new MechanicCrudServiceImpl();
//        service.create(m);
        
//        MechanicCrudService service = new ServiceFactoryImpl().forMechanicCrudService();
//        service.create(m);
//        new ServiceFactoryImpl().forMechanicCrudService().create(m);
        
        Factories
            .service
            .forMechanicCrudService()
            .create(m);

        // Print result
        Console.println("Mechanic added");
    }

}
