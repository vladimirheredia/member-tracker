package memberproject.common;

import memberproject.models.Member;

import java.util.List;

public interface IDataProvider {

    List<Member> getMembers();
    Member getMemberById(int Id);
}
