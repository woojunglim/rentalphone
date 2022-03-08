package pb.testphone.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pb.testphone.domain.Member;
import pb.testphone.repository.MemberRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor d
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     * @param member
     * @return Member.id
     */
    @Transactional
    private Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복 회원 검증
     * @param member
     */
    private void validateDuplicateMember(Member member) {
        List<Member> findMemebers = memberRepository.findByName(member.getName());
        if (!findMemebers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    /**
     * 전체 회원 조회
     * @return List<Member>
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 단건 조회
     * @param memberId
     * @return Member
     */
    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

}
