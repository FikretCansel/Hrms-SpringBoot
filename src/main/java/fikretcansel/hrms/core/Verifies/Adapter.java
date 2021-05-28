package fikretcansel.hrms.core.Verifies;

import java.util.Date;

public interface Adapter {

    public boolean TcVertify(String nationalId, String name, String lastName, Date birthDate) throws Exception ;

}
