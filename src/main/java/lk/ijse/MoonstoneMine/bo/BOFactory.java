package lk.ijse.MoonstoneMine.bo;

import lk.ijse.MoonstoneMine.bo.Custom.Impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){}
    public static BOFactory getBoFactory(){
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }
    public enum BOTypes{
        CUSTOMER,ITEM,PLACE_ORDER,EMPLOYEE,TICKET,ADMINFORM,LOGINFORM,SIGNUPFORM,TICKET_BOOKING
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
                return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
            case EMPLOYEE:
                return new EmployeeBOImpl();
            case TICKET:
                return new TicketBOImpl();
            case ADMINFORM:
                return new AdminFormBOImpl();
            case LOGINFORM:
                return new LoginFormBOImpl();
            case SIGNUPFORM:
                return new SignupFormBOImpl();
            case TICKET_BOOKING:
                return new TicketBookingBOImpl();
            default:
                return null;
        }
    }
}
