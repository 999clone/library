package management;

import library.Member;
import library.Transaction;

import java.util.HashMap;

public class MemberManager {
    // TODO: Define a data structure that stores memberIds and their matching member objects
    private HashMap<String, Member> members;
    public MemberManager() {
        members = new HashMap<>();
    }

    public void addMember(Member member) {
        if (member == null) {
            return;
        }
        members.put(member.getMemberId(), member);
    }

    public Member getMember(String memberId) {
        if (memberId == null) {
            System.out.println("Member id is null");
            return null;
        }
        return members.get(memberId);
    }

    public void recordTransaction(String memberId, Transaction transaction) {
        if (memberId == null) {
            System.out.println("Member id is null");
            return;
        }
        Member member = getMember(memberId);
        if (member == null) {
            System.out.println("Member not found");
            return;
        }
        member.addTransaction(transaction);
    }

    public Transaction getLastTransaction(String memberId) {
        if (memberId == null) {
            System.out.println("Member id is null");
            return null;
        }
        Member member = getMember(memberId);
        if (member == null) {
            System.out.println("Member not found");
            return null;
        }
        return member.getLastTransaction();
    }
}
