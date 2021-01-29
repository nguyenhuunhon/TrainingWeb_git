package pluginViewAdmin;

import DAO.AccountDAO;
import Model.Account;

import java.util.ArrayList;

public class TableUser {
    public String getContent(){
        String result="";
        ArrayList<Account> listAc=new ArrayList<>(AccountDAO.mapAccountCustomer.values());
        for(Account ac:listAc){
            String role=null;
            if(ac.getRole()==null){
                role="Khách hàng";
            }else{
                role=ac.getRole();
            }
        result+="        <tr>\n" +
                "            <td>"+ac.getIDAccountCustomer()+"</td>\n" +
                "            <td>"+ac.getUserName()+"</td>\n" +
                "            <td>"+ac.getPassword()+"</td>\n" +
                "            <td>"+ac.getCustomerName()+"</td>\n" +
                "            <td>"+ac.getEmail()+"</td>\n" +
                "            <td>"+ac.getDate()+"</td>\n" +
                "            <td>"+role+"</td>\n" +
                "        </tr>\n";
        }
        return result;
    }
}
