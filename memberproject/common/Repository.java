package memberproject.common;

import memberproject.models.ChurchEvent;
import memberproject.models.Expense;
import memberproject.models.Member;
import memberproject.models.Offering;

import java.util.List;

public class Repository implements IRepository {

    private IDataProvider provider;
    private static Repository repo;

    public static Repository Instance(){
        if(repo == null){
            repo = new Repository();
        }

        return repo;
    }

    @Override
    public List<Member> getAllMembers() {
       return provider.getMembers();
    }

    @Override
    public Member getMemberById(int id) {
        return provider.getMemberById(id);
    }

    @Override
    public void saveMember(Member member) {

    }

    @Override
    public List<Offering> getAllOfferings() {
        return null;
    }

    @Override
    public Offering getOfferingById(int id) {
        return null;
    }

    @Override
    public List<Offering> getOfferingsFromMember(int memberId) {
        return null;
    }

    @Override
    public List<Expense> getAllExpenses() {
        return null;
    }

    @Override
    public Expense getExpenseById(int Id) {
        return null;
    }

    @Override
    public List<ChurchEvent> getAllEvents() {
        return null;
    }

    @Override
    public ChurchEvent getEventById(int Id) {
        return null;
    }

    @Override
    public boolean createMember(Member newMember) {
        return false;
    }

    @Override
    public boolean createEvent(ChurchEvent event) {
        return false;
    }

    @Override
    public boolean createExpense(Expense expense) {
        return false;
    }

    @Override
    public void setDataProvider(IDataProvider provider) {
        this.provider = provider;
    }
}
