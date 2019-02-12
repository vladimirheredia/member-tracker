package memberproject.common;

import memberproject.models.ChurchEvent;
import memberproject.models.Expense;
import memberproject.models.Member;
import memberproject.models.Offering;

import java.util.List;

public interface IRepository {
     List<Member> getAllMembers();
     Member getMemberById(int id);
     void saveMember(Member member);
     List<Offering> getAllOfferings();
     Offering getOfferingById(int id);
     List<Offering> getOfferingsFromMember(int memberId);
     List<Expense> getAllExpenses();
     Expense getExpenseById(int Id);
     List<ChurchEvent> getAllEvents();
     ChurchEvent getEventById(int Id);
     boolean createMember(Member newMember);
     boolean createEvent(ChurchEvent event);
     boolean createExpense(Expense expense);
     void setDataProvider(IDataProvider provider);
}
