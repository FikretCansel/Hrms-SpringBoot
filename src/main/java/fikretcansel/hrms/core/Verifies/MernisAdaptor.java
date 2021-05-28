package fikretcansel.hrms.core.Verifies;

import fikretcansel.hrms.core.Verifies.Mernis.AECKPSPublicSoap;

import java.util.Date;

public class MernisAdaptor implements Adapter{

    private AECKPSPublicSoap aeckpsPublicSoap;

    public MernisAdaptor(){
        this.aeckpsPublicSoap=new AECKPSPublicSoap();
    }

    public boolean TcVertify(String nationalId, String name, String lastName, Date birthDate) throws Exception {

        Long nationalIdLong=Long.parseLong(nationalId);
        int birthDateInteger=(int)(new Date().getTime());


        return aeckpsPublicSoap.TCKimlikNoDogrula(nationalIdLong,name,lastName,birthDateInteger);
    }


}
