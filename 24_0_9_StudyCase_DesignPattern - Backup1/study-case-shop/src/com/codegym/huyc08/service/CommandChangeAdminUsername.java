package com.codegym.huyc08.service;

import com.codegym.huyc08.menu.Command;
import com.codegym.huyc08.service.chainChangeAdminName.ChangeAdminUsername;
import com.codegym.huyc08.service.chainChangeAdminName.RequestChangeAdminUsername;
import com.codegym.huyc08.service.chainChangeAdminName.ValidateAdminExist;
import com.codegym.huyc08.service.chainChangeAdminName.ValidateAdminFollowRegex;

import java.util.Scanner;

public class CommandChangeAdminUsername implements Command {
    private final Scanner SCANNER = new Scanner(System.in);
    @Override
    public void execute() {
        System.out.println("Input new admin name");
        String newAdminName = SCANNER.next();

        //Validate admin name like admin - admin name exist - change admin name
        Handler changeAdminName = new ChangeAdminUsername(null);
        Handler validateAdminExist = new ValidateAdminExist(changeAdminName);
        Handler validateAdminFollowRegex = new ValidateAdminFollowRegex(validateAdminExist);
        validateAdminFollowRegex.handle(new RequestChangeAdminUsername(newAdminName));
    }
}
