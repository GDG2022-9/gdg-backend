package com.gdg.gdgbackend.domain.member.entity;

import com.gdg.gdgbackend.domain.base.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "member")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Member extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberId;

    @Column(unique = true, length = 50, nullable = false)
    private String loginId;

    @Column(nullable = false, length = 20)
    private String memberName;

    @Column(length = 200)
    private String password;

    @Column(length = 250)
    private LocalDateTime tripStartDate;

    @Column(length = 250)
    private Integer tripDuration;

    @Builder
    public Member(String loginId, String password, String memberName,
                  LocalDateTime tripStartDate, Integer tripDuration) {
        this.loginId = loginId;
        this.memberName = memberName;
        this.password = password;
        this.tripStartDate = tripStartDate;
        this.tripDuration = tripDuration;
    }

    public static Member createMember(Member member) {
        return Member.builder()
                .loginId(member.getLoginId())
                .memberName(member.getMemberName())
                .password(member.getPassword())
                .tripStartDate(member.getTripStartDate())
                .tripDuration(member.getTripDuration())
                .build();
    }

    public void updateItem(LocalDateTime tripStartDate, Integer tripDuration) {
        this.tripStartDate = tripStartDate;
        this.tripDuration = tripDuration;
    }

}